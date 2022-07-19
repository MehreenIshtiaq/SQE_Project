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

public class  Add_Teacher_Controller {

	ObservableList<String> genderList= (ObservableList<String>) FXCollections.observableArrayList("Male","Female","Other");

	LMS lms= LMS.getInstance();

	@FXML
	private TextField confirmPassword;
	@FXML
	private TextField password;

	@FXML
	private Button addTeacher;

	@FXML
	private TextField address;

	@FXML
	private TextField coordinatorID;

	@FXML
	private TextField eMail;

	@FXML
	private TextField employeeID;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField qualification;

	@FXML
	private ComboBox <String> gender;


	@FXML
	private void initialize() {


		gender.setValue("Gender");
		gender.setItems(genderList);
	}


	@FXML
	void addTeacher(ActionEvent event) {

		lms.addTeacher(firstName.getText(), lastName.getText(), address.getText(), employeeID.getText(), eMail.getText(), phoneNumber.getText(), coordinatorID.getText(),qualification.getText(), gender.getValue(),password.getText());

		System.out.println("Teacher added");
	}

	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		Main main= new Main();
		String fxmlDocPath = "src/UI_XML/Admin_home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);
	}

	@FXML
	void addCourse(ActionEvent event) {

	}

	@FXML
	void deleteAccount(ActionEvent event) {

	}

	@FXML
	void generateFeeChallan(ActionEvent event) {

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
