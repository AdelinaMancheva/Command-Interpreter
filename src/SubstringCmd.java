
public class SubstringCmd implements BaseCommand {
	
	private static final String COMMAND_NAME = "substring";
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String words) {
		String[] arrWords = words.split(" ");
		if(arrWords[0].toLowerCase().contains(arrWords[1].toLowerCase())){
			return "true";
		}
		return "false";
	}


}
