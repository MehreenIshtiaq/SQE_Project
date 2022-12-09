package testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import businessLogic.LMS;

public class ViewTranscriptSuite {

	LMS lms = new LMS();
	@Test
	public void ViewTranscript_TC88() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.viewTranscript("SE2002","P", "Quiz","72","20i1881");
		
	
		String c= outContent.toString();
		 
		assertEquals("Transcript displayed successfully!", c);
	}

}
