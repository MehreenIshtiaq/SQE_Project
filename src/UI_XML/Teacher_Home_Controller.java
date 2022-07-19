package UI_XML;

import java.io.IOException;

import businessLogic.LMS;
import businessLogic.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Teacher_Home_Controller {


	LMS lms= LMS.getInstance();
	Main main= new Main();

	@FXML
	private Text address;

	@FXML
	private Text coordntID;

	@FXML
	private Text email;

	@FXML
	private Text employeeID;

	@FXML
	private Text firstName;

	@FXML
	private Text gender;

	@FXML
	private Text lastName;

	@FXML
	private Text phoneNumber;

	@FXML
	private Text qualification;


	@FXML
	private void initialize() throws IOException {

		Teacher teacher=lms.currnetTeacherLogin();


		System.out.println("Login: "+ teacher.getFirstName());
		address.setText(teacher.getAddress());
		coordntID.setText(teacher.getCoordinateID());
		email.setText(teacher.geteMail());
		employeeID.setText(teacher.getEmployeeID());
		firstName.setText(teacher.getFirstName());
		gender.setText(teacher.getGender());
		lastName.setText(teacher.getLastName());
		phoneNumber.setText(teacher.getPhoneNumber());
		qualification.setText(teacher.getQualification());

	}

    @FXML
    void logOutTeacher(ActionEvent event) throws IOException {

    	String fxmlDocPath = "src/UI_XML/Login.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);
		
    }

	@FXML
	void uploadAttendance(ActionEvent event) throws IOException {


		String fxmlDocPath = "src/UI_XML/uploadStudent_Attendance.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);
	}

	@FXML
	void updateMarks(ActionEvent event) throws IOException{


		String fxmlDocPath = "src/UI_XML/updateMarks.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void uploadStudentMarks(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/UploadMarks.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);
		
	}

	@FXML
	void makeAnnouncement(ActionEvent event) throws IOException {
		
		
		String fxmlDocPath = "src/UI_XML/MakeAnnouncement.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void updateAttendance(ActionEvent event) throws IOException {

		
		String fxmlDocPath = "src/UI_XML/updateAttendance.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);
	}



	@FXML
	void uploadAssignment(ActionEvent event) throws IOException {

	}



	@FXML
	void uploadGrade(ActionEvent event) throws IOException {
		
		

		String fxmlDocPath = "src/UI_XML/UploadGrade.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);
		

	}

	@FXML
	void uploadSlides(ActionEvent event) throws IOException {

	}


}
