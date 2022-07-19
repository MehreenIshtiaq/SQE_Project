package businessLogic;

public class Announcement {
	
	private String teacherID;
	private String text;
	private String section;
	private String courseCode;
	
	
	public Announcement(String teacherID, String text, String section, String courseCode) {
		
		this.teacherID = teacherID;
		this.text = text;
		this.section = section;
		this.courseCode = courseCode;
	}
	
	public Announcement(String courseCode, String section, String text) {
		
		this.courseCode=courseCode;
		this.section=section;
		this.text=text;
	}


	public String getteacherID() {
		return teacherID;
	}


	public void setteacherID(String courseID) {
		this.teacherID = courseID;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
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


	@Override
	public String toString() {
		
		
		return "\t\tCourse: "+courseCode+ "      Section: "+section+" \n"+"Announcement: "+"     \n\t"+text+"\n**********************************************************************************************************";
		
	}
	
	

	

}
