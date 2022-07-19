package businessLogic;

public class FebrecatedGrade {
	
	
	
	private String courseCode;
	private String rollNumber;
	private String grade;
	

	
	public FebrecatedGrade() {
		//empty
	}
	
	public FebrecatedGrade(String rollNumber, String courseCode, String grade){
		
		
		this.courseCode=courseCode;
		this.rollNumber=rollNumber;
		this.grade=grade;
		
	}

	public void setGrade(String grade) {
		
		this.grade=grade;
		
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "FebrecatedGrade [ courseCode=" + courseCode
				+ ", rollNumber=" + rollNumber + ", grade=" + grade + "]";
	}
	
	
	
	
	

}
