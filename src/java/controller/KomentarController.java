/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBnovosti;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comments;
import model.News;
import model.User;

/**
 *
 * @author korisnik
 */
public class KomentarController extends HttpServlet {

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
          
        String action=request.getParameter("action");
        
         String address="prikaziNovost.jsp";
        if(action!=null){
            
            switch(action){
                case "dodaj":
                    dodajKomentar(request,response);
                   
                    break;
                case "obrisiKomentar":
                    obrisiKomentar(request,response);
                   
                    
                    break;
                case "urediKomentar":
                    urediKomentar(request,response);
                    break;
                          
            }
        
        }
         prikaziJednu(request,response);
         RequestDispatcher rd=request.getRequestDispatcher(address);
        rd.forward(request, response);
        
    }
    
    public void dodajKomentar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idu=parseInt(request.getParameter("idu"));
        int idn=parseInt(request.getParameter("idn"));
        String komentar=request.getParameter("komentar");
                   
        Comments c=new Comments();
        c.setComment(komentar);
        c.setIduser(idu);
        c.setIdnews(idn);
        try{
            DBnovosti db=new DBnovosti();
           db.dodajKomentar(c);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

     public void prikaziJednu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id=0;
           if(request.getParameter("idn")!=null){
            id=parseInt(request.getParameter("idn"));
       }
         DBnovosti db=new DBnovosti();
         News n=db.findNews(id);
         request.setAttribute("News", n);
        User u= db.findUserById(n.getIduser());
         request.setAttribute("U", u);
             List<Comments> c=db.findAllCommentsByIdNews(id);
         request.setAttribute("Comments", c);
          List<User> users=db.findAllUsers();
          request.setAttribute("Korisnici", users);
     }
     
     public void obrisiKomentar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id=parseInt(request.getParameter("id"));
         
           try{
            DBnovosti db=new DBnovosti();
           db.obrisiKomentar(id);
        }catch(Exception e){
            System.out.println(e);
        }
        
     }
     
       public void urediKomentar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             int id=parseInt(request.getParameter("id")); 
             String k=request.getParameter("komentar");
           try{
            DBnovosti db=new DBnovosti();
            Comments c=new Comments();
            c.setComment(k);
            c.setId(id);
           db.urediKomentar(c);
        }catch(Exception e){
            System.out.println(e);
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
