
public class ReverseCmd implements BaseCommand{
	
	private static final String COMMAND_NAME = "reverse";
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String str){
		int len = str.length();
		StringBuilder builder = new StringBuilder();
		
		for (int i=len-1; i>=0; i--){
			builder.append(str.charAt(i));
		}
		
		return builder.toString();
	}
	

}
