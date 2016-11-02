import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AdditionTwoDates implements BaseCalcOperation {
	
	private final static String OPERATION = "[date]+[number]";
	private final static String TYPE = "date";

	@Override
	public String getOperation() {
		return OPERATION;
	}

	@Override
	public String execute(String firstVar, String secondVar) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Calendar c = Calendar.getInstance();
			Date date = sdf.parse(firstVar);
			c.setTime(date); 
			int secondVarToInt = Integer.parseInt(secondVar);
			c.add(Calendar.DATE, secondVarToInt); 
			String output = sdf.format(c.getTime());
			
			return output;
			
		} catch(ParseException e){

		} finally {
		}
		
		return "";
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
