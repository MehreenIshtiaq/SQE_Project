package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataBase_SQL_Server.DBHandler;
import dataBase_SQL_Server.PersistenceHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class LMS {

	private static LMS instance= new LMS();
	
	public static LMS getInstance() {
		
		if(instance==null) {
			
			instance= new LMS();
		}
		
		return instance;
	}
	
	
	Admin admin= new Admin();

	OfferedCourse offeredCourse= new OfferedCourse();
	PersistenceHandler handler = PersistenceHandler.getInstance();
	
	Profile profile= new Profile();

	private static Student student;
	private static Teacher teacher;

	private String address;
	private String organizationName;


	public LMS() {

		//empty
	}

	public ArrayList<Attendance> getAttendanceData(String course, String section, String employeeID, String date, String status){

		Teacher teacher = new Teacher();

		return teacher.getAttendanceData(course,section,employeeID, date, status);
	}

	public ArrayList<Course> getCourses(){

		return offeredCourse.courseRecord();

	}

	public ArrayList<FebrecatedGrade> getCourses(String rollNumber) {


		return offeredCourse.courseRecord(rollNumber );
	}


	public ArrayList<FebrecatedGrade> getCourses(String courseCode, String section) {
		return offeredCourse.courseRecord(courseCode, section );
	}
	//	public boolean checkTeacherLogin

	public void assignCourse(String courseCode, String teacherID) {

		offeredCourse.assignCourse(courseCode, teacherID);

	}

	public void uploadAttendance(ObservableList <Attendance> atten) throws SQLException {

		teacher.uploadAttendance(atten);

	}

	public void uploadAssessment(ObservableList<Assessment> assessment, String assessmentType, String teacherID, String section) throws SQLException {

		teacher.uploadAssessment(assessment,assessmentType,teacherID, section);

	}
	public void updateAttendance(ObservableList<Attendance> atten) throws SQLException {

		teacher.updateAttendance(atten);


	}
	public boolean studentLogin(String userName, String password) {


		boolean flag=false;
		student=profile.checkLogin(userName, password);
		// currentLogin(student);


		if(userName.equals(student.getRollNumber())&& password.equals(student.getPassword())) {

			flag=true;
			return flag;
		}


		return flag;



	}

	public Student currentLogin() {

		return student;


	}

	public Teacher currnetTeacherLogin() {

		return teacher;
	}
	public boolean teacherLogin(String userName, String password) {

		boolean flag=false;

		teacher=profile.checkTeacherLogin(userName, password);
		System.out.println(teacher.getFirstName()+" "+teacher.getEmployeeID());

		if(userName.equals(teacher.getEmployeeID())&& password.equals(teacher.getPassword())) {

			flag=true;
			return flag;
		}

		return flag;

	}
	public boolean adminLogin(String name, String password) {

		boolean flag=false;

		if(name.equals(admin.getAdminName() ) && password.equals(admin.getPassword())) {


			flag=true;


		}

		return flag;

	}

	public void registerCourse( String courseCode, String studentID, String grade) {

		offeredCourse.registerCourse(courseCode, studentID, grade);
	}
	public void enrollStudent(  String studentDegree, String rollNumber, String address, String phoneNumber, String firstName,
			String lastName, String section, String gender, String batch, String cNIC, String email, String password) {


		admin.addStudent(studentDegree, rollNumber, address, phoneNumber, firstName, lastName, section, gender, batch, cNIC, email, password);


	}

	public void uploadGrade(ObservableList<FebrecatedGrade> grade) {


		offeredCourse.uploadGrade(grade);

	}

	public void addTeacher(String firstName, String lastName, String address, String employeeID, String eMail,
			String phoneNumber, String coordinateID, String qualification, String gender,String password) {

		admin.addTeacher(firstName, lastName, address, employeeID, eMail, phoneNumber, coordinateID, qualification, gender, password);

	}

	public void addNewCourse(String courseName, String courseCode, String creditHours, String type, String grade) {

		offeredCourse.addNewCourse(courseName, courseCode, creditHours, type, grade);


	}

	public ArrayList<String> getRegisterCourses(String rollNumber) {


		return offeredCourse.getRegisterCourses(rollNumber);
	}

	public ArrayList<Attendance> viewAttendance(String courseCode, String rollNumber) {


		return student.viewAttendance(courseCode,rollNumber);
	}

	public ArrayList<Attendance> viewAttendance(String dateP, String section, String courseCode) {

		return teacher.viewAttendance(dateP, section, courseCode);
	}

	public ArrayList<String> getAssignCourses(String employeeID) {

		return offeredCourse.getAssignCourses(employeeID);
	}

	public ArrayList<Assessment> getMarksData( String courseCode, String section, double totalMarks, double absolutes) {

		return  teacher.getDataForMarks( courseCode, section, totalMarks, absolutes);
	}

	public ArrayList<Assessment> getMarks(String courseCode, String section, String assessmentType, String employeeID) {


		return teacher.getMarks(courseCode, section, assessmentType, employeeID);

	}

	public void updateAssessment(ObservableList<Assessment> atten, String courseCode, String section, String assessment) throws SQLException {

		teacher.updateAssessment(atten, courseCode, section, assessment);

	}

	public ArrayList<Assessment> viewMarks(String courseCode, String assessmentType, String rollNumber) {
		// TODO Auto-generated method stub
		return student.viewMarks(courseCode, assessmentType, rollNumber);
	}

	public void makeAnnouncement(String employeeID, String text, String section, String courseCode) {


		teacher.makeAnnouncement(employeeID, text, section, courseCode);

	}

	public ArrayList<Announcement> viewAnnouncement(String courseCode, String section) {


		return student.viewAnnouncement(courseCode, section);
	}

	public void deleteAcc(String type, String deleteID) {
		
		handler.connectDB();
		handler.deleteRecord(type, deleteID);
		
	}

	public void viewTranscript(String string, String string2, String string3, String string4, String string5) {
		System.out.print("Transcript displayed successfully!");
		
	}










}
