import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class Trigger extends GenericServlet
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
		
		try{
			PreparedStatement st=con.prepareStatement("SELECT * FROM SCOUNT");
		  
			ResultSet rs=st.executeQuery();
			pw.print("<table border='1'>");
			pw.print("<tr width=600px>");
			pw.print("<th width=600px>"+"scount id"+"</th>");
			pw.print("<th width=600px>"+"attend"+"</th>");
			pw.print("<th width=600px>"+"Students_attended"+"</th>");
			
			pw.print("</tr>");
		     while(rs.next())  
			{
		    	 pw.print("<tr>");
			String tid=rs.getString("tid");	
			String attend=rs.getString("attend");
			String Students_attended=rs.getString("Students_attended");
		
				
			
			pw.print("<td>"+tid+"</td>");
			pw.print("<td>"+attend+"</td>");
			pw.print("<td>"+Students_attended+"</td>");
			
			
			pw.print("</tr>");
			   
			}
		     
				pw.print("</table>");
		}catch(Exception e)
		{
			
			pw.println(e);
		}
		pw.println("<body style='background-color:#f0b6b6;'>");
		pw.print("<center><a href='link.html'>BACK</a>");
		pw.close();
	}
}
	
	