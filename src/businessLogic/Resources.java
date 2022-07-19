package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataBase_SQL_Server.DBHandler;
import dataBase_SQL_Server.PersistenceHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class Resources {



	ArrayList<Assessment> assessment= new ArrayList<Assessment>();
	PersistenceHandler handler = PersistenceHandler.getInstance();
	

	public Resources(){
		//empty

	}

	public void updateAssessment(ObservableList<Assessment> atten, String courseCode, String section, String assessmentType) throws SQLException {


		handler.connectDB();
		
		
		
		for(int i=0; i<atten.size();i++) {
			// coursCode,  section, assessment,  obtainedMarks, studentID
			
			handler.updateAssessment(courseCode, section, assessmentType, atten.get(i).getObtainedMarks(), atten.get(i).getRollNumber());


		}

		handler.closeCon();
		
	}


	public ArrayList<Assessment> getDataForMarks( String courseCode, String section, double totalMarks, double absolutes) {

		handler.connectDB();
		return  handler.readDataForMarks( courseCode, section, totalMarks, absolutes);

	}

	public ArrayList<Assessment> getMarks(String courseCode, String section, String assessmentType, String employeeID) {

		handler.connectDB();


		return handler.getMarks(courseCode, section, assessmentType, employeeID);
	}
	public void uploadMarks(ObservableList<Assessment> ass, String assessmentType, String teacherID, String section) throws SQLException {


		for(Assessment assO:   ass) {

			assessment.add(new Assessment( assO.getRollNumber(), assO.getObtainedMarks(),assO.getTotalMarks(), assO.getAbsolutes(),assO.getCourseCode()));

		}

		handler.connectDB();


		for(int i=0; i<assessment.size();i++) {

			handler.uploadAssessment(assessment.get(i).getRollNumber(), assessment.get(i).getObtainedMarks(),assessment.get(i).getTotalMarks(), assessment.get(i).getAbsolutes(),assessment.get(i).getCourseCode(),assessmentType,teacherID, section);

		}

		handler.closeCon();

		assessment= new ArrayList<Assessment>();

	}

	public ArrayList<Assessment> viewMarks(String courseCode, String assessmentType, String rollNumber) {
	
		handler.connectDB();
		
		return handler.viewMarks(courseCode, assessmentType, rollNumber);
	}



}
