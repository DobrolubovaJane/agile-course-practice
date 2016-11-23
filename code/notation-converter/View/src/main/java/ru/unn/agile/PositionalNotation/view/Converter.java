package ru.unn.agile.PositionalNotation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.PositionalNotation.viewmodel.Notation;
import ru.unn.agile.PositionalNotation.viewmodel.ViewModel;

/**
 * Created by Jane on 21.11.2016.
 */
public class Converter {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField number;
    @FXML
    private TextField result;
    @FXML
    private ComboBox<Notation> fromNotation;
    @FXML
    private ComboBox<Notation> toNotation;
    @FXML
    private Button btnConv;

    @FXML
    void initialize() {

        // Two-way binding hasn't supported by FXML yet, so place it in code-behind
        number.textProperty().bindBidirectional(viewModel.numberProperty());
        result.textProperty().bindBidirectional(viewModel.resultProperty());

        fromNotation.valueProperty().bindBidirectional(viewModel.fromNotationProperty());
        toNotation.valueProperty().bindBidirectional(viewModel.toNotationProperty());


        btnConv.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.convert();
            }
        });
    }
}
