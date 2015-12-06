var simPrdJsonArr = null;
var detectShake;
var $debugDiv;

$(document).ready(function () {
    $debugDiv = $('#debug');
    
    //Stops the submit request
    $("#ajax-request-form").submit(function(e){
        e.preventDefault();
    });
    
    $('#sample-btn').on('click', lambdaFunctionCallback);
});

function invokeCallback() {
	var input = $('sample-textbox').val();
	
	if (input.length < 1) {
		onError("Please enter a name in the textbox.");
	}
	else {
		lambdaFunctionCallback(input);
	}
}

function onBeforeSend() {
	// Print what time request submitted
	var $info = $('info');
	$info.html('<p>Request submitted at: ' + new Date() + '</p>');
}

function onSuccess(data) {
	
}

function onComplete() {
	// Print what time response received and Total time
	var $info = $('info');
	$info.append('<p>Response received at: ' + new Date() + '</p>');
}

function onError(err) {
	console.log("Terminal error: " + err);
    $('err').html(err);
}

