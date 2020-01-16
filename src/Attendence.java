import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Attendence {
	String username;
	String date;
	boolean attendence_mark;

	public Attendence(){};
	public Attendence(String username, String date, boolean b) {
		this.username = username;
		this.date = date;
		this.attendence_mark = b;
	}
	
	public void giveAttendnce(HashMap<Integer,Attendence> attendence,String Username,int userid) {	
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date dateobject = new Date();
	    date = formatter.format(dateobject);
	    Attendence attendenceobject = new Attendence(Username,date,true);
	    attendence.put(userid,attendenceobject);
	    
	    System.out.println("Attendence mark for today"+date);
	}

}
