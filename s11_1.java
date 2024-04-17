import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class servletDatabase extends HttpServlet 
{ 
Connection cn;
public void init()
{
try
{
Class.forName(“org.postgresql.Driver ");
Connection cn=DriverManager.getConnection("jdbc:odbc:hospital_data","","");
System.out.println("Hii");
}
catch(Exception ce)
{ 
System.out.println("Error"+ce.getMessage());
}
}
public void doGet(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException 
{
resp.setContentType("text/html");
PrintWriter pw=resp.getWriter(); 
try
{
int rno=Integer.parseInt(req.getParameter("t1")); 
String qry="Select * from customer where name="+name; 
Statement st=cn.createStatement();
ResultSet rs=st.executeQuery(qry); 
int flag=0;
while(rs.next())
{
Flag=1;
pw.print("<table border=1>");
pw.print("<tr>");
pw.print("<td>" + rs.getInt(1) + "</td>");
pw.print("<td>" + rs.getString(2) + "</td>");
pw.print("<td>" + rs.getFloat(3) + "</td>");
pw.print("</tr>");
pw.print("</table>");
}
if flag==0)
pw.print("NO RECORD FOUND………..");
}
catch(Exception se){}
pw.close();
}
}

