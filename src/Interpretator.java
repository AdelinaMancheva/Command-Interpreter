import java.util.Scanner;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Interpretator {
	
	private HashMap<String, BaseCommand> COMMAND_MAP = new HashMap<String, BaseCommand>();
	private HashMap<String, TypeValue> varMap = new HashMap<String, TypeValue>();
	
	private final Collection<BaseCalcOperation> CALC_OPERATIONS = Arrays.asList(new BaseCalcOperation[] { 
			new AdditionTwoStrings(),
			new AdditionTwoNumbers(),
			new SubstractionTwoNumbers(),
			new MultiplicationTwoNumbers(),
			new AdditionTwoDates(),
			new SubstractionTwoDates()
		});
	
	@SuppressWarnings("serial")
	private Map<String, BaseCalcOperation> CALC_OPERATIONS_MAP = new HashMap<String, BaseCalcOperation>() {
		{
			for (BaseCalcOperation operation : CALC_OPERATIONS) {
				put(operation.getOperation(), operation);
			}
		}
	};;
	
	public void initCommandMap(){
		COMMAND_MAP.put("count-words", new CountWordsCmd());
		COMMAND_MAP.put("reverse", new ReverseCmd());
		COMMAND_MAP.put("reverse-words", new ReverseWordsCmd());
		COMMAND_MAP.put("substring", new SubstringCmd());
		COMMAND_MAP.put("capitalize", new CapitalizeCmd());
		COMMAND_MAP.put("translate-squeeze", new TranslateSqueezeCmd());
		COMMAND_MAP.put("get", new GetCmd(varMap));
		COMMAND_MAP.put("set", new SetCmd(varMap));
		COMMAND_MAP.put("calc", new CalcCmd(varMap, CALC_OPERATIONS_MAP));
	}
	
	public void printVarMap(){
		for (String s : varMap.keySet()){
			System.out.print(s + "\n");
		}
	}
	
	public static void main(String[] argsMain) {
		
		Interpretator inerpretator = new Interpretator();		
		inerpretator.initCommandMap();
		
		Scanner scan = new Scanner(System.in);
			
		while (true){
			String line = scan.nextLine();

			InputProcessing processInput = new InputProcessingFactory().processInput(line);

			String commandName = processInput.getCmdName();
			String commandArgs = processInput.getCmdArguments();
				
			BaseCommand command = inerpretator.COMMAND_MAP.get(commandName);
			String result = command.execute(commandArgs);
				
			System.out.println(result);
//			scan.close();	
		}
	}
}

