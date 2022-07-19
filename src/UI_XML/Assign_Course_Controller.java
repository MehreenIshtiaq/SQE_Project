package UI_XML;

import java.io.IOException;
import java.util.ArrayList;

import businessLogic.Course;
import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class Assign_Course_Controller {


	@FXML
	private TableView<Course> courseTableView;
	LMS lms= LMS.getInstance();
	ArrayList<Course> course=lms.getCourses();
	final ObservableList <Course> data= FXCollections.observableArrayList(course);	

	@FXML
	private TextField teacherID;
	@FXML
	private TextField courseCode;


	//	@FXML
	//	void addCoursesList(ActionEvent event) throws IOException {
	//
	////		ObservableList listOfCourse= courseTableView.getSelectionModel().getSelectedItems();
	////
	////		//listOfCourse.add(0, event);
	////
	////		for(int i=0; i<listOfCourse.size();i++) {
	////
	////			listViewCourse.setItems(listOfCourse);
	////			
	////		}
	//		
	//		TablePosition position= courseTableView.getSelectionModel().getSelectedCells().get(0);
	//		int row= position.getRow();
	//		Course course=(Course) courseTableView.getItems().get(row);
	//		TableColumn tableCoulmn = position.getTableColumn();
	//		ObservableList listOfCourse=  (ObservableList) tableCoulmn.getCellObservableValue(course).getValue();
	//		
	//         ObservableList<String> data=(ObservableList<String>) tableCoulmn.getCellObservableValue(course).getValue();		
	//       
	//         listViewCourse.setItems(data);
	//		
	//         
	//
	//	}

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
		courseCode.setCellFactory(TextFieldTableCell.forTableColumn());
		courseTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//courseTableView.getSelectionModel().setCellSelectionEnabled(true);

	}


	@FXML
	void assignCourse(ActionEvent event) throws IOException{


		//		System.out.println("Assigned "+ courseCode.getText()+" "+teacherID.getText());

		lms.assignCourse(courseCode.getText(), teacherID.getText());

	}

	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		Main main= new Main();
		String fxmlDocPath = "src/UI_XML/Admin_home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);
	}

	@FXML
	void addCourse(ActionEvent event) throws IOException {

	}

	@FXML
	void addTeacher(ActionEvent event) throws IOException {

	}

	@FXML
	void deleteAccount(ActionEvent event) throws IOException{

	}

	@FXML
	void generateFeeChallan(ActionEvent event) throws IOException{

	}

	@FXML
	void studentEnrollment(ActionEvent event) throws IOException{

	}

	@FXML
	void updateStudentRecord(ActionEvent event) throws IOException{

	}

	@FXML
	void updateTeacherRecord(ActionEvent event) throws IOException{

	}

}
