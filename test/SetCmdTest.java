import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Adelina
 * 
 * Contains tests for {@link SetCmd}.
 *
 */

public class SetCmdTest {

	private SetCmd setCmd;
	private HashMap<String, TypeValue> varMap;
	
	@Before
	public void setUp() {
		varMap = new HashMap<String, TypeValue>();
		setCmd = new SetCmd(varMap);
	}

	@Test
	public void testGetCommandName() {
		String cmdName = setCmd.getCommandName();
		assertEquals("set", cmdName);
	}

	@Test
	public void testExecuteReturn() {
		String execution = setCmd.execute("var1 string talent");
		assertEquals("OK", execution);
	}

	@Test
	public void testExecute_WhetherVariableIsInTheMap_WithOneVariable() {
		setCmd.execute("var1 string abc");
		TypeValue typeValue = varMap.get("var1");
		assertEquals("string", typeValue.getType());
		assertEquals("abc", typeValue.getValue());
	}

}