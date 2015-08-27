package ch03.ex01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DelayLogging {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public void logIf(Level level, Supplier<Boolean> flag, Supplier<String> msg) {
		if (logger.isLoggable(level) && flag.get())
			logger.info(msg.get());
	}


	
	public static void main(String[] args) {
		DelayLogging test = new DelayLogging();
		String a[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
		final int i = 10;//あとで考える。
		test.logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]);		
	}
}