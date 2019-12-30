

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		System.out.println("ID: "+p);
		
		Student s=new Student();
		s.setPrn(p);
		String oop=request.getParameter("txtoop");
		int oo=Integer.parseInt(oop);
		s.setOop(oo);
		String java=request.getParameter("txtjava");
		int jav=Integer.parseInt(java);
		s.setJava(jav);
		String awp=request.getParameter("txtawp");
		int aw=Integer.parseInt(awp);
		s.setAwp(aw);
		
		try {
			int status= StudentDao.save(s);
			System.out.println("Save Status "+status);
			if(status > 0)
			{
				
				request.getRequestDispatcher("index.html").include(request, response);
			//	pw.write("<center>Registeration done..</center>");
			}
			else {
				out.write("Registeration failed");
				request.getRequestDispatcher("index.html").include(request, response);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
