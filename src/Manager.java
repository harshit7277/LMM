public class Manager extends EmployeesProfile {

	String designation,date;

	public Manager(int id, String username, int password, String email) {
		super(id, username, password, email);
		this.designation = "Manager";
	}

	public String getDesignation() {
		return designation;
	}
	
	

}
