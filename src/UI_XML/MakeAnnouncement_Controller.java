package UI_XML;

import java.io.IOException;
import java.util.ArrayList;

import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MakeAnnouncement_Controller {

	
	LMS lms= LMS.getInstance();
	Main main= new Main();
	
	
	ArrayList <String>list;
	private ObservableList<String> courseList;
	
    @FXML
    private TextArea announcementTextArea;

    @FXML
    private ComboBox<String> courseCB;


    @FXML
    private TextField section;

   

    
    @FXML
	private void initialize() {
    	
    	
    	list= new ArrayList<String>();
    	list=lms.getAssignCourses(lms.currnetTeacherLogin().getEmployeeID());

    	courseList= (ObservableList<String>) FXCollections.observableArrayList(list);


    	courseCB.setValue("Select Course");
    	courseCB.setItems(courseList);
    	
    	
    }
    
    @FXML
    void announcementUploadBtn(ActionEvent event) throws IOException {
    	
    	
    	String text=announcementTextArea.getText();
    
    	lms.makeAnnouncement(lms.currnetTeacherLogin().getEmployeeID(),text,section.getText(), courseCB.getValue());
    	

    }
    
    @FXML
    void homeBtn(ActionEvent event) throws IOException {
    	
    	String fxmlDocPath = "src/UI_XML/Teacher_Home.fxml";
		Stage s=(Stage)((Node)event.getSource()).getScene().getWindow();

		main.goToNextScreen(s, fxmlDocPath);

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

    @FXML
    void uploadStudentMarks(ActionEvent event) {

    }

}
