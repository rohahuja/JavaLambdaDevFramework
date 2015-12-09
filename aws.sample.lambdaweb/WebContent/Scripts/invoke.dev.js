/**
 * This script file contains the function that makes the call to our Java servlet. 
 * This script file is only required during development to emulate invocation of our Lambda
 * function. 
 */

function lambdaFunctionCallback(input) {
	var data = 'param=' + input;
	
	// TODO: LambdaFunctionHandlerWrapper is the url of the Java Servlet we have defined. 
	// This can be updated if you also change the @WebServlet directive at the top of the 
	// LambdaFunctionHandlerWrapper class.
    $.ajax({
        type: "POST",
        url: "LambdaFunctionHandlerWrapper",
        data: data, 
        dataType: "text",

        // Stub to do some operation with a successful response
        success: function (data, textStatus, jqXHR) {
        	onSuccess(data);
        },

        // Stub to do some operation with an erroneous response
        error: function(jqXHR, textStatus, errorThrown){
    		onError(errorThrown);
        },

        // Stub to do some operation prior to sending the AJAX request
        beforeSend: function(jqXHR, settings){
        	onBeforeSend();
        },

        // Stub to do some operation with once the response has been processed
        complete: function(jqXHR, textStatus){
        	onComplete();
        }
    });   
}