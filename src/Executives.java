
public class Executives extends EmployeesProfile {

	String designation;

	public Executives(int id, String username, int password, String email) {
		super(id, username, password, email);
		this.designation = "Executive";
	}

	public String getDesignation() {
		return designation;
	}

}
