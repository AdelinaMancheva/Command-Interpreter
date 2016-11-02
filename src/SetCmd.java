import java.util.HashMap;


/**
 * @author Adelina
 * 
 * crate varible and store it in map
 * 
 */
public class SetCmd implements BaseCommand {
	
	private final static String COMMAND_NAME = "set";
	private HashMap<String, TypeValue> map;
	
	public SetCmd(HashMap<String, TypeValue> map){
		this.map = map;
	}
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String args){
		String[] arrayArgs = args.split(" ");
		
		String varName = arrayArgs[0];
		String type = arrayArgs[1];
		String value = arrayArgs[2];
		
		TypeValue objTypeValue = new TypeValue(type, value);
		
		map.put(varName, objTypeValue);
		
		return "OK";
	}

}
