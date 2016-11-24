package ru.unn.agile.PositionalNotation.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by evdo0116 on 22.11.2016.
 */
public class ViewModelTests {
    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }
    @Test
    public void canSetDefaultValues() {
        assertEquals("", viewModel.numberProperty().get());
        assertEquals("", viewModel.resultProperty().get());
        assertEquals(Notation.DECIMAL, viewModel.fromNotationProperty().get());
        assertEquals(Notation.DECIMAL, viewModel.toNotationProperty().get());
        assertEquals(Status.WAIT.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void calculateButtonIsDisabledIfNumberIsNull() {
        viewModel.numberProperty().set("");
        assertTrue(viewModel.converterDisabledProperty().get());
    }
    @Test
    public void calculateButtonIsEnabledWithIncorrectInput() {
        viewModel.numberProperty().setValue("0");
        assertTrue(viewModel.converterDisabledProperty().get());
    }
    @Test
    public void calculateButtonIsEnabledWithCorrectInput() {
        viewModel.numberProperty().setValue("10");
        assertFalse(viewModel.converterDisabledProperty().get());
    }
     @Test
    public void canConvert10BinaryToDecimal() {
         viewModel.numberProperty().setValue("10");
         viewModel.fromNotationProperty().setValue(Notation.BINARY);
         viewModel.toNotationProperty().setValue(Notation.DECIMAL);
         viewModel.convert();
         assertEquals("2", viewModel.resultProperty().get());
     }
     @Test
     public void canConvert1bHexToOctal() {
         viewModel.numberProperty().setValue("1b");
         viewModel.fromNotationProperty().setValue(Notation.HEX);
         viewModel.toNotationProperty().setValue(Notation.OCTAL);
         viewModel.convert();
         assertEquals("33", viewModel.resultProperty().get());
     }
    @Test
    public void statusIsWaitingWhenConvertWithEmptyNumber() {
        viewModel.convert();
        assertEquals(Status.WAIT.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void statusIsErrorWhenIncorrectBinaryNumber() {
        viewModel.fromNotationProperty().setValue(Notation.BINARY);
        viewModel.numberProperty().setValue("20");
        assertEquals(Status.ERROR.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void statusIsErrorWhenIncorrectDecimalNumber() {
        viewModel.fromNotationProperty().setValue(Notation.DECIMAL);
        viewModel.numberProperty().setValue("0");
        assertEquals(Status.ERROR.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void statusIsErrorWhenIncorrectOctalNumber() {
        viewModel.fromNotationProperty().setValue(Notation.OCTAL);
        viewModel.numberProperty().setValue("8");
        assertEquals(Status.ERROR.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void statusIsErrorWhenIncorrectHexNumber() {
        viewModel.fromNotationProperty().setValue(Notation.HEX);
        viewModel.numberProperty().setValue("g");
        assertEquals(Status.ERROR.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void statusIsReadyWhenCorrectNumber() {
        viewModel.fromNotationProperty().setValue(Notation.HEX);
        viewModel.numberProperty().setValue("1b");
        assertEquals(Status.READY.toString(), viewModel.statusProperty().get());
    }
    @Test
    public void statusIsSuccessWhenConverted() {
        viewModel.fromNotationProperty().setValue(Notation.HEX);
        viewModel.toNotationProperty().setValue(Notation.OCTAL);
        viewModel.numberProperty().setValue("1b");
        viewModel.convert();
        assertEquals(Status.SUCCESS.toString(), viewModel.statusProperty().get());
    }
}
