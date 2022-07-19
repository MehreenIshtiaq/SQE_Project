package businessLogic;

public class AssignCourse {
	
	private int assignmentID;
	private String courseCode;
	private String teachetID;
	
	public AssignCourse(int assignmentID, String courseCode, String teachetID) {
		super();
		this.assignmentID = assignmentID;
		this.courseCode = courseCode;
		this.teachetID = teachetID;
	}

	public int getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getTeachetID() {
		return teachetID;
	}

	public void setTeachetID(String teachetID) {
		this.teachetID = teachetID;
	}

	@Override
	public String toString() {
		return "assignmentID=" + assignmentID + ", courseCode=" + courseCode + ", teachetID=" + teachetID;
				
	}
	
	
	
	
	

}
