/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBnovosti;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author korisnik
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    doPost(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           String email=request.getParameter("email");
       String pwd=request.getParameter("password");
       String address="NovostiController?action=prikazinovosti";
       try{
           DBnovosti db=new DBnovosti();
           User u=db.findUserByEmailAndPassword(email,pwd);
           if(u.getFirstName()==null){
               address="login.jsp";
               request.setAttribute("error", "Unesite tacan email  i sifru.");
           }else{
                              if(u.isStatus()){
                  
               
              request.getSession().setAttribute("User", u);
              
               request.setAttribute("message", "Uspjesan login");
               }else{
                  request.setAttribute("error", "Trenutno se ne mozete prijaviti zbog statusa neaktivan");
                  
               }
           }
           
           
           
       }catch(Exception e){
           request.getSession().invalidate();
           System.out.println(e);
       }
       
        
        
       RequestDispatcher rd=request.getRequestDispatcher(address);
       rd.forward(request, response);
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
