import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Adelina
 * 
 * Contains tests for {@link ReverseCmd}.
 *
 */
public class ReverseCmdTest {

	ReverseCmd revCmd;

	@Before
	public void setUp() {
		revCmd = new ReverseCmd();
	}

	@Test
	public void testGetCommandName() {
		String cmdName = revCmd.getCommandName();
		assertEquals("reverse", cmdName);
	}

	@Test
	public void testExecuteWithOneWord() {
		String execution = revCmd.execute("talent");
		assertEquals("tnelat", execution);
	}

}