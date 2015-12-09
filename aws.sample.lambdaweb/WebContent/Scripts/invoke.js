/**
 * 
 */

$(document).ready(function () {
    var params = {
        AccountId: "454979696062",
        RoleArn: "arn:aws:iam::454979696062:role/Cognito_BCScannerUnauth_Role",
        IdentityPoolId: "us-east-1:6c84f4c2-783c-40fe-9e15-57923e2924da"
    };

    // set the Amazon Cognito region
    AWS.config.region = 'us-east-1';

    // initialize the Credentials object with our parameters
    AWS.config.credentials = new AWS.CognitoIdentityCredentials(params);
});

function lambdaFunctionCallback(dataJson) {
    //var dataJson = "json=" + JSON.stringify("{ 'name': '" + input + "' }");
    
    onBeforeSend();
    
	var lambda = new AWS.Lambda();
    lambda.invoke({
	        FunctionName: "SampleFunction",
	        Payload: dataJson
	    }, 
	    function(err, data){
	    	if (err == null) {
    			onSuccess(data.Payload);
	    		/*}
	    		else {
	    			// Error source is an exception raised within the Lambda function
	    			onError(data.error);
	    		}*/
	    	}
	    	else {
	    		// Error source is related to the invocation of the Lambda function
	    		onError(err);
	    	}
	    	
	    	onComplete();
	    }
    );
    
	
}