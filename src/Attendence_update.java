import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class Attendence_update extends GenericServlet
{

	Connection con;
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendence","root","shri");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
		public void service (ServletRequest request,ServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String attend=request.getParameter("attend");
		String sid=request.getParameter("sid");
		
		try{
			PreparedStatement st=con.prepareStatement("UPDATE ATTENDENCE set attend=? where sid=?");
		   st.setString(1,attend);
		   st.setString(2,sid);
		  
		st.executeUpdate();
		int i=st.executeUpdate();
		if(i>0)
			pw.println("Updated one row");
		else{
			pw.println("<br> row has been updated successfully");
		}
		}catch(Exception e)
		{
			
			pw.println(e);
		}
		pw.print("<center><a href='link.html'>BACK</a>");
		pw.close();
	}
}
	
	