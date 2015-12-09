package aws.sample.lambdaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aws.sample.lambda.*;

/**
 * Servlet implementation class used pass control between the client-side AJAX call
 * to the Lambda function.
 */
@WebServlet("/LambdaFunctionHandlerWrapper")
public class LambdaFunctionHandlerWrapper extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
        
        // Extract parameter passed in by AJAX
        String input = request.getParameter("param");
        
        try (PrintWriter out = response.getWriter()) {
        	// Instantiate the Lambda function class
        	LambdaFunctionHandler function = new LambdaFunctionHandler();
        	
        	// Call the function to emulate its execution
        	String lambdaResponse = function.handleRequest(input, null);
        	
        	// Return the response to the AJAX
        	out.println(lambdaResponse);
        }
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LambdaFunctionHandlerWrapper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
