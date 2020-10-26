/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 726772
 */
public class ShoppingListServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action"); 
        
        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        if (session.getAttribute("username") != null) {  
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
  
        ArrayList<String> list = new ArrayList<>();
        
        if(action.equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
            response.sendRedirect("ShoppingList");
        }
        else if(action.equals("add")) {
            
            list = (ArrayList<String>) session.getAttribute("list");
            if(list == null) {
                list = new ArrayList<>();
            }            
            String item = request.getParameter("item");
            list.add(item);
            session.setAttribute("list", list);
            response.sendRedirect("ShoppingList");
        }
        else if (action.equals("delete")) {
            String deleteitem = request.getParameter("item");
            list = (ArrayList<String>) session.getAttribute("list");
            list.remove(deleteitem);
            session.setAttribute("list", list);
            response.sendRedirect("ShoppingList");
            
        }
        
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
