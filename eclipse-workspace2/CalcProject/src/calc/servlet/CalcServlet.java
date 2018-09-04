package calc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.model.Calc;

/**
 * Servlet implementation class CalcServlet
 */
 @WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1=0, n2=0, rNum=0;
		String op="";
		
		if(request.getMethod().equals("POST")) {
			n1=Integer.parseInt(request.getParameter("n1"));
			n2=Integer.parseInt(request.getParameter("n2"));
			op= request.getParameter("operator");
		}
		
		Calc rCal = new Calc();
		rNum = rCal.cal(n1,n2,op);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");		
		out.println("<html><body><h1><center>result : " + rNum + "</center></body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
