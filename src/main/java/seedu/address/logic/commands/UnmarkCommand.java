package seedu.address.logic.commands;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.student.Student;

public class UnmarkCommand extends Command {

    private Index classGroupIndex;
    private Index weekIndex;
    private Optional<List<Student>> students;
    private boolean isAllStudents;

    /**
     * Creates a UnmarkCommand to unmark the attendance for the students in the specified class and week.
     */
    public UnmarkCommand(Index classGroupIndex, Index weekIndex, Optional<List<Student>> students,
                         boolean isAllStudents) {
        this.classGroupIndex = classGroupIndex;
        this.weekIndex = weekIndex;
        this.students = students;
        this.isAllStudents = isAllStudents;
    }

    @Override
    public CommandResult execute(Model model) {
        String result = "";
        return new CommandResult(result);
    }
}
