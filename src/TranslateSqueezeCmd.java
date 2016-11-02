import java.util.HashSet;
import java.util.Set;

public class TranslateSqueezeCmd implements BaseCommand {
	
	private final static String COMMAND_NAME = "translate-squeeze";
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String str){
		char[] arrStr = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		
		for (int i=0; i<arrStr.length; i++){
			set.add(arrStr[i]);
		}
		 return set.toString();
	}

}
