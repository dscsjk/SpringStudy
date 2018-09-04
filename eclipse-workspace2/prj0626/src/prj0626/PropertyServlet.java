package prj0626;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class PropertyServlet
 */
@WebServlet(

		urlPatterns = {"/PropertyServlet"},
		initParams = {
				@WebInitParam(name="name1", value="jin"),
				@WebInitParam(name="name2", value="may")
	})

public class PropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		out.println("<html><body><center>");
		out.println("<h2>ch14:PropertyServlet</h2>");
		out.println("<hr>");
		out.println("name1 :"+getInitParameter("name1")+"<BR>");
		out.println("name2 :"+getInitParameter("name2"));
		out.println("<hr>");
		out.println("name3 :"+getServletContext().getInitParameter("name3")+"<BR>");
		out.println("</center></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
