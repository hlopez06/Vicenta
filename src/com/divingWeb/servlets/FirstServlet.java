package com.divingWeb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class FirstServlet extends HttpServlet{
 
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                  throws ServletException, IOException {
           
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("hoy es " + new Date());
            out.println("</body>");
            out.println("</html>");
 }
}