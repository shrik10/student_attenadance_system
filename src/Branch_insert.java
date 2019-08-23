import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.sql.DriverManager;
public class Branch_insert extends GenericServlet
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
		
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String seat=request.getParameter("seat");
		try {
			String query="insert into BRANCH values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,bid);
			ps.setString(2,bname);
			ps.setString(3,seat);
			
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