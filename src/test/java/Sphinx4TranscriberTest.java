import com.dvsoft.radio.Sphinx4Transcriber;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class Sphinx4TranscriberTest
{

	Sphinx4Transcriber cut;

	@Before
	public void setUp() throws Exception
	{
		cut = new Sphinx4Transcriber();
	}

	@Test
	public void testTranscribeStream() throws Exception
	{
		String filename = "D:\\Workspace\\Source\\Radio " +
				"Log\\samples\\OSR_us_000_0030_8k.wav";

		String result = cut.transcribe(filename);

		System.out.println(result);

		assertNotNull(result);
	}
}
