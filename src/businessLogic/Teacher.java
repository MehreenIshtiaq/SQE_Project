package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataBase_SQL_Server.DBHandler;
import dataBase_SQL_Server.PersistenceHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class Teacher {

	private String firstName;
	private String lastName;
	private String address;
	private String employeeID;
	private String eMail;
	private String phoneNumber;
	private String coordinateID;
	private String qualification;
	private String gender;
	private String password;

	ArrayList <Attendance> attendance= new ArrayList<Attendance>();
	ArrayList<Announcement> announcement= new ArrayList<Announcement>();
	PersistenceHandler handler = PersistenceHandler.getInstance();
	
	
	Resources resources= new Resources(); 

	public Teacher() {

		//empty
	}

	public void updateAssessment(ObservableList<Assessment> atten, String courseCode, String section, String assessment) throws SQLException {

		Resources resources= new Resources();
		
		resources.updateAssessment(atten, courseCode, section, assessment);

	}

	public Teacher(String firstName, String lastName, String address, String employeeID, String eMail,
			String phoneNumber, String coordinateID, String qualification, String gender, String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.employeeID = employeeID;
		this.eMail = eMail;
		this.phoneNumber = phoneNumber;
		this.coordinateID = coordinateID;
		this.qualification = qualification;
		this.gender = gender;
		this.password=password;
	}


	public ArrayList<Attendance> getAttendanceData(String course, String section, String employeeID, String date, String status){

		handler.connectDB();
		return  handler.readAttendanceData(course, section,  employeeID, date, status);
	}


	public void uploadAttendance(ObservableList<Attendance> atten) throws SQLException {


		init(atten);

		handler.connectDB();
		for(int i=0; i<attendance.size();i++) {

			handler.UploadAttendance(attendance.get(i).getName(), attendance.get(i).getStudentID(), attendance.get(i).getSection(),attendance.get(i).getCourseCode(), attendance.get(i).getStatus(),attendance.get(i).getDate());


		}

		handler.closeCon();

		attendance= new ArrayList<Attendance>();


	}

	private void init(ObservableList<Attendance> atten) {

		for(Attendance att:   atten) {

			attendance.add(new Attendance(att.getName(), att.getStudentID(), att.getSection(),att.getCourseCode(), att.getStatus(),att.getDate()));

		}

		//System.out.println(attendance.get(0));
	}

	public void updateAttendance(ObservableList<Attendance> atten) throws SQLException {

		init(atten);

		handler.connectDB();

		for(int i=0; i<attendance.size();i++) {

			handler.updateAttendance(attendance.get(i).getStatus(), attendance.get(i).getDate(),attendance.get(i).getSection(), attendance.get(i).getCourseCode());

		}

		handler.closeCon();

		attendance= new ArrayList<Attendance>();


	}

	public ArrayList<Assessment> getDataForMarks( String courseCode, String section, double totalMarks, double absolutes) {

		return resources.getDataForMarks( courseCode, section, totalMarks, absolutes) ;
	}


	public ArrayList<Attendance> viewAttendance(String dateP, String section, String courseCode) {

		handler.connectDB();

		return handler.viewAttendance(dateP, section,courseCode);
	}

	public void uploadAssessment(ObservableList<Assessment> assessment, String assessmentType, String teacherID, String section) throws SQLException {

		Resources resources= new Resources();

		resources.uploadMarks(assessment, assessmentType,teacherID, section);

	}

	public ArrayList<Assessment> getMarks(String courseCode, String section, String assessmentType,
			String employeeID) {
		Resources resources= new Resources();

		return resources.getMarks(courseCode, section, assessmentType, employeeID);
	}

	public void makeAnnouncement(String employeeID, String text, String section, String courseCode) {


		announcement.add(new Announcement(employeeID, text, section, courseCode));
		
		handler.connectDB();

		handler.makeAnnouncement(employeeID, text, section, courseCode);
		
		

	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCoordinateID() {
		return coordinateID;
	}

	public void setCoordinateID(String coordinateID) {
		this.coordinateID = coordinateID;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Teacher [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", employeeID="
				+ employeeID + ", eMail=" + eMail + ", phoneNumber=" + phoneNumber + ", coordinateID=" + coordinateID
				+ ", qualification=" + qualification + ", gender=" + gender + "]";
	}







}
