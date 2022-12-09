package UI_XML;

import java.io.IOException;
import java.util.ArrayList;

import businessLogic.FebrecatedGrade;
import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TranscriptController {

	LMS lms= LMS.getInstance();
	@FXML
	private TableView<FebrecatedGrade> transcriptTable;
	

	ArrayList<FebrecatedGrade> gradesList;
	ObservableList <FebrecatedGrade> data;



	TableColumn<FebrecatedGrade, String> rollNumber;
	TableColumn<FebrecatedGrade, String> courseCode;
	TableColumn<FebrecatedGrade, String> grade;


	@FXML
	private void initialize() {




		rollNumber=  new TableColumn("Roll Number");
		courseCode=  new TableColumn("Course Code");
		//courseName=  new TableColumn("Course Name");
		//type=  new TableColumn("Type");
		grade=  new TableColumn("Grade");
		transcriptTable.getColumns().addAll(rollNumber,grade, courseCode);


		rollNumber.setMaxWidth(300);
		courseCode.setMaxWidth(300);
		grade.setMaxWidth(300);
		
		selectGrades();

	}


	void selectGrades()  {
		
		gradesList=lms.getCourses(lms.currentLogin().getRollNumber());
		
		data= FXCollections.observableArrayList(gradesList);


		courseCode.setCellValueFactory(new PropertyValueFactory<FebrecatedGrade,String>("courseCode"));
		rollNumber.setCellValueFactory(new PropertyValueFactory<FebrecatedGrade,String>("rollNumber"));
		grade.setCellValueFactory(new PropertyValueFactory<FebrecatedGrade, String>("grade") );

		transcriptTable.setItems(data);
		transcriptTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		
	}

	@FXML
	void courseRegistration(ActionEvent event) {

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
	void viewAttendance(ActionEvent event) {

	}

	@FXML
	void viewMarks(ActionEvent event) {

	}

	@FXML
	void viewSlide(ActionEvent event) {

	}

}
