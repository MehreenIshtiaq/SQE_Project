package testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import businessLogic.LMS;

public class DeleteStudentSuite {
	
	LMS lms = new LMS();

	@Test
	public void deleteStudentSuccess_TC81() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.deleteAcc("Student", "20i1881");
		
	
		String c= outContent.toString();
		 
		assertEquals("A user was deleted successfully!", c);
	}
	
	@Test
	public void deleteStudentStudentIDInvalid_TC82() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.deleteAcc("Student", "20i18811x");
		
	
		String c= outContent.toString();
		 
		assertEquals("A user was NOT deleted. Invalid Student ID!", c);
	}

}
