import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class Student_insert extends GenericServlet
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
		String sname=request.getParameter("sname");
		String address=request.getParameter("address");
		String bid=request.getParameter("bid");
		try {
			String query="insert into STUDENT values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,sid);
			ps.setString(2,sname);
			ps.setString(3,address);
			ps.setString(4,bid);
			
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