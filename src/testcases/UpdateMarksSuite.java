package testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import businessLogic.Assessment;
import businessLogic.LMS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UpdateMarksSuite {

	LMS lms = new LMS();
	@Test
	public void UpdateMarks_TC83() throws SQLException {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		ArrayList<Assessment> att= new ArrayList<Assessment>();
		att.add(new Assessment("20i1881", 20.5, 25, 10));
		
	
		ObservableList <Assessment> data;
		data= FXCollections.observableArrayList(att);
		
		
		lms.updateAssessment(data, "SE2002", "P", "Quiz");
		
	
		String c= outContent.toString();
		 
		assertEquals("Feature NOT implemented completely!", c);
	}
	
	
	
	
	

}




