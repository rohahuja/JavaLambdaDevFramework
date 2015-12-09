/**
 * 
 */

function lambdaFunctionCallback(input) {
    //var dataJson = "json=" + JSON.stringify("{ 'name': '" + input + "' }");
    var dataJson = 'param=' + input;
    
    //make the AJAX request, dataType is set to json
    //meaning we are expecting JSON data in response from the server
    $.ajax({
        type: "POST",
        url: "LambdaFunctionHandlerWrapper",
        data: dataJson, 
        dataType: "text", //"json",

        //if received a response from the server
        success: function (data, textStatus, jqXHR) {
        	onSuccess(data);
        	/*if (data.success) {
        		onSuccess(data.itemInfo);
        	} 
        	else {
        		onError(data.itemInfo);
        	}*/
        },

        //If there was no response from the server
        error: function(jqXHR, textStatus, errorThrown){
    		onError(textStatus);
        },

        //capture the request before it was sent to server
        beforeSend: function(jqXHR, settings){
        	onBeforeSend();
        },

        //this is called after the response or error functions are finished
        //so that we can take some action
        complete: function(jqXHR, textStatus){
        	onComplete();
        }
    });   
}