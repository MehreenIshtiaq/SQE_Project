package testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import businessLogic.LMS;

public class MakeAnnouncementSuite {

	LMS lms = new LMS();
	@Test
	public void MakeAnnouncementSuccess_TC89() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.makeAnnouncement("emp1_SE", "Recording", "P", "SE2002");
		
	
		String c= outContent.toString();
		 
		assertEquals("A new announcement record was inserted successfully!", c);
	}
	
	@Test
	public void MakeAnnouncementInvalidInput_TC90() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.makeAnnouncement("emp1_SE", "Recording", "P", "SE20023**");
		
	
		String c= outContent.toString();
		 
		assertEquals("Announcement was not inserted due to Invalid Course Code!", c);
	}
	
	@Test
	public void MakeAnnouncementBlankFields_TC91() {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		lms.makeAnnouncement("emp1_SE", "", "P", "");
		
	
		String c= outContent.toString();
		 
		assertEquals("Announcement was not inserted due to Blank Fields!", c);
	}

}
