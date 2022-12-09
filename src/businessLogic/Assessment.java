
package businessLogic;

public class Assessment {
	
	private int SN;
	private String rollNumber;
	private String obtainedMarks;
	private double totalMarks;
	private double absolutes;
	private double ObtainedMarks;
	//private String assessmetnName;
	private String courseCode;
	
	
	public Assessment(int SN,String obtainedMarks, double totalMarks, double absolute) {
		
		this.obtainedMarks=obtainedMarks;
		this.totalMarks= totalMarks;
		this.absolutes= absolute;
		this.SN= SN;
		
		
		
	}
	
	public Assessment(String rollNumber, double ObtainedMakrs, double totalMarks, double absolute) {
		
		
		this.ObtainedMarks=ObtainedMarks;
		this.totalMarks= totalMarks;
		this.absolutes= absolute;
		this.rollNumber= rollNumber;
		
		
	}
	public Assessment(String rollNumber, String obtainedMarks, double totalMarks, double absolutes, String courseCode) {
	
		
		this.rollNumber = rollNumber;
		this.obtainedMarks = obtainedMarks;
		this.totalMarks = totalMarks;
		this.absolutes = absolutes;
		this.courseCode=courseCode;
		
	}

	
	
	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public double getAbsolutes() {
		return absolutes;
	}

	public void setAbsolutes(double absolutes) {
		this.absolutes = absolutes;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	

	public int getSN() {
		return SN;
	}
	public void setSN(int sN) {
		SN = sN;
	}
	@Override
	public String toString() {
		return "Assessment [rollNumber=" + rollNumber + ", obtainedMarks=" + obtainedMarks + ", totalMarks="
				+ totalMarks + ", absolutes=" + absolutes+ ", courseCode="
				+ courseCode + " SN"+SN;
	}


	
}
