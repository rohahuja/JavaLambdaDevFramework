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

function lambdaFunctionCallback(input) {
    var dataJson = "json=" + JSON.stringify("{ 'input': '" + input + "' }");
    
    onBeforeSend();
    
	var lambda = new AWS.Lambda();
    lambda.invoke({
	        FunctionName: "LambdaFunctionHandlerWrapper",
	        Payload: dataJson
	    }, 
	    function(err, data){
	    	if (err == null) {
	    		onSuccess();
	    	}
	    	else {
	    		onError(err);
	    	}
	    }
    );
    
	onComplete();
}