package ru.unn.agile.todoapp.viewmodel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TodoAppViewModelTest {
    private TodoAppViewModel viewModel;
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDate TOMORROW = TODAY.plusDays(1);
    private static final LocalDate DAY_AFTER_TOMORROW = TODAY.plusDays(2);
    private static final String DAY_AFTER_TOMORROW_STRING = DAY_AFTER_TOMORROW.format(
            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private static final String TASK_DESCRIPTION = "Water the plants";
    private static final String NONURGENT_TASK_DESCRIPTION = "Wash the car";
    private static final String URGENT_TASK_DESCRIPTION = "Do taxes";
    private static final String DONE_TASK_DESCRIPTION = "Party with friends";
    private static final String UNDONE_TASK_DESCRIPTION = "Study for exam";

    @Before
    public void setUp() {
        viewModel = new TodoAppViewModel();
    }

    @Test
    public void byDefaultNewTaskDateIsToday() {
        assertEquals(TODAY, viewModel.newTaskDueDateProperty().getValue());
    }

    @Test
    public void byDefaultNewTaskDescriptionIsEmpty() {
        assertEquals("", viewModel.newTaskDescriptionProperty().getValue());
    }

    @Test
    public void byDefaultAddNewTaskButtonIsDisabled() {
        assertTrue(viewModel.addNewTaskButtonDisableProperty().get());
    }

    @Test
    public void whenDescriptionIsNonEmptyAddNewTaskButtonIsEnabled() {
        viewModel.newTaskDescriptionProperty().set(TASK_DESCRIPTION);

        assertFalse(viewModel.addNewTaskButtonDisableProperty().get());
    }

    @Test
    public void whenDescriptionIsClearedAddNewTaskButtonIsDisabled() {
        viewModel.newTaskDescriptionProperty().set(TASK_DESCRIPTION);

        viewModel.newTaskDescriptionProperty().set("");

        assertTrue(viewModel.addNewTaskButtonDisableProperty().get());
    }

    @Test
    public void whenAddingNewTaskDescriptionFieldShouldClear() {
        addTask(viewModel, TASK_DESCRIPTION, DAY_AFTER_TOMORROW);

        assertEquals("", viewModel.newTaskDescriptionProperty().get());
    }

    @Test
    public void whenAddingNewTaskDueDateShouldJumpBackToToday() {
        addTask(viewModel, TASK_DESCRIPTION, DAY_AFTER_TOMORROW);

        assertEquals(TODAY, viewModel.newTaskDueDateProperty().get());
    }

    @Test
    public void whenAddingNewTaskItAppearsInTheList() {
        addTask(viewModel, TASK_DESCRIPTION, DAY_AFTER_TOMORROW);
        TaskListCellViewModel lastTask = viewModel.getSortedTasksViewModels().get(0);

        assertEquals(TASK_DESCRIPTION, lastTask.getDescription());
        assertEquals(DAY_AFTER_TOMORROW_STRING, lastTask.getDueDateString());
        assertFalse(lastTask.doneCheckboxCheckedProperty().get());
    }

    @Test
    public void whenDeleteButtonIsPressedTaskIsDeletedFromTheList() {
        addTask(viewModel, TASK_DESCRIPTION, DAY_AFTER_TOMORROW);

        TaskListCellViewModel deletedTask = viewModel.getSortedTasksViewModels().get(0);
        viewModel.pressDeleteButton(deletedTask);

        assertTrue(viewModel.getSortedTasksViewModels().isEmpty());
    }

    @Test
    public void undoneTasksAreSortedByDueDate() {
        addTask(viewModel, NONURGENT_TASK_DESCRIPTION, DAY_AFTER_TOMORROW);
        addTask(viewModel, URGENT_TASK_DESCRIPTION, TOMORROW);

        assertEquals(URGENT_TASK_DESCRIPTION,
                viewModel.getSortedTasksViewModels().get(0).getDescription());
        assertEquals(NONURGENT_TASK_DESCRIPTION,
                viewModel.getSortedTasksViewModels().get(1).getDescription());
    }

    @Test
    public void doneTasksAreReverseSortedByDueDate() {
        addTask(viewModel, NONURGENT_TASK_DESCRIPTION, DAY_AFTER_TOMORROW);
        addTask(viewModel, URGENT_TASK_DESCRIPTION, TOMORROW);

        viewModel.getSortedTasksViewModels().get(0).clickIsDoneCheckBox();
        viewModel.getSortedTasksViewModels().get(1).clickIsDoneCheckBox();

        assertEquals(NONURGENT_TASK_DESCRIPTION,
                viewModel.getSortedTasksViewModels().get(0).getDescription());
        assertEquals(URGENT_TASK_DESCRIPTION,
                viewModel.getSortedTasksViewModels().get(1).getDescription());
    }

    @Test
    public void undoneTasksAreAboveDoneTasks() {
        addTask(viewModel, UNDONE_TASK_DESCRIPTION, DAY_AFTER_TOMORROW);
        addTask(viewModel, DONE_TASK_DESCRIPTION, DAY_AFTER_TOMORROW);

        viewModel.getSortedTasksViewModels().get(0).clickIsDoneCheckBox();

        assertEquals(UNDONE_TASK_DESCRIPTION,
                viewModel.getSortedTasksViewModels().get(0).getDescription());
        assertEquals(DONE_TASK_DESCRIPTION,
                viewModel.getSortedTasksViewModels().get(1).getDescription());
    }

    private void addTask(TodoAppViewModel viewModel, String description, LocalDate dueDate) {
        viewModel.newTaskDescriptionProperty().set(description);
        viewModel.newTaskDueDateProperty().set(dueDate);
        viewModel.pressAddNewTaskButton();
    }
}
