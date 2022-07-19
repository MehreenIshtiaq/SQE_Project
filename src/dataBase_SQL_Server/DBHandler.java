package dataBase_SQL_Server;
import businessLogic.Announcement;
import businessLogic.Assessment;
import businessLogic.Attendance;
import businessLogic.Course;
import businessLogic.FebrecatedGrade;
import businessLogic.Student;
import businessLogic.Teacher;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class DBHandler implements PersistenceHandler{
	Connection con=null;
	@Override
	public void connectDB() {
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.jdbc.Driver");

			// con=   DriverManager.getConnection("jdbc:mysql://localhost/test?" +"user=root & password= ");

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");

			if(con == null) {
				System.out.println("DB connection failed");
			}else {

				System.out.println("DB connection successful");
				// saveRecord();

			}
		}
		catch(Exception e) {
			System.out.println("exception: "+e);
		}
	}

	@Override
	public ArrayList<Teacher> readTeacherRecord() {

		ArrayList<Teacher> teacher= new ArrayList<Teacher>();


		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			String sql="Select * from Teacher";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				teacher.add(new Teacher(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10)));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}
		return teacher;


	}

	@Override
	public ArrayList<Attendance> viewAttendance(String courseCode, String rollNumber) {

		ArrayList<Attendance> attendance= new ArrayList<Attendance>();



		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql= "SELECT courseCode,status,date From attendance Where courseCode='"+courseCode+"' AND rollNumber='"+rollNumber+"'";
			System.out.println(sql);
			String sql1=sql;
			ResultSet rs= stmt.executeQuery(sql1);
			while(rs.next()) {

				attendance.add(new Attendance(rs.getString(1), rs.getString(2),rs.getString(3)));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}
		return attendance;
	}



	@Override
	public ArrayList<Assessment> readDataForMarks( String courseCode, String section, double totalMarks, double absolutes) {

		ArrayList<Assessment> assessment= new ArrayList<Assessment>();



		Statement stmt;
		try {
			stmt = con.createStatement();


			String sql= "SELECT std.rollNumber FROM student std JOIN courseregistration reg ON reg.studentID=std.rollNumber WHERE std.section= '"+section+"' AND reg.courseCode= '"+courseCode+"'";
			System.out.println(sql);
			String sql1=sql;
			ResultSet rs= stmt.executeQuery(sql1);
			String obtainMarks="0";

			while(rs.next()) {
				//rollNumber,     obtainedMarks,  totalMarks,     absolutes,     assessmetnName
				assessment.add(new Assessment(rs.getString(1), obtainMarks ,totalMarks, absolutes, courseCode));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}
		return assessment;
	}



	@Override
	public ArrayList<Attendance> readAttendanceData(String course, String section, String employeeID, String date, String status) {

		ArrayList<Attendance> attendance= new ArrayList<Attendance>();



		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			//	String sql="SELECT std.firstName,std.rollNumber,std.section,reg.courseCode FROM courseregistration reg JOIN assigncourses a ON reg.courseCode=a.courseCode JOIN student std ON reg.studentID=std.rollNumber WHERE std.section='P' AND a.courseCode='SE2002' AND a.teacherID='emp1_SE'";
			String sql= "SELECT std.firstName,std.rollNumber,std.section,reg.courseCode FROM courseregistration reg JOIN assigncourses a ON reg.courseCode=a.courseCode JOIN student std ON reg.studentID=std.rollNumber WHERE std.section= "+"'"+section+"'"+" AND a.courseCode= "+"'"+course+"'"+" AND a.teacherID= "+"'"+employeeID+"'";
			System.out.println(sql);
			String sql1=sql;
			ResultSet rs= stmt.executeQuery(sql1);
			while(rs.next()) {

				attendance.add(new Attendance(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4), status,date));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}
		return attendance;

	}


	@Override
	public ArrayList<Attendance> viewAttendance(String date, String section, String courseCode) {


		ArrayList<Attendance> attendance= new ArrayList<Attendance>();



		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql= "SELECT * From Attendance Where date='"+date+"' AND section='"+section+"' AND courseCode='"+courseCode+"'";
			System.out.println(sql);
			String sql1=sql;
			ResultSet rs= stmt.executeQuery(sql1);
			while(rs.next()) {

				attendance.add(new Attendance(rs.getString(3), rs.getString(4),rs.getString(2),rs.getString(1),rs.getString(5),rs.getString(6)));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}
		return attendance;
	}

	@Override
	public ArrayList<Assessment> viewMarks(String courseCode, String assessmentType, String rollNumber) {

		ArrayList<Assessment> assessment= new ArrayList<Assessment>();

		String sql;

		if(assessmentType.equals("Quiz")) {

			sql = "Select obtainedMarks, totalMarks, absolutes From quiz Where courseCode= '"+courseCode+"' AND rollNumber= '"+rollNumber+"'";


		}else if(assessmentType.equals("Assignment")) {


			sql = "Select obtainedMarks, totalMarks, absolutes From Assignment Where courseCode= '"+courseCode+"' AND rollNumber= '"+rollNumber+"'";


		}else {


			sql = "Select obtainedMarks, totalMarks, absolutes From Paper Where courseCode= '"+courseCode+"' AND rollNumber= '"+rollNumber+"'";

		}


		Statement stmt;
		try {
			stmt = con.createStatement();
			System.out.println(sql);
			String sql1=sql;
			ResultSet rs= stmt.executeQuery(sql1);

			int count=0;
			while(rs.next()) {

				count++;
				assessment.add(new Assessment(count,rs.getString(1), rs.getDouble(2),rs.getDouble(3)));


			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		for(int i=0; i<assessment.size(); i++) {

			System.out.println(assessment.get(i));
		}
		return assessment;

	}

	@Override
	public ArrayList<Student> readStudentRecord() {

		ArrayList<Student> student= new ArrayList<Student>();


		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			String sql="Select * from Student";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				student.add(new Student(rs.getString(6), rs.getString(3),rs.getString(8),rs.getString(9),rs.getString(1),rs.getString(2),rs.getString(7),rs.getString(12),rs.getString(5),rs.getString(10),rs.getString(4),rs.getString(11)));
			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		//System.out.println("Outside of the try-catch");
		return student;


	}

	@Override
	public ArrayList<String> getAssignCourses(String employeeID) {

		ArrayList<String> course= new ArrayList<String>();


		Statement stmt;
		try {
			stmt = con.createStatement();

			String sql="Select courseCode from assignCourses Where teacherID= '"+employeeID+"'";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				course.add(rs.getString(1));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		return course;
	}


	@Override
	public ArrayList<String> getRegisterCourses(String rollNumber) {

		ArrayList<String> course= new ArrayList<String>();


		Statement stmt;
		try {
			stmt = con.createStatement();

			String sql="Select courseCode from courseregistration Where studentID= '"+rollNumber+"'";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				course.add(rs.getString(1));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		return course;
	}


	@Override
	public ArrayList<Announcement> viewAnnouncement(String courseCode, String section) {



		ArrayList<Announcement> announcement= new ArrayList<Announcement>();


		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			String sql="Select * from Announcement Where courseCode= '"+courseCode+"'";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				announcement.add(new Announcement(rs.getString(3), rs.getString(2),rs.getString(4)));

			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		//System.out.println("Outside of the try-catch");
		return announcement;



	}

	@Override
	public ArrayList<FebrecatedGrade> readCourseRecord(String courseCode, String section) {

		ArrayList<FebrecatedGrade> grade= new ArrayList<FebrecatedGrade>();


		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			String sql="SELECT studentID, courseCode, grade FROM courseregistration reg JOIN student s ON s.rollNumber=reg.studentID WHERE s.section='"+ section+"' AND reg.courseCode='"+courseCode+"'";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				//course.add(new Course(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));

				grade.add(new FebrecatedGrade(rs.getString(1),rs.getString(2),rs.getString(3)));
			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		//System.out.println("Outside of the try-catch");
		return grade;



	}

	@Override
	public ArrayList<FebrecatedGrade> readCourseRecord(String rollNumber) {





		ArrayList<FebrecatedGrade> course= new ArrayList<FebrecatedGrade>();


		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			String sql="Select * from courseRegistration Where studentID= '"+rollNumber+"' AND grade!= 'I'";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				course.add(new FebrecatedGrade (rs.getString(3), rs.getString(2),rs.getString(4)));
			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		//System.out.println("Outside of the try-catch");
		return course;



	}

	@Override
	public ArrayList<Course> readCourseRecord() {

		ArrayList<Course> course= new ArrayList<Course>();


		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			String sql="Select * from Course";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				course.add(new Course(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		//System.out.println("Outside of the try-catch");
		return course;


	}


	@Override
	public void courseRegistration( String courseCode, String studentID, String grade) {

		int registrationNo  = (int) (Math.random()*(9999-100+1)+100);
		String sql = "INSERT INTO courseregistration ( registrationNo,courseCode, studentID, grade) VALUES( ?,?,?, ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;
			statement.setInt(1, registrationNo);
			statement.setString(2, courseCode);
			statement.setString(3,studentID);
			statement.setString(4,grade);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Course was registered!");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void assignCourseToTeacher(String courseCode, String teacherID) {

		int assignmentID  = (int) (Math.random()*(9999-100+1)+100);

		String sql = "INSERT INTO assignCourses (assignmentID, courseCode, teacherID) VALUES(?, ?, ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;
			statement.setInt(1,  assignmentID);
			statement.setString(2, courseCode);
			statement.setString(3,teacherID);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Course was assigned!");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void saveStudentRecord( String studentDegree, String rollNumber, String address, String phoneNumber, String firstName,
			String lastName, String section, String gender, String batch, String cNIC, String email, String password){
		String sql = "INSERT INTO Student (firstName, lastName, rollNumber, eMail, batch, degreeName, section, address,phoneNumber,CNIC,password,gender) VALUES(?, ?, ?, ?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, rollNumber);
			statement.setString(4, email);
			statement.setString(5, batch);
			statement.setString(6, studentDegree);
			statement.setString(7, section);
			statement.setString(8, address);
			statement.setString(9, phoneNumber);
			statement.setString(10, cNIC);
			statement.setString(11, password);
			statement.setString(12, gender);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new student record was inserted successfully!");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void addTeacher(String firstName, String lastName, String address, String employeeID, String eMail,
			String phoneNumber, String coordinateID, String qualification, String gender, String password) {

		String sql = "INSERT INTO Teacher (firstName, lastName, address, employeeID, eMail, phoneNumber, coordinateID, qualification,gender,password) VALUES(?, ?, ?, ?,?,?,?,?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, address);
			statement.setString(4, employeeID);
			statement.setString(5, eMail);
			statement.setString(6, phoneNumber);
			statement.setString(7, coordinateID);
			statement.setString(8, qualification);
			statement.setString(9, gender);
			statement.setString(10, password);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new teacher record was inserted successfully!");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void uploadGrade(String grade, String courseCode, String rollNumber) {


		String sql = "UPDATE courseRegistration SET grade= '"+grade+"'WHERE courseCode= '"+courseCode+"' AND studentID= '"+rollNumber+"'";
		PreparedStatement statement;
		try {

			statement = con.prepareStatement(sql) ;			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Record Updated!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updateAttendance(String status, String date, String section, String courseCode) {



		String sql = "UPDATE Attendance SET status= '"+status+"' WHERE section= '"+section+"' AND courseCode= '"+courseCode+"' AND date= '"+date+"'";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new attendance record was inserted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void makeAnnouncement(String employeeID, String text, String section, String courseCode) {


		String sql = "INSERT INTO Announcement (employeeID,section, courseCode, text) VALUES( ?, ?,?,?)";
		PreparedStatement statement;
		try {

			statement = con.prepareStatement(sql) ;
			statement.setString(1, employeeID);
			statement.setString(2,  section);
			statement.setString(3, courseCode);
			statement.setString(4, text);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new announcement record was inserted successfully!");
				//con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void UploadAttendance(String name, String rollNumber, String section, String courseCode, String status,
			String date) {


		String sql = "INSERT INTO Attendance (courseCode,section,  name, rollNumber, status, date) VALUES(?, ?, ?, ?,?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;
			statement.setString(1, courseCode);
			statement.setString(2,  section);
			statement.setString(3, name);
			statement.setString(4, rollNumber);
			statement.setString(5,  status);
			statement.setString(6, date);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new attendance record was inserted successfully!");
				//con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void closeCon() throws SQLException {

		con.close();	

	}

	@Override
	public ArrayList<Assessment> getMarks(String courseCode, String section, String assessmentType, String employeeID) {



		String sql;

		if(assessmentType.equals("Quiz")) {

			sql = "Select * From quiz Where section= '"+section+"' AND courseCode= '"+courseCode+"' AND teacherID= '"+employeeID+"'";


		}else if(assessmentType.equals("Assignment")) {

			sql = "Select * From Assignment Where section= '"+section+"' AND courseCode= '"+courseCode+"' AND teacherID= '"+employeeID+"'";


		}else {

			sql = "Select * From Paper Where section= '"+section+"' AND courseCode= '"+courseCode+"' AND teacherID= '"+employeeID+"'";

		}



		ArrayList<Assessment> assessment= new ArrayList<Assessment>();


		Statement stmt;
		try {
			stmt = con.createStatement();
			//Teacher Reacord reading
			//	String sql="Select * from Student";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {

				assessment.add(new Assessment(rs.getString(1), rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getString(5)));
			}

			con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: "+e);
		}

		//System.out.println("Outside of the try-catch");
		return assessment;



	}



	@Override
	public void updateAssessment( String coursCode, String section, String assessmentType, String obtainedMarks, String studentID) {


		String sql;

		if(assessmentType.equals("Quiz")) {


			sql =  "UPDATE Quiz SET obtainedMarks= '"+obtainedMarks+"' WHERE  courseCode= '"+coursCode+"' AND rollNumber= '"+studentID+"'";



		}else if(assessmentType.equals("Assignment")) {


			sql =  "UPDATE Assignment SET obtainedMarks= '"+obtainedMarks+"' WHERE section= '"+section+"' AND courseCode= '"+coursCode+"' AND rollNumber= '"+studentID+"'";




		}else {


			sql =  "UPDATE Paper SET obtainedMarks= '"+obtainedMarks+"' WHERE section= '"+section+"' AND courseCode= '"+coursCode+"' AND rollNumber= '"+studentID+"'";



		}




		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A record was updated successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}


	@Override
	public void uploadAssessment(String rollNumber, String obtainedMarks, double totalMarks, double absolutes,
			String courseCode,String assessmentType, String teacherID, String section) {

		String sql;

		if(assessmentType.equals("Quiz")) {

			sql = "INSERT INTO Quiz (rollNumber,obtainedMarks,totalMarks, absolutes, courseCode, teacherID, section) VALUES(?,?,?, ?, ?, ?,?)";


		}else if(assessmentType.equals("Assignment")) {

			sql = "INSERT INTO Assignment (rollNumber,obtainedMarks,totalMarks, absolutes, courseCode, teacherID, section) VALUES(?,?,?, ?, ?, ?,?)";


		}else {

			sql = "INSERT INTO Paper (rollNumber,obtainedMarks,totalMarks, absolutes, courseCode, teacherID, section) VALUES(?,?,?, ?, ?, ?,?)";


		}


		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;
			statement.setString(1, rollNumber);
			statement.setString(2,  obtainedMarks);
			statement.setDouble(3, totalMarks);   
			statement.setDouble(4, absolutes);
			statement.setString(5,  courseCode);
			statement.setString(6,  teacherID);
			statement.setString(7,  section);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {

				System.out.println("A new marks record was inserted successfully!");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}


	}
	@Override
	public void addCourse(String courseName, String courseCode, String creditHours, String type, String grade) {

		String sql = "INSERT INTO Course (courseName, courseCode, creditHours, type, grade) VALUES(?, ?, ?, ?,?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql) ;
			statement.setString(1, courseName);
			statement.setString(2, courseCode);
			statement.setString(3, creditHours);
			statement.setString(4, type);
			statement.setString(5, grade);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new course record was inserted successfully!");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


	@Override
	public void deleteRecord(String type, String deleteID) {
		// TODO Auto-generated method stub
		 


		String sql = "";

		if(type.equals("Teacher")) {

			sql="DELETE FROM teacher WHERE employeeID='"+deleteID+"'";

		}else if(type.equals("Student")) {
			
			sql="DELETE FROM student WHERE rollNumber='"+deleteID+"'";

		}else{

			//empty
			System.out.println("Not matching!!!");
		}
		
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}





}