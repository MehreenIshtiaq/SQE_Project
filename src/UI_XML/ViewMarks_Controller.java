package UI_XML;

import java.io.IOException;
import java.util.ArrayList;

import businessLogic.Assessment;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewMarks_Controller {


	LMS lms= LMS.getInstance();
	Main main = new Main();
	ObservableList<String> assessmentList= (ObservableList<String>) FXCollections.observableArrayList("Quiz","Assignment","Papers");

	ArrayList <String>list;
	private ObservableList<String> courseList;
	ArrayList<Assessment> marks;
	ObservableList <Assessment> data;


	TableColumn<Assessment, Integer> SN;
	TableColumn<Assessment, String> obtainMarks;
	TableColumn<Assessment, Double> totalMarksClm;
	TableColumn<Assessment, Double> absolutes;
	//bleColumn<Assessment, String> assessmentClm;


	@FXML
	private ComboBox<String> assessmentType;
	
    @FXML
    private Text assessmentDisplay;

	@FXML
	private ComboBox<String> courseName;

	@FXML
	private TableView<Assessment> marksTableView;




	@FXML
	private void initialize() throws IOException {


		initColumns();
		obtainMarks.setMinWidth(150);
		SN.setMinWidth(100);
		//assessmentClm.setMinWidth(150);
		totalMarksClm.setMinWidth(150);
		absolutes.setMinWidth(150);


		marksTableView.getColumns().addAll(SN,obtainMarks ,totalMarksClm,absolutes);


		assessmentType.setValue("Assessment Type");
		assessmentType.setItems(assessmentList);


		list= new ArrayList<String>();
		list=lms.getRegisterCourses(lms.currentLogin().getRollNumber());

		courseList= (ObservableList<String>) FXCollections.observableArrayList(list);


		courseName.setValue("Select Course");
		courseName.setItems(courseList);
		
		
	}
	

	private void initColumns() {

		//rollNumber=  new TableColumn("Roll Number");
		obtainMarks=  new TableColumn("Obtain Marks");
		totalMarksClm=  new TableColumn("Total Marks");
		absolutes=  new TableColumn("Absolutes");
		SN=  new TableColumn("SN");
		//assessmentClm=  new TableColumn("Assessment Name");

	}

	@FXML
	void viewMarksBtn(ActionEvent event) throws IOException {



	    assessmentDisplay.setText(assessmentType.getValue());


		marks = lms.viewMarks(courseName.getValue(), assessmentType.getValue(), lms.currentLogin().getRollNumber());

		data= FXCollections.observableArrayList(marks);	


		//3rd Step
		//rollNumber.setCellValueFactory(new PropertyValueFactory<Assessment,String>("rollNumber"));
		obtainMarks.setCellValueFactory(new PropertyValueFactory<Assessment,String>("obtainedMarks"));
		totalMarksClm.setCellValueFactory(new PropertyValueFactory<Assessment,Double>("totalMarks"));
		absolutes.setCellValueFactory(new PropertyValueFactory<Assessment,Double>("absolutes"));
		SN.setCellValueFactory(new PropertyValueFactory<Assessment,Integer>("SN"));
		//assessmentClm.setCellValueFactory(new PropertyValueFactory<Assessment,String>("assessmetnName"));


		//4th step 
		marksTableView.setItems(data);

		marksTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}


	@FXML
	void courseRegistrationBtn(ActionEvent event) throws IOException {

	}

	@FXML
	void giveFeeedbackBtn(ActionEvent event)  throws IOException{

	}

	@FXML
	void homeBtn(ActionEvent event) throws IOException  {

		String fxmlDocPath = "src/UI_XML/Student_Home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}

	@FXML
	void submitAssignmentBtn(ActionEvent event) {

	}

	@FXML
	void viewAnnouncementBtn(ActionEvent event) {

	}

	@FXML
	void viewAttendanceBtn(ActionEvent event) {

	}



	@FXML
	void viewSlideBtn(ActionEvent event) {

	}

	@FXML
	void viewTranscriptBtn(ActionEvent event) {

	}

}
