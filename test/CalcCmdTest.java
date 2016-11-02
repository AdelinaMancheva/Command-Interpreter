import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Adelina
 * 
 * Contains tests for {@link CalcCmd}.
 * 
 */

public class CalcCmdTest {

	private CalcCmd calcCmd;
	private HashMap<String, TypeValue> varMap;
	private Map<String, BaseCalcOperation> operations;
	
	
	private TypeValue stringTalentTypeValue = new TypeValue("string", "talent");
	private TypeValue stringBoostTypeValue = new TypeValue("string", "boost");
	
	private TypeValue numberFiveTypeValue = new TypeValue("number", "5");
	private TypeValue numberSixTypeValue = new TypeValue("number", "6");
	
	private TypeValue resString = new TypeValue("string", "talentboost");
	
	private AdditionTwoStrings addStrings = new AdditionTwoStrings();
	private MultiplicationTwoNumbers multiplyNumbers = new MultiplicationTwoNumbers();
	
	private void putVars(Map<String, TypeValue> varMap) {
		varMap.put("talent", stringTalentTypeValue);
		varMap.put("boost", stringBoostTypeValue);
		
		varMap.put("5", numberFiveTypeValue);
		varMap.put("6", numberSixTypeValue);
		
		varMap.put("talentboost", resString);
	}

	private void putOperations(Map<String, BaseCalcOperation> operations) {
		operations.put(addStrings.getOperation(), addStrings);
		operations.put(multiplyNumbers.getOperation(), multiplyNumbers);
	}

	@Before
	public void setUp() {
		varMap = new HashMap<String, TypeValue>();
		operations = new HashMap<String, BaseCalcOperation>();
		putVars(varMap);
		putOperations(operations);
		calcCmd = new CalcCmd(varMap, operations);
	}

	@Test
	public void testGetCommandName() {
		String cmdName = calcCmd.getCommandName();
		assertEquals("calc", cmdName);
	}

	@Test
	public void testExecuteStringPlusString() {
		calcCmd.execute("resString stringTalentTypeValue + stringBoostTypeValue");
		TypeValue typeValue = varMap.get("resString");
		assertEquals("[string]", typeValue.getType());
		assertEquals("talentboost", typeValue.getValue());
	}

	@Test
	public void testExecuteMultiplicationTwoNumbers() {
		calcCmd.execute("res numberFiveTypeValue * numberSixTypeValue");
		TypeValue typeValue = varMap.get("res");
		assertEquals("[number]", typeValue.getType());
		assertEquals("30", typeValue.getValue());
	}

}