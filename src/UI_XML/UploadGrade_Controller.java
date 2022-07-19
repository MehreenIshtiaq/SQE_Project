package UI_XML;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import businessLogic.Attendance;
import businessLogic.Course;
import businessLogic.FebrecatedGrade;
import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class UploadGrade_Controller {


	LMS lms= LMS.getInstance();
	
	
	@FXML
	private ComboBox<String> courseCB;
	private ObservableList<String> courseList;
	ArrayList <String>list;// for combo box
	
	
	@FXML
	private TextField section;

	ArrayList<FebrecatedGrade> gradesList;//=lms.getCourses(courseCB.getValue());
	ObservableList <FebrecatedGrade> data;//= FXCollections.observableArrayList(course);	
	

	@FXML
	private TableView<FebrecatedGrade> gradeTable;
	private static TableView<FebrecatedGrade> gradeTable2;

	


	TableColumn<FebrecatedGrade, String> rollNumber;
	TableColumn<FebrecatedGrade, String> courseCode;
	TableColumn<FebrecatedGrade, String> grade;
	
	
	@FXML
	private void initialize() {
		
		list= new ArrayList<String>();
		list=lms.getAssignCourses(lms.currnetTeacherLogin().getEmployeeID());

		courseList= (ObservableList<String>) FXCollections.observableArrayList(list);
		courseCB.setValue("Select Course");
		courseCB.setItems(courseList);


		rollNumber=  new TableColumn("Roll Number");
		courseCode=  new TableColumn("Course Code");
		//courseName=  new TableColumn("Course Name");
		//type=  new TableColumn("Type");
		grade=  new TableColumn("Grade");
		gradeTable.getColumns().addAll(rollNumber,grade, courseCode);

		
		rollNumber.setMaxWidth(200);
		courseCode.setMaxWidth(200);
		grade.setMaxWidth(200);

	}

//	void tableInit() {
//	}

	@FXML
	void uploadBtn(ActionEvent event) throws IOException , SQLException {

		gradeTable2=gradeTable;
		
		gradeTable.getSelectionModel().selectAll();
		ObservableList <FebrecatedGrade> listG=  gradeTable2.getSelectionModel().getSelectedItems();

		for(int i=0; i<listG.size(); i++){
			
			System.out.println("THE courses  " + listG.get(i).getGrade());
			
		}
		//String rLNum= lms.currentLogin().getRollNumber();
		
		lms.uploadGrade(listG);

		gradeTable.getItems().clear();
		
	}


	@FXML
	void selectBtn(ActionEvent event) throws IOException  {
		 gradesList=lms.getCourses(courseCB.getValue(), section.getText());
	     data= FXCollections.observableArrayList(gradesList);
	     
	     
			courseCode.setCellValueFactory(new PropertyValueFactory<FebrecatedGrade,String>("courseCode"));
			rollNumber.setCellValueFactory(new PropertyValueFactory<FebrecatedGrade,String>("rollNumber"));
			grade.setCellValueFactory(new PropertyValueFactory<FebrecatedGrade, String>("grade") );

			gradeTable.setItems(data);
			gradeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			editableCol();
	}

	private void editableCol() {

		grade.setCellFactory(TextFieldTableCell.forTableColumn());

		grade.setOnEditCommit(e->{

			e.getTableView().getItems().get(e.getTablePosition().getRow()).setGrade(e.getNewValue());

		});

		gradeTable.setEditable(true);

	}
	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		Main main= new Main();
		String fxmlDocPath = "src/UI_XML/Teacher_Home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);

	}



	@FXML
	void updateAttendance(ActionEvent event) {

	}

	@FXML
	void makeAnnouncement(ActionEvent event) {

	}


	@FXML
	void updateMarks(ActionEvent event) {

	}

	@FXML
	void uploadAssignment(ActionEvent event) {

	}

	@FXML
	void uploadAttendance(ActionEvent event) {

	}



	@FXML
	void uploadSlides(ActionEvent event) {

	}

	@FXML
	void uploadStudentMarks(ActionEvent event) {

	}

}
