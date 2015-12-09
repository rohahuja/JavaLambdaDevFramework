/**
 * 
 */
package aws.sample.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * The Logger class which will only log to CloudWatch if the Lambda function has been deployed.
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
		// This case would be true when running the Lambda function locally
		if (logger == null) {
			return;
		}
		
		logger.log(message);
	}
}
