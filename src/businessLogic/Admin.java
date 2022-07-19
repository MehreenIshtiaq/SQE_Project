package businessLogic;

public class Admin {

	private String adminName="Admin";
	private String password="123";
	private int adminID=101;
	
	Profile profile= new Profile();
	
	
	public Admin() {
	
	}

	public String getAdminName() {
		return adminName;
	}

	
	public String getPassword() {
		return password;
	}

	
	public int getAdminID() {
		return adminID;
	}

	
	public void addStudent(String studentDegree, String rollNumber, String address, String phoneNumber, String firstName,
			String lastName, String section, String gender, String batch, String cNIC, String email, String password) {

		
			profile.addStudent(studentDegree, rollNumber, address, phoneNumber, firstName, lastName, section, gender, batch, cNIC, email, password);


	}
	
	public void addTeacher(String firstName, String lastName, String address, String employeeID, String eMail,
			String phoneNumber, String coordinateID, String qualification, String gender, String password) {
		
		profile.addTeacher(firstName, lastName, address, employeeID, eMail, phoneNumber, coordinateID, qualification, gender, password);
	}
	
}


