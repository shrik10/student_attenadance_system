import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class Branch_delete  extends GenericServlet
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
		String bid=request.getParameter("bid");
		
		try{
			PreparedStatement st=con.prepareStatement("delete from Branch where bid=?");
		   st.setString(1,bid);
		st.executeUpdate();
		int i=st.executeUpdate();
		if(i!=0)
			pw.println("deleting row..");
		else{
			pw.println("<br> row has been deleted successfully");
		}
		}catch(Exception e)
		{
			
			pw.println(e);
		}
		 pw.println("one tuple deleted");
		pw.print("<center><a href='link.html'>BACK</a>");
		pw.close();
	}
}
	
	