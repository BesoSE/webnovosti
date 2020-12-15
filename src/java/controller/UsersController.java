/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBnovosti;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author korisnik
 */
public class UsersController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
//    public UsersController(){
//        super();
//    }
//    
//    public void init(ServletConfig config)throws ServletException{
//        super.init(config);
//             DBnovosti db=new DBnovosti();
//        List<User> ul=db.findAllUsers();
//          ServletContext context=config.getServletContext();
//        if(ul.size()>0){
//          
//            context.setAttribute("Users", ul);
//        } else{
//  //        request.setAttribute("message", "Trenutno nema korisnika");
//        }
//        
//    }
//    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String address="users.jsp";
    
        try{
         DBnovosti db=new DBnovosti();
        List<User> ul=db.findAllUsers();
        if(ul.size()>0){
            request.setAttribute("Users",ul); 
            request.setAttribute("message", "Korisnici");
        } else{
            request.setAttribute("message", "Trenutno nema korisnika");
        }
        
         
         
     }catch(Exception e){
     System.out.println(e);
     }
     
     RequestDispatcher rd=request.getRequestDispatcher(address);
     rd.forward(request, response);
    }

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
        processRequest(request, response);
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
processRequest(request, response);
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
