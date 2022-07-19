package UI_XML;

import java.io.IOException;
import java.util.ArrayList;

import businessLogic.Announcement;
import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ViewAnnouncement_Controller {

	Main main= new Main();
	
	@FXML
	private ListView<Announcement> announcementListView;

	@FXML
	private ComboBox<String> courseCB;

	ArrayList <String>list;//= new ArrayList<String>();
	private ObservableList<String> courseList;//= (ObservableList<String>) FXCollections.observableArrayList(list);
	
	LMS lms= LMS.getInstance();


	@FXML
	private void initialize() {


		list= new ArrayList<String>();
		list=lms.getRegisterCourses(lms.currentLogin().getRollNumber());
		courseList= (ObservableList<String>) FXCollections.observableArrayList(list);


		courseCB.setValue("Select Course");
		courseCB.setItems(courseList);

	}

	@FXML
	void viewAnnouncementBtn(ActionEvent event) throws IOException {
		
		 	 ArrayList<Announcement> announcement= new ArrayList<Announcement>();
		 	 
		 	 announcement= lms.viewAnnouncement(courseCB.getValue(), lms.currentLogin().getSection());
		 
		 	 announcementListView.getItems().addAll(announcement);
		
	}
	
	   @FXML
	    void clearList(ActionEvent event)  throws IOException {
		   announcementListView.getItems().clear();
		   
	    }

	@FXML
	void homeBtn(ActionEvent event) throws IOException {

		String fxmlDocPath = "src/UI_XML/Student_Home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);

	}
	
	@FXML
	void courseRegistration(ActionEvent event) {

	}

	@FXML
	void giveFeedback(ActionEvent event) {

	}

	@FXML
	void submitAssignment(ActionEvent event) {

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
