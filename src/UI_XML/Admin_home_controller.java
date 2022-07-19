package UI_XML;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Admin_home_controller {

	Main main= new Main();



	@FXML
	void logOutAdmin(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/Login.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void link(ActionEvent event) throws IOException , URISyntaxException {

		Desktop.getDesktop().browse(new URI("http://nu.edu.pk/"));
		
	}

	@FXML
	void addCourse(ActionEvent event) throws IOException{

		String fxmlDocPath = "src/UI_XML/AddCourse.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);


	}
	@FXML
	void assignCourse(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/assignCourseTOTeacher.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}


	@FXML
	void addTeacher(ActionEvent event)throws IOException {

		String fxmlDocPath = "src/UI_XML/AddTeacher.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void deleteAccount(ActionEvent event) throws IOException{

		String fxmlDocPath = "src/UI_XML/DeleteFun.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);
	}

	@FXML
	void generateFeeChallan(ActionEvent event) throws IOException{

	}

	@FXML
	void studentEnrollment(ActionEvent event) throws IOException{

		String fxmlDocPath = "src/UI_XML/student_enrollment.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void updateStudentRecord(ActionEvent event) throws IOException {




	}

	@FXML
	void updateTeacherRecord(ActionEvent event) throws IOException{

	}

}
