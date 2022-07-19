package UI_XML;

import java.io.IOException;

import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Delete_Controller {

	LMS lms= LMS.getInstance();
	@FXML
	private Button addTeacher;

	@FXML
	private TextField deleteID;

	@FXML
	private ComboBox<String> typeCB;

	ObservableList<String> type= (ObservableList<String>) FXCollections.observableArrayList("Teacher","Student");


	@FXML
	private void initialize() {


		typeCB.setValue("Type");
		typeCB.setItems(type);
	}

	@FXML
	void deleteBtn(ActionEvent event)  throws IOException {
		
		lms.deleteAcc(typeCB.getValue(), deleteID.getText());
		

	}

	@FXML
	void addCourse(ActionEvent event) {

	}

	@FXML
	void addTeacher(ActionEvent event) {

	}



	@FXML
	void generateFeeChallan(ActionEvent event) {

	}

	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		Main main= new Main();
		String fxmlDocPath = "src/UI_XML/Admin_home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);
	}


	@FXML
	void studentEnrollment(ActionEvent event) {

	}

	@FXML
	void updateStudentRecord(ActionEvent event) {

	}

	@FXML
	void updateTeacherRecord(ActionEvent event) {

	}

}
