package UI_XML;
import java.io.IOException;

import businessLogic.LMS;
import businessLogic.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;


public class Login_Controller{


	Main main= new Main();
	LMS lms= LMS.getInstance();
	ObservableList<String> genderList= (ObservableList<String>) FXCollections.observableArrayList("Admin","Teacher","Student");



	@FXML
	private RadioButton asStudent;

	@FXML
	private RadioButton asTeacher;

	@FXML
	private Button login;

	@FXML
	private PasswordField password;

	@FXML
	private Text errorText;

	@FXML
	private TextField userName;

	@FXML
	private ComboBox <String> loginAs;


	@FXML
	private void initialize() {


		loginAs.setValue("Login As");
		loginAs.setItems(genderList);
	}


	// Login Student, Teacher, Admin
	@FXML
	void logIn(ActionEvent event) throws IOException {

		// Admin Login 
		if(loginAs.getValue().equals("Admin")) {




			boolean flag= lms.adminLogin(userName.getText(), password.getText());

			if(flag==true) {

				String fxmlDocPath = "src/UI_XML/Admin_home.fxml";
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToNextScreen(s, fxmlDocPath);


			}else {
				errorText.setText("Wrong username or password!");
			}



			// Teacher Login
		} else if(loginAs.getValue().equals("Teacher")){  


			boolean flag= false;


			flag=lms.teacherLogin(userName.getText(), password.getText());

			//System.out.println("Name: "+ student.getFirstName()+" userName: "+ student.getRollNumber());
			if(flag==true) {

				String fxmlDocPath = "src/UI_XML/Teacher_Home.fxml";
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToNextScreen(s, fxmlDocPath);


			}else {
				errorText.setText("Wrong username or password!");
			}



			System.out.println("Teacher search");



			// Student Login
		}else if(loginAs.getValue().equals("Student")){ 

			boolean flag= false;

			//Student student= new Student();

			flag=lms.studentLogin(userName.getText(), password.getText());

			//System.out.println("Name: "+ student.getFirstName()+" userName: "+ student.getRollNumber());
			if(flag==true) {

				String fxmlDocPath = "src/UI_XML/Student_Home.fxml";
				Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
				main.goToNextScreen(s, fxmlDocPath);


			}else {
				errorText.setText("Wrong username or password!");
			}




			System.out.println("Student search");




		}else {

			errorText.setText("required data not found!!");

		}





	}


}
