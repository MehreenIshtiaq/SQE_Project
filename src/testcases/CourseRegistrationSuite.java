package testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import businessLogic.LMS;

public class CourseRegistrationSuite {

	LMS lms = new LMS();

	@Test
	public void CourseRegistrationSuccess_TC79() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.registerCourse("SE2002", "20i1881", "B+");
		
	
		String c= outContent.toString();
		 
		assertEquals("A new Course was registered!", c);
	}
	
	@Test
	public void CourseRegistrationInvalid_TC80() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.registerCourse("", "20i1881", "");
		
	
		String c= outContent.toString();
		 
		assertEquals("No Course was selected!", c);
	}

}
