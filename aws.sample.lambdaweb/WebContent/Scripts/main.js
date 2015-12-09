/**
 * This script file contains all functions external the Lambda invocation.
 */

$(document).ready(function () {
    $debugDiv = $('#debug');
    
    // Stops the submit request
    $("#ajax-request-form").submit(function(e){
        e.preventDefault();
    });
    
    // Add the event listener to invoke the function on the button
    $('#sample-btn').on('click', invokeCallback);
});

// Calls the invocation function
function invokeCallback() {
	resetAllDivs();
	
	var input = $('#sample-textbox').val();
	
	if (input.length < 1) {
		onError("Please enter your name in the textbox.");
	}
	else {
		lambdaFunctionCallback(input);
	}
}

// Stub to do some operation with a successful response
function onBeforeSend() {
	// Print the time request submitted
	$('#info').html('<p>Request submitted at: ' + new Date() + '</p>');
}

// Stub to do some operation prior to sending the AJAX request
function onSuccess(data) {
	$('#response').html(data);
}

// Stub to do some operation with once the response has been processed
function onComplete() {
	// Print the time response received
	$('#info').append('<p>Response received at: ' + new Date() + '</p>');
}

// Stub to do some operation with an erroneous response
function onError(err) {
    $('#err').html(err);
}

// The following function is only required by our working sample and can be removed for your purposes.
function resetAllDivs() {
	$('#response').html('');
	$('#info').html('');
	$('#err').html('');
}
