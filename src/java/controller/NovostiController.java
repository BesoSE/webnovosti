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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import model.Comments;
import model.News;
import model.User;

/**
 *
 * @author korisnik
 */
public class NovostiController extends HttpServlet {

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
   //int id=parseInt(request.getParameter("id"));
       String action=request.getParameter("action");
        
        
        
         String address="index.jsp";
        if(action!=null){
            
            switch(action){
                case "dodajnovost":
                      
                    dodajNovost(request,response);
                  prikazi(request,response);
                    break;
                case "prikazinovosti":
                    prikazi(request,response);
                
         
                    break;
                case "pregled":
                    prikaziJednu(request,response);
                    address="prikaziNovost.jsp";
                    break;
                case "uredinovostP":
                    prikaziJednu(request,response);
                    address="urediNovost.jsp";
                    break;
                    case "uredinovost":
                        urediNovost(request,response);
                    prikaziJednu(request,response);
                    address="prikaziNovost.jsp";
                    break;
                    
                    case "obrisi":
                        obrisiNovost(request,response);
                     prikazi(request,response);
                    break;
                
              }
            
        }
        RequestDispatcher rd=request.getRequestDispatcher(address);
        rd.forward(request, response);
       
    }
    
    public void dodajNovost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naslov=request.getParameter("naslov");
       String tekst=request.getParameter("tekst");
        int idu=1;
       if(request.getParameter("id")!=null){
            idu=parseInt(request.getParameter("id"));
       }
       
       News n=new News();
       n.setTitle(naslov);
       n.setText(tekst);
       n.setIduser(idu);
        
    
       try{
           DBnovosti db=new DBnovosti();
         db.dodajNovosti(n);
           request.setAttribute("message", "Uspjesno dodana novost");
       }catch(Exception e){
           System.out.println(e);
          
       }
       
       
        
    }
    public void urediNovost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naslov=request.getParameter("naslov");
       String tekst=request.getParameter("tekst");
        int id=1;
       if(request.getParameter("id")!=null){
            id=parseInt(request.getParameter("id"));
       }
       
       News n=new News();
       n.setTitle(naslov);
       n.setText(tekst);
       n.setId(id);
        
    
       try{
           DBnovosti db=new DBnovosti();
         db.urediNovost(n);
           request.setAttribute("message", "Uspjesno dodana novost");
       }catch(Exception e){
           System.out.println(e);
          
       }
       
       
        
    }
    
    
    
     public void prikazi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
         DBnovosti db=new DBnovosti();
         List<News> n=db.findAllNews();
         request.setAttribute("News", n);
         
         
     }
     
       public void prikaziJednu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id=0;
           if(request.getParameter("id")!=null){
            id=parseInt(request.getParameter("id"));
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
       
         public void obrisiNovost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id=0;
           if(request.getParameter("id")!=null){
            id=parseInt(request.getParameter("id"));
       }
         DBnovosti db=new DBnovosti();
         db.obrisiNovost(id);
        
         request.setAttribute("message", "Uspjenso obrisana novost");
         
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
