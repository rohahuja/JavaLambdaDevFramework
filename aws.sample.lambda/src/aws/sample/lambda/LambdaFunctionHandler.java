package aws.sample.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * The sample Lambda function.
 */
public class LambdaFunctionHandler implements RequestHandler<String, String> {

	@Override
	public String handleRequest(String input, Context context) {
		Logger logger = new Logger(context);
		logger.write("Input received: " + input);
		
		// Do something with the input
		return String.format("Hello from Lambda, %s!", input);
    }
}
