
public class ReverseWordsCmd implements BaseCommand{
	
	private static final String COMMAND_NAME = "reverse-words";
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	@Override
	public String execute(String str){
			
			StringBuilder reversed = new StringBuilder();
			String[] splittedString = str.toString().split(" ");
			
			for (int i=0; i<splittedString.length; i++){
				
				StringBuilder helpBuilder = new StringBuilder();
				
				if(i == 0){
					helpBuilder.append(splittedString[i]);
					
				} else {
					helpBuilder.append(splittedString[i] + " ");
				}			
				reversed.append(helpBuilder);
			}		
			return reversed.toString();		
		}

}
