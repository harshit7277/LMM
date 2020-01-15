import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Leave {

	String date;
	String leavetype;
	int leavenumber;
	boolean approval;

	String leave_type[] = { "Casual leave", "Earn Leave", "Duty Leave", "Sick", "Leave", "Maternity Leave",
			"Parental Leave", "Leave without pain" };

	public Leave() {
	};

	public Leave(String date, String leavetype, int leavenumber,boolean approval) {
		this.date = date;
		this.leavetype = leavetype;
		this.leavenumber = leavenumber;
		this.approval = approval;
	}

	public void requestForLeave(HashMap<Integer,Leave> leave_details, int userid, String inputdate, String leave_type,
			int leavesnumber , boolean approval) {

		Leave leave_object = new Leave(inputdate, leave_type, leavesnumber,approval);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		Date dateobject = new Date();
		String dateformat = formatter.format(dateobject);

		try {
			Date input_date = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH).parse(inputdate);
			Date current_date = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH).parse(dateformat);

			if (current_date.compareTo(input_date) < 0) {
				leave_details.put(userid,leave_object);
				System.out.println("Requested for leave on:" + inputdate);
			} else {
				System.out.println("please enter correct date ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
