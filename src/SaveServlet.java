

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String prn=request.getParameter("id");
		int p=Integer.parseInt(prn.trim());
		
		  // res.setContentType("text/html");
		out.println("<html><body><center><div  style='width:50%; margin-top:100px'><form action='RegServlet?id="+p+"' method='post'>");
		out.write("<style>\r\n" + 
				"td {\r\n" + 
				"  border: 1px solid black;\r\n" + 
				"  text-align:center;\r\n" + 
				"}\r\n" + 
				"</style>");
	    out.write("<a href='index.html'><h1>Search Page</h1></a><br><br><h2>The PRN :"+p+" is Not Present </h2><br><br><h2> Enter The Details</h2><br><br>");
		out.println("OOP  marks: <input type='text' name='txtoop'><br><br><br>");
	    out.println("Java marks: <input type='text' name='txtjava'><br><br><br>");
	    out.println("AWP  marks: <input type='text' name='txtawp'><br><br><br>");
	    out.println("<input type='submit' name='submit' value='Submit'><br>");
		

	    out.println("</form></div></center></body></html>"); 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
