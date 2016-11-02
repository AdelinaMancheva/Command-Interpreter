
public class SystemTrace implements InputProcessing {
	
	private String line;
	
	public SystemTrace(String line) {
		this.line = line;
	}
	
	@Override
	public String[] getLineInArray() {
		String[] lineArr = line.split(" ");
		
		return lineArr;
	}

	@Override
	public String getCmdName() {
		String[] args = getLineInArray();
		String commandName = args[0];
		
		return commandName;
	}

	@Override
	public String getCmdArguments() {
		String[] args = getLineInArray();
		StringBuilder builder = new StringBuilder();
		
		for(int i=1; i<args.length; i++){
			builder.append(args[i] + " ");
		}
		
		return builder.toString();
	}

}
