package businessLogic;

public class Course {
	
	private String courseName;
	private String courseCode;
	private String creditHours;
	private String type;
	private String grade;
	
	public Course(){
		
		//empty
	}
	public Course(String courseName, String courseCode, String creditHours, String type, String grade) {
		
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.creditHours = creditHours;
		this.type = type;
		this.grade = grade;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getCreditHours() {
		return creditHours;
	}


	public void setCreditHours(String creditHours) {
		this.creditHours = creditHours;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	
	@Override
	public String toString() {
		return  courseName + " "+ courseCode + " "+creditHours+ " "+ type + " "+grade ;
	}	
	

}
