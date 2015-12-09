package aws.sample.lambda;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.charset.Charset;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.commons.io.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Integer, String> {

	@Override
    public String handleRequest(Integer input, Context context) {
		return String.format("Lambda says you typed in: %s!", input);
    }
    
	/*
	public static void handler(InputStream inputStream, OutputStream outputStream, Context context)  throws IOException {
		//String inputJson = IOUtils.toString(inputStream); //.getInputStream());
		
		JsonObject myObj = null;
	    
	    try {
	    	JsonReader reader = Json.createReader(inputStream);
			JsonObject paramsObj = reader.readObject();
			reader.close();
			
	    	// Extract input
			String nameParam = paramsObj.getString("name");
			
	        // TODO: implement your handler
	    	String responseStr = "Hello from your Lambda function, " + nameParam + "!";
	    	myObj = Json.createObjectBuilder()
	    			.add("success", "true")
					.add("itemInfo", responseStr)
    			.build();
	    }
	    catch (Exception e) {
	    	myObj = Json.createObjectBuilder()
    			.add("success", "false")
    			.add("error", "An error has occurred. Please see CloudWatch logs for details.")
    			.build();
	    }
	    
	    String json = myObj.toString();
	    outputStream.write(json.getBytes(Charset.forName("UTF-8")));
    }
	
    /*@Override
    public String handleRequest(String input, Context context) {
    	return "hello";
    	
    	/*
    	Logger logger = new Logger(context);
	    logger.write("Input: " + input);
*/
	    
	    
	    /*String json;
	    
	    try {
	    	//json = input.replace("\"", "");
	    	JsonReader reader = Json.createReader(new StringReader(input));
			JsonObject paramsObj = reader.readObject();
			reader.close();
			String nameParam = paramsObj.getString("name");
	    }
	    catch (Exception e) {}
	    
	    try {
	    	json = input.replace("'", "\"");
	    	JsonReader reader = Json.createReader(new StringReader(json));
			JsonObject paramsObj = reader.readObject();
			reader.close();
			String nameParam = paramsObj.getString("name");
	    }
	    catch (Exception e) {}
	    
	    try {
	    	json = "{ \"name\": \"hi\" }";
	    	JsonReader reader = Json.createReader(new StringReader(json));
			JsonObject paramsObj = reader.readObject();
			reader.close();
			String nameParam = paramsObj.getString("name");
	    }
	    catch (Exception e) {}
	    
	    input = input.replace("'", "\"");*/
	    
	    /*
	    JsonObject myObj = null;
	    
	    try {
	    	JsonReader reader = Json.createReader(new StringReader(input));
			JsonObject paramsObj = reader.readObject();
			reader.close();
			
	    	// Extract input
			String nameParam = paramsObj.getString("name");
			
	        // TODO: implement your handler
	    	String responseStr = "Hello from your Lambda function, " + nameParam + "!";
	    	myObj = Json.createObjectBuilder()
	    			.add("success", "true")
					.add("itemInfo", responseStr)
    			.build();
	    }
	    catch (Exception e) {
	    	myObj = Json.createObjectBuilder()
    			.add("success", "false")
    			.add("error", "An error has occurred. Please see CloudWatch logs for details.")
    			.build();
	    }
	    
	    return myObj.toString();
    }*/
}
