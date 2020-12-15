/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Comments;
import model.News;
import model.User;

/**
 *
 * @author korisnik
 */
public class DBnovosti {
    private static String driverName="com.mysql.jdbc.Driver";
    private static String username="root";
    private static String password="root";
    private static Connection con=null;
    
    static{
        try{
            Class.forName(driverName);
        }catch(ClassNotFoundException e){
            
            
        }
    }
    
    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbnovosti_17_25?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", username, password);
        
    }
    
    private void closeConnection(){
        if(con==null){
            return;
        }
        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
       
        
        
    }
    
   
        //
    
    public boolean findEmail(String email){
        String query="Select email from users where email='"+email+"'";
        int i=0;
      
        try{
            con=getConnection();
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs= pstmt.executeQuery();
           
            while(rs.next()){
                if(rs.getString("email")!=null){
                    i++;
                }
            }
            
            
            pstmt.close();
        }catch(SQLException e){
            e.printStackTrace();
            
        }finally{
            closeConnection();
        }
        if(i>0){
            return true;
        }else{
            return false;
        }
        
    }
    
    
            public String findEmailById(int id){
        String query="Select email from users where id='"+id+"'";
       String em=null;
      
        try{
            con=getConnection();
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs= pstmt.executeQuery();
           
            while(rs.next()){
               em= rs.getString("email");
                
            }
            
            
            pstmt.close();
        }catch(SQLException e){
            e.printStackTrace();
            
        }finally{
            closeConnection();
        }
        
        return em;
    }
        
        public void register(User u){
            String query="INSERT INTO users (first_name,last_name,email,password,role) values (?,?,?,MD5(?),?)";
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, u.getFirstName());
                pstmt.setString(2, u.getLastName());
                pstmt.setString(3, u.getEmail());
                pstmt.setString(4, u.getPassword());
                pstmt.setString(5, u.getRole());
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        
        
    public User findUserByEmailAndPassword(String email, String pwd){
            String query="SELECT * FROM users WHERE email=? AND password=MD5(?)";
            User u=new User();
        try{
            con=getConnection();
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setString(1,email);
            pstmt.setString(2, pwd);
           ResultSet rs= pstmt.executeQuery();
           while(rs.next()){
               u.setId(rs.getInt("id"));
               u.setFirstName(rs.getString("first_name"));
               u.setLastName(rs.getString("last_name"));
               u.setEmail(rs.getString("email"));
               u.setRole(rs.getString( "role"));
               u.setStatus(rs.getBoolean("status"));
           }
           
           pstmt.close();
           
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        
        
        return u;
    }
    
     public void updateStatus(boolean status,int id){
         int i;
         if(status==true){
             i=1;
         }else{
             i=0;
         }
        String query="update users set status='"+i+"' where id='"+id+"'";
        
        try{
        con=getConnection();
 
        PreparedStatement pstmt=con.prepareStatement(query);
        pstmt.executeUpdate();
        pstmt.close();
        
        }catch(SQLException e){
                    e.printStackTrace();
                    
        }finally{
            closeConnection();
        }
    }
     
     
         public void editPWD(String pwd,int id){
        String query="update users set password=MD5('"+pwd+"') where id='"+id+"'";
        
        try{
        con=getConnection();
 
        PreparedStatement pstmt=con.prepareStatement(query);
        pstmt.executeUpdate();
        pstmt.close();
        
        }catch(SQLException e){
                    e.printStackTrace();
                    
        }finally{
            closeConnection();
        }
    }
     
     public void updateRole(String role,int id){
        String query="update users set role='"+role+"' where id='"+id+"'";
        try{
        con=getConnection();
 
        PreparedStatement pstmt=con.prepareStatement(query);
        pstmt.executeUpdate();
        pstmt.close();
        
        }catch(SQLException e){
                    e.printStackTrace();
                    
        }finally{
            closeConnection();
        }
    }
     public void editUser(User u){
           String query="update users set first_name='"+u.getFirstName()+"',"
                   + " last_name='"+u.getLastName()+"',"
                   + " email='"+u.getEmail()+"' "
                   + "where id='"+u.getId()+"'";
        try{
        con=getConnection();
 
        PreparedStatement pstmt=con.prepareStatement(query);
        pstmt.executeUpdate();
        pstmt.close();
        
        }catch(SQLException e){
                    e.printStackTrace();
                    
        }finally{
            closeConnection();
        }
     }
    
    public List<User> findAllUsers(){
        List<User> uList=new ArrayList<User>();
        
        String query="SELECT * FROM users";
        try{
            con=getConnection();
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            
            while(rs.next()){
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setStatus(rs.getBoolean("status"));
                uList.add(u);
                
                
            }
            pstmt.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        
        return uList;
    }
    
     public User findUserById(int id){
        
        User u=new User();
        String query="SELECT * FROM users where id='"+id+"'";
        try{
            con=getConnection();
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            
            while(rs.next()){
               
            u.setId(rs.getInt("id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setStatus(rs.getBoolean("status"));
             
                
                
            }
            pstmt.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        
        return u;
    }
    
    //Novosti
    
       public void dodajNovosti( News n){
            String query="INSERT INTO news (title,text,iduser) values (?,?,?)";
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, n.getTitle());
                pstmt.setString(2, n.getText());
             
                pstmt.setInt(3, n.getIduser());
          
                
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        
         public void urediNovost( News n){
            String query="Update news set title=?, text=? where id=?";
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, n.getTitle());
                pstmt.setString(2, n.getText());
             
                pstmt.setInt(3, n.getId());
          
                
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
        
       
    public List<News> findAllNews(){
        List<News> nList=new ArrayList<News>();
        
        String query="SELECT * FROM news";
        try{
            con=getConnection();
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            
            while(rs.next()){
               News n=new News();
               n.setId(rs.getInt("id"));
               n.setTitle(rs.getString("title"));
               n.setText(rs.getString("text"));
               n.setDate(rs.getDate("date"));
               n.setIduser(rs.getInt("iduser"));
                nList.add(n);
                
                
            }
            pstmt.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        
        return nList;
    }
    
      public News findNews(int id){
        
        News n=new News();
        String query="SELECT * FROM news where id='"+id+"'";
        try{
            con=getConnection();
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            
            while(rs.next()){
               
               n.setId(rs.getInt("id"));
               n.setTitle(rs.getString("title"));
               n.setText(rs.getString("text"));
               n.setDate(rs.getDate("date"));
               n.setIduser(rs.getInt("iduser"));
             
                
                
            }
            pstmt.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        
        return n;
    }
    
     public void obrisiNovost2( int id){
            String query="delete from comments where idNews=?";
            
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
        
             
                pstmt.setInt(1, id);
          
                
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
     public void obrisiNovost( int id){
            obrisiNovost2(id);
            String query="delete from news where id=?";
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
        
             
                pstmt.setInt(1, id);
          
                
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
    
     //Komenatri
     
      public void dodajKomentar(Comments c){
            String query="INSERT INTO comments (comment,idNews,idUser) values (?,?,?)";
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, c.getComment());
                pstmt.setInt(2, c.getIdnews());
             
                pstmt.setInt(3, c.getIduser());
          
                
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
      public List<Comments> findAllCommentsByIdNews(int id){
          String query="Select * from comments where idNews=?";
          List<Comments> com=new ArrayList<>();
          try{
              con=getConnection();
              PreparedStatement pstmt=con.prepareStatement(query);
              pstmt.setInt(1, id);
              ResultSet rs=pstmt.executeQuery();
              while(rs.next()){
                  Comments c=new Comments();
                  c.setId(rs.getInt("id"));
                  c.setComment(rs.getString("comment"));
                  c.setIdnews(rs.getInt("idNews"));
                  c.setIduser(rs.getInt("idUser"));
                  com.add(c);
              }
              
              pstmt.close();
              
          }catch(SQLException e){
              e.printStackTrace();
          }finally{
              closeConnection();
          }
          return com;
      }
      
      
           public void obrisiKomentar( int id){
            String query="delete from comments where id=?";
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
        
             
                pstmt.setInt(1, id);
          
                
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
           
                   
                    public void urediKomentar( Comments c){
            String query="Update comments set comment=? where id=?";
            try{
                con=getConnection();
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, c.getComment());
                pstmt.setInt(2, c.getId());
                
                pstmt.execute();
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                closeConnection();
            }
        }
    
      
}
