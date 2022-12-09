package testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import businessLogic.LMS;

public class AssignCourseSuite {

	LMS lms = new LMS();
	
	@Test
	public void assignCourseSuccess_TC92() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.assignCourse("SE2002", "emp1_SE");
		
	
		String c= outContent.toString();
		 
		assertEquals("A new Course was assigned!", c);
	}
	
	@Test
	public void assignCourseInvalidCourse_TC93() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.assignCourse("SEw20023", "emp1_SE");
		
	
		String c= outContent.toString();
		 
		assertEquals("A new Course was NOT assigned, Invalid Course Code!", c);
	}
	
	@Test
	public void assignCourseInvalidTeacherID_TC94() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.assignCourse("SE2002", "emp1_SE23");
		
	
		String c= outContent.toString();
		 
		assertEquals("A new Course was NOT assigned, Invalid Teacher ID!", c);
	}
	
	@Test
	public void assignCourseBlankFields_TC95() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.assignCourse("", "emp1_SE");
		
	
		String c= outContent.toString();
		 
		assertEquals("A new Course was NOT assigned, Blank Field!", c);
	}
	
	@Test
	public void assignCourseBlankFields_TC96() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.assignCourse("SE2002", "");
		
	
		String c= outContent.toString();
		 
		assertEquals("A new Course was NOT assigned, Blank Field!", c);
	}

}
