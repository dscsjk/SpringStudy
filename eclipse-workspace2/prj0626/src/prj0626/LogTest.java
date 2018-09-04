package prj0626;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTest {

	public static void LogTest(String msg) {
		Logger logger = LoggerFactory.getLogger(LogTest.class);
		logger.info("test log");
		logger.warn("test log : {}", msg);
	}
}
