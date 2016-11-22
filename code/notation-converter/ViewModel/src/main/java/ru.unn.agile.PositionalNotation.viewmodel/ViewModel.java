package ru.unn.agile.PositionalNotation.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public ViewModel() {
        number.set("");
        result.set("");
        fromNotation.set(Notation.DECIMAL);
        toNotation.set(Notation.DECIMAL);
        status.set(Status.WAIT.toString());
    }
    public void calculate() {

    }

    public BooleanProperty converterDisabledProperty(String number) {
        if("".equals(number) || number == null) {
            converterDisabled.set(true);
        } else {
            converterDisabled.set(false);
        }
        return converterDisabled;
    }

    public StringProperty numberProperty() {
        return null;
    }

    public StringProperty resultProperty() {
        return result;
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

    public StringProperty statusProperty() {
        return status;
    }
}

enum Status {
    WAIT("Wait a number!"),
    ERROR("This is not a number!");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

