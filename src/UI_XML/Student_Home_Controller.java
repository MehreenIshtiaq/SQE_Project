package UI_XML;

import java.io.IOException;

import businessLogic.LMS;
import businessLogic.Student;
import businessLogic.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Student_Home_Controller {

	Main main= new Main();
	LMS lms= LMS.getInstance();

	@FXML
	private Text CNIC;

	@FXML
	private Text address;

	@FXML
	private Text batch;

	@FXML
	private Text degreeName;

	@FXML
	private Text email;

	@FXML
	private Text firstName;

	@FXML
	private Text lastName;

	@FXML
	private Text phoneNumber;

	@FXML
	private Text rollNumber;

	@FXML
	private Text section;

	@FXML
	private Text gender;

	@FXML
	private void initialize() throws IOException {

		Student std= lms.currentLogin();

		CNIC.setText(std.getCNIC());
		address.setText(std.getAddress());
		batch.setText(std.getBatch());
		degreeName.setText(std.getStudentDegree());
		email.setText(std.getEmail());
		firstName.setText(std.getFirstName());
		lastName.setText(std.getLastName());
		phoneNumber.setText(std.getPhoneNumber());
		rollNumber.setText(std.getRollNumber());
		section.setText(std.getSection());
		gender.setText(std.getGender());

	}


	@FXML
	void courseRegistration(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/CourseRegistration.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void logOutStudent(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/Login.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void giveFeedback(ActionEvent event) {

	}

	@FXML
	void submitAssignment(ActionEvent event) {

	}

	@FXML
	void viewAnnouncement(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/ViewAnnouncement.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);
		
	}

	@FXML
	void viewAttendance(ActionEvent event) throws IOException {


		String fxmlDocPath = "src/UI_XML/ViewAttendance.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void viewMarks(ActionEvent event) throws IOException  {

		String fxmlDocPath = "src/UI_XML/ViewMarks.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);


	}

	@FXML
	void viewSlide(ActionEvent event) {

	}

	@FXML
	void viewTranscript(ActionEvent event) throws IOException {
		
	 	    String fxmlDocPath = "src/UI_XML/ViewTranscript.fxml";
			Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
			main.goToNextScreen(s, fxmlDocPath);

	}

}
