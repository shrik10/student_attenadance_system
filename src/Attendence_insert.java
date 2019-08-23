import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class Attendence_insert extends GenericServlet
{

	private static final long serialVersionUID = 1L;
	Connection con;
	public void init() throws ServletException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendence","root","shri");
			}catch(Exception e)
		     {
				System.out.println(e);
			}
	}
	
	public void service(ServletRequest request,ServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String sid=request.getParameter("sid");
		String stid=request.getParameter("stid");
		String subject=request.getParameter("subject");
		String attend=request.getParameter("attend");
		String date=request.getParameter("date");
		try {
			String query="insert into ATTENDENCE values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,sid);
			ps.setString(2,stid);
			ps.setString(3,subject);
			ps.setString(4,attend);
			ps.setString(5,date);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				pw.println("VALUES INSERTED SUCCESSFULLY");
			}else
			{
				pw.println("VALUES DOES NOT INSERTED SUCCESSFULLY");
			}
			
		}catch(Exception e)
		{
			pw.println("ERROR"+e);
		}
		
		pw.println("<a href='link.html'>BACK</a>");
	}
}