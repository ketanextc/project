

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = res.getWriter();  
		String s=request.getParameter("txtPRN");
		int id = Integer.parseInt(s.trim());
        res.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
             
            Connection con =StudentDao.getConnection();
             
            Statement stmt = con.createStatement(); 
            System.out.println("ID: "+id);
            ResultSet rs = stmt.executeQuery("select * from prn where prn="+id);
            System.out.println("Queery");
            boolean status =rs.next();
            System.out.println("Status is -- > "+status);
            
            if(status==true)
            {	out.write("<style>\r\n" + 
    				"td {\r\n" + 
    				"  border: 1px solid black;\r\n" + 
    				"  text-align:center;\r\n" + 
    				"}\r\n" + 
    				"</style>");
	            out.println("<center><div style='width:50%; margin-top:150px'><a href='index.html'><h1>Search Page</h1></a><br><br><br><h1>Result Displayed</h1><br><br><table border='1' width='100%'>");  
	            out.println("<tr><th>PRN</th><th>OOP</th><th>JAVA</th><th>AWP</th><th>Total Marks</th><th>Percentage</th><tr>");  
	            ResultSet rss = stmt.executeQuery("select * from prn where prn="+id);
	            while (rss.next()) 
	            { 
	            int prn = rss.getInt("prn");  
                int oop= rss.getInt("oop");  
                int java = rss.getInt("java"); 
                int  awp= rss.getInt("awp"); 
                System.out.println("The data present is "+prn+"---"+awp);
		               
		                 int total=oop + java + awp;
		                 System.out.println("Total " +total);
		                
		                out.println("<tr><td>" + prn + "</td><td>" + oop+ "</td><td>" + java + "</td><td>" + awp + "</td><td>"+ total+"/"+300 +"</td><td>"+total/3+"</td></tr>");   
		       //<a href="+"EditServlet?id="+id+">
		            }
		            out.println("</table></div></center>");  
		            out.println("</html></body>");  
		            con.close();  
            }
		           // request.getRequestDispatcher("index.html").include(request, res);
           // }
            else
            {
				request.getRequestDispatcher("SaveServlet?id="+id).include(request, res);
            }
            
            
            }
            catch (Exception e) 
           {  
            out.println("error");  
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
