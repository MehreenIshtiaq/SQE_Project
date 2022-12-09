package testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import businessLogic.Profile;

public class AddTeacherSuite {

	Profile profile = new Profile();
	
	@Test
	public void addTeacherSuccess_TC68() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "03326638466", "PC220", "Ph.D.", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was inserted successfully!", c);
		
	}
	
	@Test
	public void addTeacherFirstNameInvalid_TC69() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal609*", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "03326638466", "PC220", "Ph.D.", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid First Name!", c);
	}
	
	@Test
	public void addTeacherLastNameInvalid_TC70() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid.7", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "03326638466", "PC220", "Ph.D.", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid Last Name!", c);
	}
	
	@Test
	public void addTeacherEmailInvalid_TC71() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid#nu.edu.pk", "03326638466", "PC220", "Ph.D.", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid Email!", c);
	}
	
	@Test
	public void addTeacherPhoneNumberInvalid_TC72() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "0532663846X", "PC220", "Ph.D.", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid Phone Number!", c);
	}
	
	@Test
	public void addTeacherCoordinatorIDInvalid_TC73() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "03326638466", "PCC20*/", "Ph.D.", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid Coordinator ID!", c);
	}
	
	@Test
	public void addTeacherQualificationInvalid_TC74() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "03326638466", "PC220", "Ph.D.10", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid Qualification!", c);
	}

	@Test
	public void addTeacherPasswordInvalid_TC75() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "03326638466", "PC220", "Ph.D.", "Male", "Bi56");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid Password!", c);
	}

	@Test
	public void addTeacherEmployeeIDInvalid_TC76() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PHH20*", "bilal.khalid@nu.edu.pk", "03326638466", "PC220", "Ph.D.", "Male", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Invalid Employee ID!", c);
	}


	@Test
	public void addTeacherBlankFields_TC77() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "", "", "", "", "03326638466", "", "Ph.D.", "Male", "");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Some Fields are Blank!", c);
	}
	
	@Test
	public void addTeacherGenderNotSelected_TC78() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		profile.addTeacher("Bilal", "Khalid", "Islamabad Sector-F9", "PH200", "bilal.khalid@nu.edu.pk", "03326638466", "PC220", "Ph.D.", "", "Bilal56**");
		
		
	
		String c= outContent.toString();
		 
		assertEquals("A new teacher record was not inserted. Gender Not Selected!", c);
	}

}
