package aws.sample.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.bcscanner.lambda.Logger;

public class LambdaFunctionHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
		Logger logger = new Logger(context);
	    logger.write("Input: " + input);

        // TODO: implement your handler
        return "Hello " + input + "!";
    }
}
