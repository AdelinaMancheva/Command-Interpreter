
public class AdditionTwoStrings implements BaseCalcOperation {
	
	private final static String OPERATION = "[string]+[string]";
	private final static String TYPE = "string";
	
	@Override
	public String getOperation() {
		return OPERATION;
	}

	@Override
	public String execute(String firstVar, String secondVar) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(firstVar);
		builder.append(secondVar);
		
		return builder.toString();
	}
	
	@Override
	public String getType(){
		return TYPE;
	}

}
