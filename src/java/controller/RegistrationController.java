/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBnovosti;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
public class RegistrationController extends HttpServlet {

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
        doPost(request, response);
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
       String fn=request.getParameter("firstName");
       String ln=request.getParameter("lastName");
       String email=request.getParameter("email");
       String pwd=request.getParameter("password");
       String rpwd=request.getParameter("repeat");
       String action=request.getParameter("action");
       User u=new User();
       u.setFirstName(fn);
       u.setLastName(ln);
       u.setRole("ROLE_USER");
       
       String address="login.jsp";
      if(pwd.length()>7){
       if(pwd.equals(rpwd)){
            u.setPassword(pwd); 
       
       
       try{
           DBnovosti db=new DBnovosti();
           
           if(db.findEmail(email)==false){
                u.setEmail(email);
                db.register(u);
                request.setAttribute("message", "Uspjesna registracija");
                  if(action!=null){
         ;
          List<User> ul=db.findAllUsers();
            request.setAttribute("Users", ul);
          address="users.jsp";
      }
                
           }else{
               
               address="register.jsp";
               request.setAttribute("error", "Email se koristi");
           }
           
           
           
           
       }catch(Exception e){
           System.out.println(e);
       }
     }else{
           request.setAttribute("error", "Molimo unesite poonovno password");
                if(action!=null){
                   address="dodajkorisnika.jsp";   
                  }else{
                       address="register.jsp";
                  }
       }
      }else{
           request.setAttribute("error", "Molimo unesite password 8 karaktera");
              
                  if(action!=null){
                   address="dodajkorisnika.jsp";   
                  }else{
                       address="register.jsp";
                  }
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
