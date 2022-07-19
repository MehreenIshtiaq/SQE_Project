package UI_XML;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import businessLogic.Assessment;
import businessLogic.Attendance;
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

public class uploadMarks_Controller {

	Main main = new Main();
	LMS lms= LMS.getInstance();

	ObservableList<String> assessmentList= (ObservableList<String>) FXCollections.observableArrayList("Quiz","Assignment","Papers");

	// Display the courses in combo box(select Courses)
	ArrayList <String>list;
	private ObservableList<String> courseList;
	ArrayList<Assessment> marks;
	ObservableList <Assessment> data;


	@FXML
	private ComboBox<String> assessmentType;

	@FXML
	private ComboBox<String> courseName;


	@FXML
	private TableView<Assessment> marksTableView;
	
	private static TableView<Assessment> marksTableView2;

	@FXML
	private TextField section;

	@FXML
	private TextField totalMarks;

	@FXML
	private TextField weightage;

	
	TableColumn<Assessment, String> rollNumber;
	TableColumn<Assessment, String> obtainMarks;
	TableColumn<Assessment, Double> totalMarksClm;
	TableColumn<Assessment, Double> absolutes;
	//TableColumn<Assessment, String> assessmentClm;



	@FXML
	private void initialize() {


		initColumns();
		obtainMarks.setMinWidth(150);
		rollNumber.setMinWidth(150);
		//assessmentClm.setMinWidth(150);
		totalMarksClm.setMinWidth(150);
		absolutes.setMinWidth(150);


		marksTableView.getColumns().addAll(rollNumber, obtainMarks ,totalMarksClm,absolutes);


		assessmentType.setValue("Assessment Type");
		assessmentType.setItems(assessmentList);


		list= new ArrayList<String>();
		list=lms.getAssignCourses(lms.currnetTeacherLogin().getEmployeeID());

		courseList= (ObservableList<String>) FXCollections.observableArrayList(list);


		courseName.setValue("Select Course");
		courseName.setItems(courseList);
	}

	private void initColumns() {

		rollNumber=  new TableColumn("Roll Number");
		obtainMarks=  new TableColumn("Obtain Marks");
		totalMarksClm=  new TableColumn("Total Marks");
		absolutes=  new TableColumn("Absolutes");
		//SN=  new TableColumn("SN");
		//assessmentClm=  new TableColumn("Assessment Name");

	}
	
	@FXML
	void createAssessmentBtn(ActionEvent event) throws IOException {

		
		
	   	marks = lms.getMarksData(courseName.getValue(), section.getText(),Double.parseDouble(totalMarks.getText()), Double.parseDouble(weightage.getText()));
	   	
		data= FXCollections.observableArrayList(marks);	


		//3rd Step
		rollNumber.setCellValueFactory(new PropertyValueFactory<Assessment,String>("rollNumber"));
		obtainMarks.setCellValueFactory(new PropertyValueFactory<Assessment,String>("obtainedMarks"));
		totalMarksClm.setCellValueFactory(new PropertyValueFactory<Assessment,Double>("totalMarks"));
		absolutes.setCellValueFactory(new PropertyValueFactory<Assessment,Double>("absolutes"));
		//SN.setCellValueFactory(new PropertyValueFactory<Assessment,String>("SN"));
		//assessmentClm.setCellValueFactory(new PropertyValueFactory<Assessment,String>("assessmetnName"));

	
		//4th step 
		marksTableView.setItems(data);
		
		marksTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		editableCol();

	}

	private void editableCol() {

		obtainMarks.setCellFactory(TextFieldTableCell.forTableColumn());

		obtainMarks.setOnEditCommit(e->{

			e.getTableView().getItems().get(e.getTablePosition().getRow()).setObtainedMarks(e.getNewValue());
																							
		});

		marksTableView.setEditable(true);

	}
	
	@FXML
	void uploadAssessmentBtn(ActionEvent event) throws IOException, SQLException {

		marksTableView2=marksTableView;
		marksTableView.getSelectionModel().selectAll();
		
		ObservableList <Assessment> assessment=  marksTableView2.getSelectionModel().getSelectedItems();

		
		lms.uploadAssessment(assessment, assessmentType.getValue(), lms.currnetTeacherLogin().getEmployeeID(), section.getText());

		marksTableView.getItems().clear();
		
		
	}

	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/Teacher_Home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void makeAnnouncement(ActionEvent event) {

	}

	@FXML
	void updateAttendance(ActionEvent event) {

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
	void uploadGrade(ActionEvent event) {

	}

	@FXML
	void uploadSlides(ActionEvent event) {

	}

}
