package aws.sample.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

//import aws.sample.lambda.Logger;

public class LambdaFunctionHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
		Logger logger = new Logger(context);
	    logger.write("Input: " + input);

	    try {
	        // TODO: implement your handler
	        // TODO: Do something with input;
	    }
	    catch (Exception e) {
	    	// Do something
	    }
	    finally {
	    	//logger.Dispose(); // TODO: Is this required?
	    }
	    
        return "Hello " + input + "!";
    }
}
