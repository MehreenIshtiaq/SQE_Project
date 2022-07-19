package businessLogic;

public class Attendance {
	
	private String studentID;
	private String section;
	private String courseCode;
	private String name;
	private String date;
	private String status;
	
	public Attendance(String courseCode, String status, String date) {
		
		this.courseCode=courseCode;
		this.status=status;
		this.date=date;
	}
	public Attendance(String name, String rollNo, String section, String courseCode) {
		
		this.name=name;
		this.studentID=rollNo;
		this.section=section;
		this.courseCode=courseCode;
		
	}
	
	public Attendance(String name, String rollNo, String section, String courseCode, String status , String date) {
	
		this.studentID = rollNo;
		this.section = section;
		this.courseCode = courseCode;
		this.name = name;
		this.date = date;
		this.status=status;
	}
	
	public String getStatus() {
		
		return status;
	}

	public void setStatus(String status) {
		this.status=status;
		
	}
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Attendance [studentID=" + studentID + ", section=" + section + ", courseCode=" + courseCode + ", name="
				+ name + ", date=" + date +" Status "+status;
	}
		
	

}
