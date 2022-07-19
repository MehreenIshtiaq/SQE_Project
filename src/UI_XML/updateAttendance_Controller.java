package UI_XML;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import businessLogic.Attendance;
import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class updateAttendance_Controller {

	LMS lms= LMS.getInstance();
	Main main= new Main();
	ArrayList<Attendance> attendance;
	ObservableList <Attendance> data;



	@FXML
	private TableView<Attendance> attendanceViewTable;

	private static TableView<Attendance> attendanceViewTable2;

	TableColumn<Attendance, String> status=  new TableColumn("Status");
	TableColumn<Attendance, String> courseCode=  new TableColumn("Course Code");
	TableColumn<Attendance, String> sectionS=  new TableColumn("Section");
	TableColumn<Attendance, String> name=  new TableColumn("Name");
	TableColumn<Attendance, String> rollNo=  new TableColumn("Roll No");
	TableColumn<Attendance, String> dateD=  new TableColumn("Date");
	
	@FXML
	private TextField course;

	@FXML
	private DatePicker date;

	@FXML
	private TextField section;


	@FXML
	private void initialize() {


		attendanceViewTable.getColumns().addAll(courseCode, sectionS,name,rollNo,status, dateD);

	}

	@FXML
	void homeScreen(ActionEvent event) throws IOException{

		String fxmlDocPath = "src/UI_XML/Teacher_Home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();
		main.goToNextScreen(s, fxmlDocPath);

	}



	private void editableCol() {

		status.setCellFactory(TextFieldTableCell.forTableColumn());

		status.setOnEditCommit(e->{

			e.getTableView().getItems().get(e.getTablePosition().getRow()).setStatus(e.getNewValue());

		});

		attendanceViewTable.setEditable(true);

	}

	@FXML
	void selectData(ActionEvent event) throws IOException {

		String dateP = date.getValue().format(DateTimeFormatter.ofPattern("MM-dd-yy"));
	//	attendance =lms.getAttendanceData(course.getText(), section.getText(),lms.currnetTeacherLogin().getEmployeeID(), dateP, status.getText());
		
		attendance= lms.viewAttendance(dateP, section.getText(),course.getText());
		data= FXCollections.observableArrayList(attendance);	


		//3rd Step
		courseCode.setCellValueFactory(new PropertyValueFactory<Attendance,String>("courseCode"));
		sectionS.setCellValueFactory(new PropertyValueFactory<Attendance,String>("section"));
		name.setCellValueFactory(new PropertyValueFactory<Attendance,String>("name"));
		rollNo.setCellValueFactory(new PropertyValueFactory<Attendance,String>("studentID"));
		status.setCellValueFactory(new PropertyValueFactory<Attendance,String>("status"));
		dateD.setCellValueFactory(new PropertyValueFactory<Attendance,String>("date"));

		//status.setCellValueFactory(new PropertyValueFactory<Attendance,String>("status"));

		//  attendanceViewTable.setEditable(true);
		//  status.setCellFactory(TextFieldTableCell.forTableColumn());

		//4th step 
		attendanceViewTable.setItems(data);
		attendanceViewTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		editableCol();



	}

	@FXML
	void updateBtn(ActionEvent event) throws IOException, SQLException {

		//ArrayList<Attendance>attendance= new ArrayList<Attendance>();

		attendanceViewTable2=attendanceViewTable;

		attendanceViewTable.getSelectionModel().selectAll();
		ObservableList <Attendance> atten=  attendanceViewTable2.getSelectionModel().getSelectedItems();


		//lms.uploadAttendance(atten);
		lms.updateAttendance(atten);

		attendanceViewTable.getItems().clear();

	}

	//**********************************************

	@FXML
	void makeAnnouncement(ActionEvent event)  throws IOException{

	}

	@FXML
	void Upload_AttendanceBtn(ActionEvent event) {

	}

	@FXML
	void updateMarks(ActionEvent event) throws IOException{

	}

	@FXML
	void uploadAssignment(ActionEvent event) throws IOException {

	}

	@FXML
	void uploadGrade(ActionEvent event)  throws IOException{

	}

	@FXML
	void uploadSlides(ActionEvent event)  throws IOException{

	}

	@FXML
	void uploadStudentMarks(ActionEvent event) throws IOException {

	}

}
