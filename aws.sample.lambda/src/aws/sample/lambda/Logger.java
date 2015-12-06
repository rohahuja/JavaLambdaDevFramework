/**
 * 
 */
package aws.sample.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * @author Administrator
 *
 */
public class Logger {
	private static LambdaLogger logger;
	
	public Logger(Context context){
		if (context != null) {
			logger = context.getLogger();
		}
	}
	
	public void write(String message) {
		if (logger == null) {
			return;
		}
		
		logger.log(message);
	}
	
	// TODO: Implement Dispose to get rid of this at the end of the context?
}
