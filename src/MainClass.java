import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MainClass {
	static String username;
	private static int password;
	static Scanner input;
	static int choice;
	static Attendence attendenceobject;
	static Leave leaveobject;
	static HashMap<Integer, Attendence> attendence_details;
	static HashMap<Integer, Leave> leave_details_executives;
	static HashMap<Integer, Leave> leave_details_lead;
	static HashMap<Integer, Leave> leave_details_manager;
	static Leave leav_data, leavdata1;
	static Employees employee_object;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		attendenceobject = new Attendence();
		leaveobject = new Leave();

		Manager[] managerobject = new Manager[2];
		Executives[] executiveobject = new Executives[2];
		Lead[] leadobject = new Lead[2];

		attendence_details = new HashMap<Integer, Attendence>();
		leave_details_executives = new HashMap<Integer, Leave>();
		leave_details_lead = new HashMap<Integer, Leave>();
		leave_details_manager = new HashMap<Integer, Leave>();
		managerobject[0] = new Manager(1, "abc", 1234, "abc@intimetec.com");
		managerobject[1] = new Manager(2, "cde", 5678, "cde@intimetec.com");

		executiveobject[0] = new Executives(3, "fgh", 1234, "fgh@intimetec.com");
		executiveobject[1] = new Executives(4, "ijk", 5678, "ijk@intimetec.com");

		leadobject[0] = new Lead(5, "klm", 1234, "klm@intimetec.com");
		leadobject[1] = new Lead(6, "nop", 1234, "nop@intimetec.com");

		employee_object = new Employees(managerobject, executiveobject, leadobject);
		takeInputFromUser(input);

	}

	static void takeInputFromUser(Scanner input) {
		System.out.println("1.LOGIN");
		System.out.println("2.EXIT");
		System.out.println("Enter youe choice");
		int inputget = input.nextInt();
		switch (inputget) {
		case 1:
			System.out.println("Enter user name");
			username = input.next();
			System.out.println("Enter Password");
			password = input.nextInt();
			validateUser(employee_object, username, password);
			break;
		case 2:
			System.out.println("Thanks for using this application");
			break;
		default:
			System.out.println("wrong input");
			break;
		}

	}

	static void validateUser(Employees employee_object, String username, int password) {
		String getdesignation, getusername;
		int getid;
		int size = employee_object.executive.length;
		int j = 0;

		boolean k = true;
		while (k) {
			if (j <= size) {
				if (username.equals(employee_object.executive[j].getUsername())
						&& password == employee_object.executive[j].getPassword()) {
					getdesignation = employee_object.executive[j].getDesignation();
					getusername = employee_object.executive[j].getUsername();
					getid = employee_object.executive[j].getId();
					employeeFunctionalities(getdesignation, getusername, getid);
					k = false;
				} else if (username.equals(employee_object.lead[j].getUsername())
						&& password == employee_object.lead[j].getPassword()) {
					getdesignation = employee_object.lead[j].getDesignation();
					getusername = employee_object.lead[j].getUsername();
					getid = employee_object.lead[j].getId();
					employeeFunctionalities(getdesignation, getusername, getid);
					k = false;
				} else if (username.equals(employee_object.manager[j].getUsername())
						&& password == employee_object.manager[j].getPassword()) {
					getdesignation = employee_object.manager[j].getDesignation();
					getusername = employee_object.manager[j].getUsername();
					getid = employee_object.manager[j].getId();
					employeeFunctionalities(getdesignation, getusername, getid);
					k = false;
				} else {
					j++;
					if (j == size) {
						System.out.println("user doesn't exist");
						return;
					}
				}

			} else {
				System.out.println("not exist");
			}
		}
	}

	static void employeeFunctionalities(String getdesignation, String getusername, int getuserid) {
		switch (getdesignation) {

		case "Executive":
			displayExecutiveLevelFunctionalities(getdesignation, getusername, getuserid);
			performFunctionalities(getusername, getuserid, getdesignation);
			break;
		case "Lead":
			displayExecutiveLevelFunctionalities(getdesignation, getusername, getuserid);
			displayLeadLevelFunctionalities(getdesignation, getusername, getuserid);
			performFunctionalities(getusername, getuserid, getdesignation);
			break;
		case "Manager":
			displayExecutiveLevelFunctionalities(getdesignation, getusername, getuserid);
			displayLeadLevelFunctionalities(getdesignation, getusername, getuserid);
			displayManagerLevelFunctionalities(getdesignation, getusername, getuserid);
			performFunctionalities(getusername, getuserid, getdesignation);
			break;

		}
	}

	static void displayExecutiveLevelFunctionalities(String designation, String username, int userid) {
		System.out.println("welcome " + username);
		System.out.println("you are working here as: " + designation);
		System.out.println("");
		System.out.println("0.Logout");
		System.out.println("1.Give Attendence");
		System.out.println("2.Request for Leave");
		System.out.println("3.Check status of leave");
	}

	static void displayLeadLevelFunctionalities(String designation, String username, int userid) {
		System.out.println("4.Approve Executive's Leave");
		System.out.println("5.Revoke Executive's Leave");
	}

	static void displayManagerLevelFunctionalities(String designation, String username, int userid) {
		System.out.println("6.Approve lead's Leave");
		System.out.println("7.Revoke lead's Leave");
		System.out.println("8.Administartive Function(check attendence)");
		System.out.println("9.Credit, debit or adjust employee leave");
	}

	static void performFunctionalities(String username, int userid, String getdesignation) {
		boolean b = true;
		String inputdatefromuser;
		String leavetypefromuser;
		int inputforleave, leaves_number;
		System.out.println("");

		while (b) {
			System.out.println("Enter your choice");
			choice = input.nextInt();
			switch (choice) {
			case 0:
				b = false;
				takeInputFromUser(input);
				break;
			case 1:
				attendenceobject.giveAttendnce(attendence_details, username, userid);
				break;
			case 2:
				System.out.println("Enter the date for leave(dd/mm/yyyy)");
				inputdatefromuser = input.next();
				System.out.println("Enter the no of days");
				leaves_number = input.nextInt();
				for (int i = 0; i <= (leaveobject.leave_type.length - 1); i++) {
					System.out.println((i + 1) + "." + leaveobject.leave_type[i]);
				}
				System.out.println("");
				System.out.println("Enter the leave type");
				inputforleave = input.nextInt();
				leavetypefromuser = leaveobject.leave_type[inputforleave - 1];
				if (getdesignation.equals("Executive")) {
					leaveobject.requestForLeave(leave_details_executives, userid, inputdatefromuser, leavetypefromuser,
							leaves_number, false);
				} else if (getdesignation.equals("Lead")) {
					leaveobject.requestForLeave(leave_details_lead, userid, inputdatefromuser, leavetypefromuser,
							leaves_number, false);
				} else {
					leaveobject.requestForLeave(leave_details_manager, userid, inputdatefromuser, leavetypefromuser,
							leaves_number, true);
				}
				break;
			case 3:
				if (getdesignation.equals("Executive")) {
					leav_data = leave_details_executives.get(userid);
				} else if (getdesignation.equals("Lead")) {
					leav_data = leave_details_lead.get(userid);
				}
				if (leav_data.approval == false) {
					System.out.println("Leave not approved");
				} else {
					System.out.println("Leave approved");
				}
				break;
			case 4:
				if (getdesignation.equals("Lead") || getdesignation.equals("Manager")) {
					if (leave_details_executives.size() > 0) {
						for (Entry<Integer, Leave> mapElement : leave_details_executives.entrySet()) {
							int key = (Integer) mapElement.getKey();

							Leave value = ((Leave) mapElement.getValue());

							System.out.println(
									"user key: " + key + " Date: " + value.date + " LeaveType: " + value.leavetype);
						}
						System.out.println("");
						System.out.println("Enter the key from above for which you want to approve leave");
						int userkey = input.nextInt();
						leavdata1 = leave_details_executives.get(userkey);
						Leave updateleaveapproval = new Leave(leavdata1.date, leavdata1.leavetype,
								leavdata1.leavenumber, true);
						leave_details_executives.replace(userkey, updateleaveapproval);
						System.out.println("Leave approved");
					} else {
						System.out.println("NO one had applied for leave");
					}

				} else {
					System.out.println("Wrong input");
				}

				break;
			case 5:
				if (getdesignation.equals("Lead") || getdesignation.equals("Manager")) {
					if (leave_details_executives.size() > 0) {
						for (Entry<Integer, Leave> mapElement : leave_details_executives.entrySet()) {
							int key = (Integer) mapElement.getKey();

							Leave value = ((Leave) mapElement.getValue());

							System.out.println(
									"user key: " + key + " Date: " + value.date + " LeaveApproval: " + value.approval);
						}
						System.out.println("");
						System.out.println("Enter the key from above for which you want to revoke leave");
						System.out.println("Note: you can only revoke leave if LeaveApproval is false");
						int userkey = input.nextInt();
						leav_data = leave_details_executives.get(userkey);
						leave_details_executives.replace(userkey,
								new Leave(leav_data.date, leav_data.leavetype, leav_data.leavenumber, false));
						System.out.println("Leave not approved");
					} else {
						System.out.println("No data in leave yet");
					}
				} else {
					System.out.println("Wrong input");
				}

				break;
			case 6:
				if (getdesignation.equals("Manager")) {
					if (leave_details_lead.size() > 0) {
						for (Entry<Integer, Leave> mapElement : leave_details_lead.entrySet()) {
							int key = (Integer) mapElement.getKey();
							Leave value = ((Leave) mapElement.getValue());

							System.out.println(
									"user key: " + key + " Date: " + value.date + " LeaveType: " + value.leavetype);
						}
						System.out.println("");
						System.out.println("Enter the key from above for which you want to approve leave");
						int userkey = input.nextInt();

						leav_data = leave_details_lead.get(userkey);
						leave_details_lead.replace(userkey,
								new Leave(leav_data.date, leav_data.leavetype, leav_data.leavenumber, true));
						System.out.println("Leave Approved");
					} else {
						System.out.println("no manager have applied for leave yet");
					}
				} else {
					System.out.println("Wrong Inpput");
				}
				break;
			case 7:
				if (getdesignation.equals("Manager")) {
					if (leave_details_lead.size() > 0) {
						for (Entry<Integer, Leave> mapElement : leave_details_lead.entrySet()) {
							int key = (Integer) mapElement.getKey();
							Leave value = ((Leave) mapElement.getValue());

							System.out.println(
									"user key: " + key + " Date: " + value.date + " LeaveType: " + value.leavetype);
						}
						System.out.println("");
						System.out.println("Enter the key from above for which you want to revoke leave");
						System.out.println("Note: you can only revoke leave if LeaveApproval is false");
						int userkey = input.nextInt();

						leav_data = leave_details_lead.get(userkey);
						leave_details_lead.replace(userkey,
								new Leave(leav_data.date, leav_data.leavetype, leav_data.leavenumber, false));
						System.out.println("Leave not approved");
					} else {
						System.out.println("NO data for leave");
					}
				} else {
					System.out.println("Wrong Input");
				}
				break;

			case 8:
				if (getdesignation.equals("Manager")) {
					if (attendence_details.size() > 0) {
						for (Entry<Integer, Attendence> mapElement : attendence_details.entrySet()) {
							int key = (Integer) mapElement.getKey();
							Attendence value = ((Attendence) mapElement.getValue());

							System.out.println(
									"user key: " + key + " Date: " + value.date + " Username: " + value.username);
						}
					}
				} else {
					System.out.println("Wrong Input");
				}
				break;
			case 9:
				System.out.println("This functionalities is not implemented! sorry for inconvience");
				break;
			default:
				System.out.println("Wrong Input");
				break;

			}
		}
	}

}
