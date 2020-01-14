
public class Lead extends EmployeesProfile {

	String designation;

	public Lead(int id, String username, int password, String email) {
		super(id, username, password, email);

		this.designation = "Lead";
	}

	public String getDesignation() {
		return designation;
	}

}
