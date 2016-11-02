
public class CountWordsCmd implements BaseCommand {
	
	private static String COMMAND_NAME = "count-words";
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String str){
			
			int len = str.length();
			int counter = 0;
			
			for (int i=0; i<len; i++){
				if(str.charAt(i) != ' '){
					counter++;
					while(str.charAt(i) != ' ' && i < len-1){
						i++;
					}
				}
			}			
		return counter + "";
		}
		

}
