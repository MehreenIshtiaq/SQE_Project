package businessLogic;

import java.util.ArrayList;

import dataBase_SQL_Server.DBHandler;
import dataBase_SQL_Server.PersistenceHandler;

public class Profile {

	public Profile() {
		//empty
	}

	ArrayList<Student> stdList= new ArrayList<Student>();
	ArrayList<Teacher> teacherList= new ArrayList<Teacher>();
	PersistenceHandler handler = PersistenceHandler.getInstance();
	

	//************************************************************
	// Database

	public void readData() {

		//		  PersistenceHandler handler;
		//	      handler=new DBHandler();
		//		  handler.connectDB();
		//		  stdList=handler.readStudentRecord();
		//		  teacherList=handler.readTeacherRecord();
		//		
		//		  displayTeacher();
		//		  display();

	}


	public void addStudent( String studentDegree, String rollNumber, String address, String phoneNumber, String firstName,
			String lastName, String section, String gender, String batch, String cNIC, String email, String password) {


		stdList.add(new Student( studentDegree, rollNumber, address, phoneNumber, firstName,lastName, section,gender,batch, cNIC,email,password ));
		//display();

		handler.connectDB();
		handler.saveStudentRecord(studentDegree, rollNumber, address, phoneNumber, firstName, lastName, section, gender, batch, cNIC, email, password);
	}

	public void addTeacher(String firstName, String lastName, String address, String employeeID, String eMail,
			String phoneNumber, String coordinateID, String qualification, String gender, String password) {

		teacherList.add(new Teacher(firstName, lastName, address, employeeID, eMail, phoneNumber, coordinateID, qualification, gender, password));

		handler.connectDB();
		handler.addTeacher(firstName, lastName, address, employeeID, eMail, phoneNumber, coordinateID, qualification, gender, password);

		teacherList= new ArrayList<Teacher>();
		//displayTeacher();
	}


	public Teacher checkTeacherLogin(String userName, String password) {

		handler.connectDB();
		
		teacherList=handler.readTeacherRecord();
		
		int index=0;

		for(int i=0; i<	teacherList.size();i++) {

			if(userName.equals(	teacherList.get(i).getEmployeeID()) && password.equals(	teacherList.get(i).getPassword())) {

				index=i;
				System.out.println("Record Found");
			}
		}

		//teacherList.get(index).getFirstName();
		return 	teacherList.get(index);



	}


	public Student checkLogin(String userName, String password) {

		handler.connectDB();
		stdList=handler.readStudentRecord();

		int index=0;
			
		for(int i=0; i<stdList.size();i++) {

			if(userName.equals(stdList.get(i).getRollNumber()) && password.equals(stdList.get(i).getPassword())) {

				index=i;
				System.out.println("Record Found");
			}
		}

		stdList.get(index).getFirstName();
		return stdList.get(index);


	}
	void display() {

		for(int i=0; i<stdList.size(); i++) {


			System.out.println(stdList.get(i));
		}
	}

	void displayTeacher() {

		for(int i=0; i<teacherList.size(); i++) {


			System.out.println(teacherList.get(i));
		}
	}


}
