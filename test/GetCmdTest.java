import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Adelina
 * 
 * Contains tests for {@link GetCommand}.
 *
 */

public class GetCmdTest {

	private GetCmd getCmd;
	private HashMap<String, TypeValue> varMap;

	private static final TypeValue fisrtTypeValue = new TypeValue("number", "12");
	private static final TypeValue secondTypeValue = new TypeValue("string", "talent");

	private static void putVars(HashMap<String, TypeValue> varMap) {
		varMap.put("f", fisrtTypeValue);
		varMap.put("s", secondTypeValue);
	}

	@Before
	public void setUp() {
		varMap = new HashMap<String, TypeValue>();
		putVars(varMap);
		getCmd = new GetCmd(varMap);
	}

	@Test
	public void testGetCommandName() {
		String cmdName = getCmd.getCommandName();
		assertEquals("get", cmdName);
	}

	@Test
	public void testExecuteOneVariable() {
		String res = getCmd.execute("f");
		assertEquals("[number] 12", res);
	}

	@Test
	public void testExecuteTwoVariables() {
		String res1 = getCmd.execute("f");
		String res2 = getCmd.execute("s");
		assertEquals("[number] 12", res1);
		assertEquals("[string] talent", res2);

	}
	
	@Test
	public void testExecuteWhenMapEmpty() {
		varMap = new HashMap<String, TypeValue>();
		getCmd = new GetCmd(varMap);
		String res = getCmd.execute("f");
		assertEquals("Err", res);
	}

	@Test
	public void testExecuteInvalidVariable() {
		String res = getCmd.execute("hfeg");
		assertEquals("Err", res);
	}

}