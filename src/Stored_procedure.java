import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class Stored_procedure extends GenericServlet {  
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
      CallableStatement cmt=con.prepareCall("CALL Branch_display();");
 ResultSet rs=cmt.executeQuery(); 
 pw.print("<table border='1'>");
	pw.print("<tr width=600px>");
	pw.print("<th width=600px>"+"Branch id"+"</th>");
	pw.print("<th width=600px>"+"Branch name"+"</th>");
	pw.print("<th width=600px>"+"seat"+"</th>");

	pw.print("</tr>");
while(rs.next())  
{
	pw.print("<tr>");
String bid=rs.getString("bid");	
String bname=rs.getString("bname");
String seat=rs.getString("seat");


pw.print("<td>"+bid+"</td>");
pw.print("<td>"+bname+"</td>");
pw.print("<td>"+seat+"</td>");

pw.print("</tr>");

}
//Step 5: Close the connection
pw.print("</table>");
}catch(Exception e)
{ 
	System.out.println(e);
}  
		pw.println("<body style='background-color:#c6b8f7;'>");
		pw.print("<center><a href='link.html'>BACK</a>");
		pw.close();
} 

}  