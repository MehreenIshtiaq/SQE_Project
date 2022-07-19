package businessLogic;

import java.util.ArrayList;

import dataBase_SQL_Server.DBHandler;
import dataBase_SQL_Server.PersistenceHandler;

public class Student {

	private String studentDegree;
	private String rollNumber;
	private String address;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String section;
	private String gender;
	private String batch;
	private String CNIC;
	private String email;
	private String password;


	PersistenceHandler handler = PersistenceHandler.getInstance();
	
	public Student() {

	}
	public Student(String studentDegree, String rollNumber, String address, String phoneNumber, String firstName,
			String lastName, String section, String gender, String batch, String cNIC, String email, String password) {

		this.studentDegree = studentDegree;
		this.rollNumber = rollNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
		this.gender = gender;
		this.batch = batch;
		CNIC = cNIC;
		this.email = email;
		this.password = password;
	}

	public ArrayList<Announcement> viewAnnouncement(String courseCode, String section) {
		
		handler.connectDB();
		
		return handler.viewAnnouncement(courseCode,section);
	}


	public ArrayList<Attendance> viewAttendance(String courseCode, String rollNumber) {

		handler.connectDB();

		return handler.viewAttendance(courseCode,rollNumber);
	}


	public ArrayList<Assessment> viewMarks(String courseCode, String assessmentType, String rollNumber) {
		
		Resources resources= new Resources();
		
		return resources.viewMarks(courseCode, assessmentType, rollNumber);
	}

	public String getStudentDegree() {
		return studentDegree;
	}


	public void setStudentDegree(String studentDegree) {
		this.studentDegree = studentDegree;
	}


	public String getRollNumber() {
		return rollNumber;
	}


	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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


	public String getSection() {
		return section;
	}


	public void setSection(String section) {
		this.section = section;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}


	public String getCNIC() {
		return CNIC;
	}


	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public String toString() {
		return "Student [studentDegree=" + studentDegree + ", rollNumber=" + rollNumber + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", section="
				+ section + ", gender=" + gender + ", batch=" + batch + ", CNIC=" + CNIC + ", email=" + email
				+ ", password=" + password + "]";
	}
	



}
