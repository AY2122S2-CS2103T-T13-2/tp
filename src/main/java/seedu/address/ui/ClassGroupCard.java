package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.ClassGroup;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class ClassGroupCard extends UiPart<Region> {

    private static final String FXML = "ClassGroupListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final ClassGroup classGroup;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public ClassGroupCard(ClassGroup classGroup, int displayedIndex) {
        super(FXML);
        this.classGroup = classGroup;
        id.setText(displayedIndex + ". ");
        name.setText("name");
        phone.setText("phone");
        address.setText("address");
        email.setText("email");
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ClassGroupCard)) {
            return false;
        }

        // state check
        ClassGroupCard card = (ClassGroupCard) other;
        return id.getText().equals(card.id.getText())
                && classGroup.equals(card.classGroup);
    }
}
