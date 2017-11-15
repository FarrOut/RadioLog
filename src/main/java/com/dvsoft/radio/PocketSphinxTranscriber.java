package com.dvsoft.radio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PocketSphinxTranscriber
{
	private static final Logger logger = LoggerFactory.getLogger(Sphinx4Transcriber.class);

	private static final String filename = "D:\\Workspace\\Source\\Radio " +
			"Log\\samples\\OSR_us_000_0030_8k.wav";

	public static void main(String[] args) throws Exception
	{
		logger.info("Transcribing {}\n", filename);

		String[] cmd = {"D:\\Workspace\\Source\\Radio Log\\pocketsphinx\\bin\\Release\\x64\\pocketsphinx_continuous" +
				".exe", "-infile ..\\..\\..\\..\\samples\\converted.wav", "-lm ..\\..\\..\\model\\en-us\\en-us.lm.bin",
				"-dict ..\\..\\..\\model\\en-us\\cmudict-en-us.dict", "-hmm ..\\..\\..\\model\\en-us\\en-us"};
		Process p = Runtime.getRuntime().exec(cmd);
		p.waitFor();

	}
}
