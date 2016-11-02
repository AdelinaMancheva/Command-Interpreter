import java.util.HashMap;


/**
 * @author Adelina
 *
 * obtain variable and print in the format
 * [<type>] <value>
 */
public class GetCmd implements BaseCommand {
	
	private final static String COMMAND_NAME = "get";
	private HashMap<String, TypeValue> map;
	
	public GetCmd(HashMap<String, TypeValue> map){
		this.map = map;
	}

	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String args){
		String[] argsArr = args.split(" ");
		
		if (map.containsKey(argsArr[0])){
			return map.get(argsArr[0]).toString();
		}
		return "Err";
	}

}
