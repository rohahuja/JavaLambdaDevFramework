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
	
}

function onSuccess() {
	
}

function onComplete() {
	
}

function onError(info) {
	console.log("Terminal error: " + info);
    $('err').html(info);
}

