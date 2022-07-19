package UI_XML;

import java.io.IOException;

import businessLogic.LMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Add_Course_Controller {

	LMS lms= LMS.getInstance();

	@FXML
	private Button addButton;
	@FXML
	private TextField prerequisite;

	@FXML
	private TextField courseGrade;

	@FXML
	private TextField courseCode;

	@FXML
	private TextField courseName;

	@FXML
	private TextField courseType;

	@FXML
	private TextField creditHours;


	@FXML
	void addCourse(ActionEvent event) throws IOException {


		lms.addNewCourse(courseName.getText(), courseCode.getText(), creditHours.getText(), courseType.getText(), courseGrade.getText());
		System.out.println("Course Added");
	}


	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		Main main= new Main();
		String fxmlDocPath = "src/UI_XML/Admin_home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);
	}

	@FXML
	void addTeacher(ActionEvent event) throws IOException{



	}

	@FXML
	void deleteAccount(ActionEvent event) throws IOException {

	}

	@FXML
	void generateFeeChallan(ActionEvent event) throws IOException{

	}

	@FXML
	void studentEnrollment(ActionEvent event) throws IOException {

	}

	@FXML
	void updateStudentRecord(ActionEvent event) throws IOException{

	}

	@FXML
	void updateTeacherRecord(ActionEvent event) throws IOException {

	}

}
