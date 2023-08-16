package com.internship;
import java.io.IOException;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show")

public class Data extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

		public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
			
			try{
			
				Connection connect = DbConnection.Connectiontodatabase();
				String query = "SELECT Fname, Lname, Aadhar, VaccinationState, Dose1, Dose2 from user_details WHERE Vaccinationstate = 'Vaccinated'";
				
				Statement st = connect.createStatement();
				ResultSet rs =  st.executeQuery(query);

				res.getWriter().println("<html>");
				res.getWriter().println("<head>");
				res.getWriter().println("<link href=https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css rel=stylesheet integrity=sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU crossorigin=anonymous>");
				res.getWriter().println("<title>Vaccination Data </title>");
				res.getWriter().println("<style>");
				
				res.getWriter().println("body{ background-color: gray; background: url(AdminL.jpeg) no-repeat center center fixed;    } ");
				res.getWriter().println(" .center{ color: white;  font-size: 30px; ");
				res.getWriter().println(" position: absolute; ");
				res.getWriter().println(" top: 280px;");
				res.getWriter().println("left: 380px ");
				res.getWriter().println("}");
				res.getWriter().println(" #h{color: white; font-size: 40px; ");
				res.getWriter().println(" position: absolute;");
				res.getWriter().println("top: 150px;");
				res.getWriter().println("left: 600px ");
				res.getWriter().println("}");
				res.getWriter().println(".old{font-size: 25px; color: white;}");
				res.getWriter().println(".New{font-size: 22px; color: white;}");
				res.getWriter().println(" #one{ position: absolute; top: 85%; left: 41%}");
				res.getWriter().println(" #two{ position: absolute; top: 85%; left: 51%}");	
				res.getWriter().println(" .com{color: white; height: 30px; text-decoration: none; background-color: cyan; color:black; border-radius: 8px;  }");	
				res.getWriter().println("</style>");
				res.getWriter().println("</head>");
				res.getWriter().println("<body>");
//				res.getWriter().println("<div class=spinner-border role=status><span class=visually-hidden >Loading...</span></div>");
				res.getWriter().println("<h1 id=h>Vaccinated Users Details</h1>");
				res.getWriter().println("<table class=center  border=2 width=60% height=50>");  
				res.getWriter().println("<tr><th class=old >First Name</th><th class=old>Last Name</th><th class=old>Aadhar No.</th><th class=old>Vaccination State</th><th class=old>Dose1</th><th class=old>Dose2 </th><tr>");  
		
				int v=0;
			    while(rs.next()){
			    	String fname = rs.getString("Fname");
			    	String lname = rs.getString("Lname");
			    	String Aadhar = rs.getString("Aadhar");
			    	String Vaccination = rs.getString("VaccinationState");
			    	String dose1 = rs.getString("Dose1");
			    	String dose2 = rs.getString("Dose2");
			    
			    	if(Vaccination.equals("Vaccinated")){
			    		v=1;
			    		res.getWriter().println("<tr><td class=new>"+fname+"</td><td class=new>"+lname+"</td><td class=new>"+Aadhar+"</td><td class=new>"+Vaccination+"</td><td class=new>"+dose1+"</td><td class=new>"+dose2+"</td></tr>");
			    	}
			    }
			    if(v==0){
			    	res.sendRedirect("Vcnull.html");
			    }
			    
			    res.getWriter().println(" <button id=one class=com type=button class=btn btn-primary> <a class=com href=index.html>Go To Home </a></button>");
			    res.getWriter().println(" <button id=two class=com type=button class=btn btn-primary> <a class=com href=Info.jsp>Go To Admin Panel </a></button>");
			  
			    res.getWriter().println("</body>");
			    res.getWriter().println("</html>");
				
			}catch(Exception e){}
			
		}
			
	}	