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
        assertTrue(viewModel.converterDisabledProperty("").get());
    }

    @Test
    public void canReportNotNumberValue() {
        viewModel.numberProperty().set("a");

        assertEquals("This is not a number!", viewModel.statusProperty().get());
    }

}
