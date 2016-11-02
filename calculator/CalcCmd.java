import java.util.HashMap;
import java.util.Map;

public class CalcCmd implements BaseCommand {
	
	private final static String COMMAND_NAME = "calc";
	private final static String RETURN_SUCCESS = "OK";
	
	private Map<String, BaseCalcOperation> operations;
	private HashMap<String, TypeValue> varMap = new HashMap<String, TypeValue>();
	
	private GetCmd getCmd;
	
	public CalcCmd(HashMap<String, TypeValue> varMap, Map<String, BaseCalcOperation> operations){
		this.varMap = varMap;
		this.operations = operations;
		getCmd = new GetCmd(varMap);
	}
	
	@Override
	public String getCommandName(){
		return COMMAND_NAME;
	}
	
	// set var1 number 1
	// set var2 string 2
	
	// calc var3 var1 + var2
	
	public String[] splitArgs(String args){
		String[] arrayArgs = args.split(" ");
		
		return arrayArgs;
	}
	
	public String getFirstVar(String args){
		String[] arrayArgs = splitArgs(args);
		
		return arrayArgs[1];
	}
	
	public String getSecondVar(String args){
		String[] arrayArgs = splitArgs(args);
		
		return arrayArgs[3];
	}
	
	public String getOperation(String args){
		String[] arrayArgs = splitArgs(args);
		
		return arrayArgs[2];
	}
	
	@Override
	public String execute (String args) {
		
		String[] arrayArgs = splitArgs(args);
		
		String resVar = arrayArgs[0];
		String operation = getOperation(args);
		
		String[] firstVarTypeAndValue = getCmd.execute(getFirstVar(args)).split(" ");
		String[] secondVarTypeAndValue = getCmd.execute(getSecondVar(args)).split(" ");
		
		String typeFirstVar = firstVarTypeAndValue[0];
		String typeSecondVar = secondVarTypeAndValue[0];
		
		String valueFirstVar = firstVarTypeAndValue[1];
		String valueSecondVar = secondVarTypeAndValue[1];
		
		String operationName = typeFirstVar + operation + typeSecondVar;
		BaseCalcOperation op = operations.get(operationName);
		String execution = op.execute(valueFirstVar, valueSecondVar);
		String typeToPut = op.getType();
		TypeValue typeValue = new TypeValue(typeToPut, execution);
		
		varMap.put(resVar, typeValue);
		
		// set date1 date 19.05.2016
		// set day date 32
		// calc date date1 + days
		
		return RETURN_SUCCESS;
	}
}
