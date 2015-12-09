/**
 * This script file contains the function that makes the call to our DEPLOYED Lambda function. 
 * It requires the function to have been deployed to the AWS account with appropriate IAM configurations.
 */

$(document).ready(function () {
    // Instead of leaving your access key details exposed in a js file, a better practice 
	// would be setting up Cognito to authenticate the request. 
	// The credentials are passed in using the method below for brevity.
	var params = {
        accessKeyId: 'AKIAIFV7VRQE5J4HMBKA',
        secretAccessKey: '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'
    };

    // Set the Amazon Cognito region
    AWS.config.region = 'us-east-1';
    AWS.config.credentials = new AWS.Credentials(params);
});

function lambdaFunctionCallback(data) {
	// Need to add additional escaped quotes as this input is parsed 
	// as valid JSON by the AWS Lambda runtime before it gets to the function 
	data = '\"' + data + '\"';
	
	// Stub to do some operation prior to making the Lambda call
	onBeforeSend();
    
	// TODO: SampleFunction should be updated to the name you have given
	// to the Lambda function at the time of uploading it to AWS. This is NOT
	// necessarily your function class name.
	var lambda = new AWS.Lambda();
    lambda.invoke({
	        FunctionName: "SampleFunction",
	        Payload: data
	    }, 
	    function(err, data){
	    	if (err == null && !data.FunctionError) {
	    		// Stub to do some operation with a successful response
    			onSuccess(data.Payload);
	    	}
	    	else {
	    		// Stub to do some operation with an erroneous response
	    		if (err == null) {
	    			// Error is thrown within the function
	    			onError(data.Payload);
	    		}
	    		else {
	    			// Error is thrown by the AWS Lambda service
	    			onError(err);
	    		}
	    	}
	    	
	    	// Stub to do some operation with once the response has been processed
	    	onComplete();
	    }
    );
}