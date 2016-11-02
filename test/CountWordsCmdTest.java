import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Adelina
 * 
 * Contains tests for {@link CountWordsCmd}.
 *
 */
public class CountWordsCmdTest {

	CountWordsCmd countWords;

	@Before
	public void setUp() {
		countWords = new CountWordsCmd();
	}

	@Test
	public void testDetCommandName() {
		String cmdName = countWords.getCommandName();
		assertEquals("count-words", cmdName);
	}

	@Test
	public void testExecuteWithOneWord() {
		String execution = countWords.execute("talent");
		assertEquals("1", execution);
	}

	@Test
	public void testExecuteWithTwoWords() {
		String execution = countWords.execute("talent boost");
		assertEquals("2", execution);
	}

	@Test
	public void testExecuteWithThreeWords() {
		String execution = countWords.execute("talent boost vmware");
		assertEquals("3", execution);
	}

	@Test
	public void testExecuteWithMoreEmptySpaces() {
		String execution = countWords.execute("talent boost   academy  ");
		assertEquals("3", execution);
	}
}