package aws.sample.lambdaweb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aws.sample.lambda.*;

/**
 * Servlet implementation class LambdaFunctionHandlerWrapper
 */
@WebServlet("/LambdaFunctionHandlerWrapper")
public class LambdaFunctionHandlerWrapper extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        
        String input = request.getParameter("param");
        int inputInt = Integer.parseInt(input);
        
        try (PrintWriter out = response.getWriter()) {
        	/*
        	InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        	LambdaFunctionHandler.handler(inputStream, outputStream, null);
        	
        	out.println(outputStream.toString());*/
        	
        	LambdaFunctionHandler function = new LambdaFunctionHandler();
        	String lambdaResponse = function.handleRequest(inputInt, null);
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
