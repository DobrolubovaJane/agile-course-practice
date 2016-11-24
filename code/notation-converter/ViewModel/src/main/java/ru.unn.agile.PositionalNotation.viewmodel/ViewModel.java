package ru.unn.agile.PositionalNotation.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.PositionalNotation.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jane on 21.11.2016.
 */
public class ViewModel {
    private final ObjectProperty<ObservableList<Notation>> notations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Notation.values()));

    private final ObjectProperty<Notation> toNotation = new SimpleObjectProperty<>();
    private final ObjectProperty<Notation> fromNotation = new SimpleObjectProperty<>();
    private final BooleanProperty converterDisabled = new SimpleBooleanProperty();

    private final StringProperty number = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public ViewModel() {
        number.set("");
        result.set("");
        fromNotation.set(Notation.DECIMAL);
        toNotation.set(Notation.DECIMAL);
        status.set(Status.WAIT.toString());

        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(number, result);
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        converterDisabled.bind(couldCalculate.not());

        // Add listeners to the input text fields
        final List<StringProperty> fields = new ArrayList<StringProperty>() { {
            add(number);
            add(result);
        } };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    public void convert() {
        if (converterDisabled.get()) {
            return;
        }
        result.set(Converter.convert(number.get(),
                fromNotation.get().name(), toNotation.get().name()));
        status.set(Status.SUCCESS.toString());
    }

    public BooleanProperty converterDisabledProperty() {
        return converterDisabled;
    }
    public final boolean getConverterDisabled() {
        return converterDisabled.get();
    }

    public StringProperty numberProperty() {
        return number;
    }
    public StringProperty resultProperty() {
        return result;
    }
    public StringProperty statusProperty() {
        return status;
    }
    public final String getStatus() {
        return status.get();
    }

    public ObjectProperty<ObservableList<Notation>> notationsProperty() {
        return notations;
    }

    public final ObservableList<Notation> getNotations() {
        return notations.get();
    }

    public ObjectProperty<Notation> toNotationProperty() {
        return toNotation;
    }

    public ObjectProperty<Notation> fromNotationProperty() {
        return fromNotation;
    }
    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        String n = number.get();
        if (number.get().isEmpty()) {
            inputStatus = Status.WAIT;
        }
        if (!number.get().isEmpty() && Notation.DECIMAL.equals(fromNotation.get())
                && !n.matches("[1-9]+[0-9]*")) {
            inputStatus = Status.ERROR;
        }
        if (!number.get().isEmpty() && Notation.BINARY.equals(fromNotation.get())
                && !n.matches("1+[01]*")) {
            inputStatus = Status.ERROR;
        }
        if (!number.get().isEmpty() && Notation.OCTAL.equals(fromNotation.get())
                && !n.matches("[1-7]+[0-7]*")) {
            inputStatus = Status.ERROR;
        }
        if (!number.get().isEmpty() && Notation.HEX.equals(fromNotation.get())
                && !n.matches("[1-9a-fA-F]+[0-9a-fA-F]*")) {
            inputStatus = Status.ERROR;
        }
        return inputStatus;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
        }
    }

}

enum Status {
    READY("Enter the button!"),
    WAIT("Wait a number!"),
    ERROR("This is bad format!"),
    SUCCESS("Success!");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }


}

