package businessLogic;

import java.util.ArrayList;

import dataBase_SQL_Server.DBHandler;
import dataBase_SQL_Server.PersistenceHandler;
import javafx.collections.ObservableList;

public class OfferedCourse {

	private int semester;


	PersistenceHandler handler = PersistenceHandler.getInstance();
	
	ArrayList <Course> courses= new ArrayList<Course>();
	ArrayList<AssignCourse> assignCourse= new ArrayList<AssignCourse>();
	ArrayList <FebrecatedGrade> grades= new ArrayList<FebrecatedGrade>();




	public OfferedCourse() {

		//empty
	}
	public OfferedCourse(int semester) {

		this.semester = semester;
	}

	public void registerCourse( String courseCode, String studentID, String grade) {

		
		handler.connectDB();
		handler.courseRegistration( courseCode, studentID, grade);

	}

	public void assignCourse(String courseCode, String teacherID) {

		
		handler.connectDB();
		handler.assignCourseToTeacher(courseCode, teacherID);

	}
	public void addNewCourse(String courseName, String courseCode, String creditHours, String type, String grade) {


		courses.add(new Course(courseName, courseCode,creditHours,type,grade));

		
		handler.connectDB();
		handler.addCourse(courseName, courseCode, creditHours, type, grade);
		//displayCourse();
	}


	public ArrayList<String> getRegisterCourses(String rollNumber) {


		handler.connectDB();

		return handler.getRegisterCourses(rollNumber);

	}




	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	public void displayCourse() {

		for(int i=0; i<courses.size();i++) {

			System.out.println(courses.get(i));
		}

	}
	public ArrayList<String> getAssignCourses(String employeeID) {

	
		handler.connectDB();

		return handler.getAssignCourses(employeeID);

	}
	public void uploadGrade(ObservableList<FebrecatedGrade> grade) {

		handler.connectDB();

		 ArrayList<FebrecatedGrade> gradesI= new ArrayList<FebrecatedGrade>();
		 
	

		for(int i=0; i< grade.size(); i++) {

			handler.uploadGrade(grade.get(i).getGrade(),grade.get(i).getCourseCode(), grade.get(i).getRollNumber());


		}


	}
	public ArrayList<FebrecatedGrade> courseRecord(String courseCode, String section) {


		handler.connectDB();
		grades=handler.readCourseRecord(courseCode , section);
		//displayCourse();
		return grades;

	}

	public ArrayList<Course> courseRecord() {

		handler.connectDB();
		courses=handler.readCourseRecord();
		//displayCourse();
		return courses;

	}
	public ArrayList<FebrecatedGrade> courseRecord(String rollNumber) {

		handler.connectDB();
		grades=handler.readCourseRecord(rollNumber);
		return grades;

	}

}

