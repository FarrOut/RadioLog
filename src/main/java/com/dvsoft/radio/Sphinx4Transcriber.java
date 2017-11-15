package com.dvsoft.radio;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Sphinx4Transcriber
{
	private static final Logger logger = LoggerFactory.getLogger(Sphinx4Transcriber.class);

	Configuration configuration;

	public Sphinx4Transcriber()
	{
		configuration = new Configuration();

		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
	}

	public String transcribe(String filename) throws Exception
	{
		logger.info("Transcribing {}\n", filename);

		StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
		InputStream stream = new FileInputStream(new File(filename));

		recognizer.startRecognition(stream);
		SpeechResult result;

		StringBuilder sb = new StringBuilder();

		try
		{
			while ((result = recognizer.getResult()) != null)
			{
				sb.append(result.getHypothesis() + "\n");
				logger.info(result.getHypothesis() + "\n");
			}
		}
		catch (OutOfMemoryError e)
		{
			logger.warn("Failed to complete transcription", e);
		}
		finally
		{
			recognizer.stopRecognition();
			return sb.toString();
		}
	}
}
