package seedu.address.ui;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.lesson.Lesson;
import seedu.address.model.student.Student;
import seedu.address.model.studentattendance.Attendance;
import seedu.address.model.studentattendance.StudentAttendance;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class LessonCard extends UiPart<Region> {

    private static final String FXML = "LessonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Lesson lesson;

    @FXML
    private HBox cardPane;
    @FXML
    private Label week;
    @FXML
    private Label absentees;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public LessonCard(Lesson lesson, int displayedIndex) {
        super(FXML);
        this.lesson = lesson;
        week.setText(lesson.getWeekId() + "");
        absentees.setText(getAbsenteeText());
    }

    private String getAbsenteeText() {
        StringBuilder sb = new StringBuilder();
        List<StudentAttendance> studentAttendanceList = lesson.getStudentAttendanceList();
        List<String> absenteeStrings = studentAttendanceList.stream()
                .filter(filterAbsentees())
                .map(this::getAbsenteeString)
                .collect((Collectors.toList()));
        return String.join(",", absenteeStrings);
    }

    private String getAbsenteeString(StudentAttendance studentAttendance) {
        Student student = studentAttendance.getStudent();
        return String.format("%s (%s)", student.getName(), student.getStudentId());
    }

    private Predicate<StudentAttendance> filterAbsentees() {
        return (StudentAttendance studentAttendance) -> {
            Attendance attendance = studentAttendance.getAttendance();
            boolean isAbsent = attendance.toString().equals("0");
            return isAbsent;
        };
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LessonCard)) {
            return false;
        }

        // state check
        LessonCard card = (LessonCard) other;
        return lesson.equals(card.lesson);
    }
}
