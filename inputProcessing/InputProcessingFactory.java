
public class InputProcessingFactory {
	
	public InputProcessing processInput(String line){
		return new SystemTrace(line);
	}

}
