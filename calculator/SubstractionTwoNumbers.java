
public class SubstractionTwoNumbers implements BaseCalcOperation {
	
	private final static String OPERATION = "[number]-[number]";
	private final static String TYPE = "number";
	
	@Override
	public String getOperation() {
		return OPERATION;
	}

	@Override
	public String execute(String firstVar, String secondVar) {
		int res = Integer.parseInt(firstVar) - Integer.parseInt(secondVar);
		
		return new Integer(res).toString();
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
