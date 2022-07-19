package UI_XML;


import java.io.IOException;
import java.util.ArrayList;

import businessLogic.Course;
import businessLogic.LMS;
import businessLogic.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class  CourseRegistration  {

	@FXML
	private TableView<Course> courseTableView;
	LMS lms= LMS.getInstance();
	ArrayList<Course> course=lms.getCourses();
    final ObservableList <Course> data= FXCollections.observableArrayList(course);	

    

	@FXML
	private TextArea textArea;



	@FXML
	void selectionButton(ActionEvent event)  throws IOException {

		String textAreaString="";
		ObservableList listOfCourse= courseTableView.getSelectionModel().getSelectedItems();
		 	                      
		for(int i=0; i< listOfCourse.size();i++) {
			
			textAreaString = textAreaString+ " "+(i+1)+". "+ listOfCourse.get(i)+"\n";
		}
		
		
		
		textArea.setText(textAreaString);
	}


	@FXML
	void registrationButton(ActionEvent event) throws IOException {

		
		Student student = new Student();
		//student=lms.currentLogin(userName, password);
		student=lms.currentLogin();
		
		//System.out.println(student.getRollNumber()+" "+student.getPassword());
		ArrayList<String> course = new ArrayList<>();
		
		for(int i=0; i<courseTableView.getSelectionModel().getSelectedItems().size();i++) {
			
			course.add(courseTableView.getSelectionModel().getSelectedItems().get(i).getCourseCode());;
			
		}
		
		String grade= "I";
		for(int i=0; i<course.size();i++) {
			
			lms.registerCourse( course.get(i), student.getRollNumber(), grade);
		}
		
		
		
		//courseTableView.refresh();
		
		


	}

	@FXML
	private void initialize() {


		
		TableColumn courseName=new TableColumn("Course Name");
		TableColumn courseCode=new TableColumn("Course Code");
		TableColumn creditHours=new TableColumn("Credit Hours");
		TableColumn type=new TableColumn("Type");
		courseTableView.getColumns().addAll(courseName, courseCode,creditHours,type);


		//3rd Step
		courseName.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
		courseCode.setCellValueFactory(new PropertyValueFactory<Course,String>("courseCode"));
		creditHours.setCellValueFactory(new PropertyValueFactory<Course,String>("creditHours"));
		type.setCellValueFactory(new PropertyValueFactory<Course,String>("type"));
		//4th step 
		courseTableView.setItems(data);

		courseTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}
	
	
    @FXML
    void homeBtn(ActionEvent event)  throws IOException{

    	Main main= new Main();
    	
    	String fxmlDocPath = "src/UI_XML/Student_Home.fxml";
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
	void viewAnnouncement(ActionEvent event) {

	}

	@FXML
	void viewAttendance(ActionEvent event) {

	}

	@FXML
	void viewMarks(ActionEvent event) {

	}

	@FXML
	void viewSlide(ActionEvent event) {

	}

	@FXML
	void viewTranscript(ActionEvent event) {

	}

}
