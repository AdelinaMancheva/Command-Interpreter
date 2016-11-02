
public class CapitalizeCmd implements BaseCommand {
	
	private final static String COMMAND_NAME = "capitalize";
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String args){
		return args.toUpperCase();
	}
}
