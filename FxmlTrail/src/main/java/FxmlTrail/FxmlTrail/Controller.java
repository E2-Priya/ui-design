package FxmlTrail.FxmlTrail;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	@FXML

	private TextField inputText;
	@FXML
	private TextArea outputText;

	public Controller() {
	}

	@FXML
	private void initialize() {
	}

	@FXML
	private void printOutput() {
		outputText.setText(inputText.getText());
	}
}
