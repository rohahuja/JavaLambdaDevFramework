var simPrdJsonArr = null;
var detectShake;
var $debugDiv;

$(document).ready(function () {
    $debugDiv = $('#debug');
    
    //Stops the submit request
    $("#ajax-request-form").submit(function(e){
        e.preventDefault();
    });
    
    $('#sample-btn').on('click', invokeCallback);
});

function invokeCallback() {
	resetAllDivs();
	
	var input = $('#sample-textbox').val();
	
	if (!isInt(input)) {
		onError("Please enter an Integer value in the textbox.");
	}
	else {
		//var json = createJson(input);
		//lambdaFunctionCallback(json);
		lambdaFunctionCallback(input);
	}
}

function isInt(value) {
	return !isNaN(value) && (function(x) { return (x | 0) === x; })(parseFloat(value))
}

/*
function createJson(input) {
	var dataJson = '{ "name": "' + input + '" }';
	return dataJson;
}*/

function onBeforeSend() {
	// Print what time request submitted
	$('#info').html('<p>Request submitted at: ' + new Date() + '</p>');
}

function onSuccess(data) {
	$('#response').html(data);
}

function onComplete() {
	// Print what time response received and Total time
	$('#info').append('<p>Response received at: ' + new Date() + '</p>');
}

function onError(err) {
    $('#err').html(err);
}

function resetAllDivs() {
	$('#response').html('');
	$('#info').html('');
	$('#err').html('');
}
