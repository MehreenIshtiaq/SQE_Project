package UI_XML;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import businessLogic.Attendance;
import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewAttendance_Controller {


	ArrayList <String>list;//= new ArrayList<String>();
	private ObservableList<String> courseList;//= (ObservableList<String>) FXCollections.observableArrayList(list);
	LMS lms= LMS.getInstance();

	@FXML
	private Button checkBtn;
	@FXML
	private ComboBox<String> courseCB;
	@FXML
	private TableView<Attendance> courseViewTable;
	ObservableList <Attendance> data;
	ArrayList<Attendance> attendance;


	

	TableColumn<Attendance, String> status=  new TableColumn("Status");
	TableColumn<Attendance, String> courseCode=  new TableColumn("Course Code");
	TableColumn<Attendance, String> dateD=  new TableColumn("Date");
	
	
	@FXML
	private void initialize() {


		courseViewTable.getColumns().addAll(courseCode, status ,dateD);

		
		list= new ArrayList<String>();
		list=lms.getRegisterCourses(lms.currentLogin().getRollNumber());
		courseList= (ObservableList<String>) FXCollections.observableArrayList(list);


		courseCB.setValue("Select Course");
		courseCB.setItems(courseList);

	}


	@FXML
	void checkBtn(ActionEvent event) throws IOException {

		attendance = lms.viewAttendance(courseCB.getValue(), lms.currentLogin().getRollNumber());
		data= FXCollections.observableArrayList(attendance);	


		courseCode.setCellValueFactory(new PropertyValueFactory<Attendance,String>("courseCode"));
		status.setCellValueFactory(new PropertyValueFactory<Attendance,String>("status"));
		dateD.setCellValueFactory(new PropertyValueFactory<Attendance,String>("date"));

		 
		courseViewTable.setItems(data);
		courseViewTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
	}

	@FXML
	void courseRegistration(ActionEvent event) throws IOException {

	}

	@FXML
	void giveFeedback(ActionEvent event) throws IOException {

	}

	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		Main main= new Main();

		String fxmlDocPath = "src/UI_XML/Student_Home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);


	}

	@FXML
	void submitAssignment(ActionEvent event) {

	}

	@FXML
	void viewAnnouncement(ActionEvent event) {

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
