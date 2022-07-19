package UI_XML;

import java.io.IOException;

import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Student_enrollment_Controller {

	LMS lms= LMS.getInstance();

	ObservableList<String> genderList= (ObservableList<String>) FXCollections.observableArrayList("Male","Female","Other");

	@FXML
	private TextField CNIC;

	@FXML
	private TextField address;

	@FXML
	private TextField batch;

	@FXML
	private TextField confirmPassword;

	@FXML
	private TextField degreeName;

	@FXML
	private TextField email;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField password;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField rollNumber;

	@FXML
	private TextField section;
	@FXML
	private Button submit;
	@FXML
	private ComboBox <String> gender;


	@FXML
	private void initialize() {


		gender.setValue("Gender");
		gender.setItems(genderList);
	}

	@FXML
	void genderFun(ActionEvent event) throws IOException{



	}


	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		Main main= new Main();
		String fxmlDocPath = "src/UI_XML/Admin_home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);
	}



	@FXML
	void submitEnrollment(ActionEvent event) throws IOException{



		lms.enrollStudent(degreeName.getText(), rollNumber.getText(), address.getText(), phoneNumber.getText(), 
				firstName.getText(), lastName.getText(), section.getText(), gender.getValue(), batch.getText(), CNIC.getText(), email.getText(), password.getText());

		System.out.println("Saved");


	}

}
