package dataBase_SQL_Server;

import java.sql.SQLException;
import java.util.ArrayList;

import businessLogic.Announcement;
import businessLogic.Assessment;
import businessLogic.Attendance;
import businessLogic.Course;
import businessLogic.FebrecatedGrade;
import businessLogic.Student;
import businessLogic.Teacher;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public interface PersistenceHandler {

	 static PersistenceHandler instance= new DBHandler();
	
	 static PersistenceHandler getInstance() {
		 
		  return instance;
	 }
	
	
	abstract void connectDB();
	abstract void saveStudentRecord( String studentDegree, String rollNumber, String address, String phoneNumber, String firstName,
			String lastName, String section, String gender, String batch, String cNIC, String email, String password);
	abstract void addTeacher(String firstName, String lastName, String address, String employeeID, String eMail,
			String phoneNumber, String coordinateID, String qualification, String gender, String password);
	
	abstract void addCourse(String courseName, String courseCode, String creditHours, String type, String grade);
	abstract void deleteRecord(String type, String deleteID);
	abstract ArrayList<Teacher> readTeacherRecord();
	abstract ArrayList<Student> readStudentRecord();
	abstract ArrayList<Course> readCourseRecord();
	abstract void courseRegistration( String courseCode, String studentID, String grade);
	abstract void assignCourseToTeacher(String courseCode, String teacherID);
	abstract ArrayList<Attendance> readAttendanceData(String course, String section, String employeeID, String date, String status);
	abstract void UploadAttendance(String name, String studentID, String section, String courseCode, String status,
			String date);
	void closeCon() throws SQLException;
	ArrayList<String> getRegisterCourses(String rollNumber);
	abstract ArrayList<Attendance> viewAttendance(String courseCode, String rollNumber);
	abstract ArrayList<Attendance> viewAttendance(String dateP, String section, String courseCode);
	abstract void updateAttendance(String status, String date, String section, String courseCode);
	abstract ArrayList<String> getAssignCourses(String employeeID);
	abstract ArrayList<Assessment> readDataForMarks( String courseCode, String section, double totalMarks,double absolutes);
	abstract void uploadAssessment(String rollNumber, String obtainedMarks, double totalMarks, double absolutes,
			String courseCode, String assessmentType, String teacherID, String section);
	abstract ArrayList<Assessment> getMarks(String courseCode, String section, String assessmentType,
			String employeeID);
	abstract void updateAssessment( String coursCode, String srction, String assessment, String obtainedMarks, String studentID);
	abstract ArrayList<Assessment> viewMarks(String courseCode, String assessmentType, String rollNumber);
	abstract void makeAnnouncement(String employeeID, String text, String section, String courseCode);
	abstract ArrayList<Announcement> viewAnnouncement(String courseCode, String section);
	abstract void uploadGrade(String grade, String courseCode, String rollNumber);
	abstract ArrayList<FebrecatedGrade> readCourseRecord(String courseCode, String section);
	abstract ArrayList<FebrecatedGrade> readCourseRecord(String rollNumber);
	
}