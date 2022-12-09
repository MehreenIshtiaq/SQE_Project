package testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import businessLogic.Assessment;
import businessLogic.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UploadMarksSuite {

	Teacher tec = new Teacher();
	
	@Test 
	public void uploadMarksSuccessful_TC85() throws SQLException {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tec.getMarks("SE2002","P","Quiz", "emp1_SE");
		
		ArrayList<Assessment> att= new ArrayList<Assessment>();
		att.add(new Assessment("20i1881", 20.5, 25, 10)); 
		
		
		ObservableList <Assessment> data;
		data= FXCollections.observableArrayList(att);
		tec.uploadAssessment(data, "Quiz", "emp1_SE", "P");
		
		String c= outContent.toString();
		 
		assertEquals("A new marks record was inserted successfully!", c);
	}
	
	@Test 
	public void uploadMarksInvalidInputs_TC86() throws SQLException {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tec.getMarks("SE2002","P","Quiz", "emp1_SE");
		
		ArrayList<Assessment> att= new ArrayList<Assessment>();
		att.add(new Assessment("20i1881", 20.5, 25, 10)); 
		
		
		ObservableList <Assessment> data;
		data= FXCollections.observableArrayList(att);
		tec.uploadAssessment(data, "Quiz", "emp1_SE", "PQR");
		
		String c= outContent.toString();
		 
		assertEquals("A new marks record was NOT inserted due to Invalid Input!", c);
	}
	
	@Test 
	public void uploadMarksBlankFields_TC87() throws SQLException {
		
		final ByteArrayOutputStream outContent= new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		tec.getMarks("SE2002","P","", "emp1_SE");
		
		ArrayList<Assessment> att= new ArrayList<Assessment>();
		att.add(new Assessment("20i1881", 20.5, 25, 10)); 
		
		
		ObservableList <Assessment> data;
		data= FXCollections.observableArrayList(att);
		tec.uploadAssessment(data, "", "emp1_SE", "");
		
		String c= outContent.toString();
		 
		assertEquals("A new marks record was NOT inserted due to some blank input fields!", c);
	}

}
