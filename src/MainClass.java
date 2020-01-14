import java.util.Scanner;

public class MainClass {
	static String username;
	private static int password;
	static Scanner input;
	public static void main(String[] args) {

		// Object[] a = new Object[4];
		input = new Scanner(System.in);

		Manager[] managerobject = new Manager[2];
		Executives[] executiveobject = new Executives[2];
		Lead[] leadobject = new Lead[2];

		managerobject[0] = new Manager(1, "abc", 1234, "abc@intimetec.com");
		managerobject[1] = new Manager(2, "cde", 5678, "cde@intimetec.com");

		executiveobject[0] = new Executives(1, "fgh", 1234, "fgh@intimetec.com");
		executiveobject[1] = new Executives(2, "ijk", 5678, "ijk@intimetec.com");

		leadobject[0] = new Lead(1, "klm", 1234, "klm@intimetec.com");
		leadobject[1] = new Lead(1, "nop", 1234, "nop@intimetec.com");

		Employees employee_object = new Employees(managerobject, executiveobject, leadobject);

		takeInputFromUser(input);
		validateUser(employee_object, username, password);

	}

	static void takeInputFromUser(Scanner input) {
		System.out.println("Enter user name");
		username = input.next();
		System.out.println("Enter Password");
		password = input.nextInt();
	}

	static void validateUser(Employees employee_object, String username, int password) {
		String getdesignation, getusername;
		int size = employee_object.executive.length + employee_object.lead.length + employee_object.manager.length;
		int j = 0;

		boolean k = true;
		while (k) {
			if (j <= size) {
				if (username.equals(employee_object.executive[j].getUsername())
						&& password == employee_object.executive[j].getPassword()) {
					getdesignation = employee_object.executive[j].getDesignation();
					getusername = employee_object.executive[j].getUsername();
					employeeFunctionalities(getdesignation, getusername);
					k = false;
				} else if (username.equals(employee_object.lead[j].getUsername())
						&& password == employee_object.lead[j].getPassword()) {
					getdesignation = employee_object.lead[j].getDesignation();
					getusername = employee_object.lead[j].getUsername();
					employeeFunctionalities(getdesignation, getusername);
					k = false;
				} else if (username.equals(employee_object.manager[j].getUsername())
						&& password == employee_object.manager[j].getPassword()) {
					getdesignation = employee_object.manager[j].getDesignation();
					getusername = employee_object.manager[j].getUsername();
					employeeFunctionalities(getdesignation, getusername);
					k = false;
				} else {
					j++;
				}

			} else {
				System.out.println("not exist");
			}
		}
	}

	static void employeeFunctionalities(String getdesignation, String getusername) {
		switch (getdesignation) {

		case "Executive":
			displayExecutiveLevelFunctionalities(getdesignation, getusername);
			break;
		case "Lead":
			displayExecutiveLevelFunctionalities(getdesignation, getusername);
			displayLeadLevelFunctionalities(getdesignation, getusername);
			break;
		case "Manager":
			displayExecutiveLevelFunctionalities(getdesignation, getusername);
			displayLeadLevelFunctionalities(getdesignation, getusername);
			displayManagerLevelFunctionalities(getdesignation, getusername);
			break;

		}
	}

	static void displayExecutiveLevelFunctionalities(String designation, String username) {
		System.out.println("welcome " + username);
		System.out.println("you are working here as: " + designation);
		System.out.println("");
		System.out.println("1.Give Attendence");
		System.out.println("2.Request for Leave");
		System.out.println("3.Cancel Approve Leave");
		System.out.println("4.Avail a leave(if it is approved)");
		System.out.println("5.Check status of leave");
	}

	static void displayLeadLevelFunctionalities(String designation, String username) {
		System.out.println("6.Approve Executive's Leave");
		System.out.println("7.Revoke Executive's Leave");
	}

	static void displayManagerLevelFunctionalities(String designation, String username) {
		System.out.println("8.Approve lead's Leave");
		System.out.println("9.Revoke lead's Leave");
		System.out.println("10.Administartive Function");
		System.out.println("11.Credit, debit or adjust employee leave");
	}

}
