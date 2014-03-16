

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/edit"})
public class edit extends HttpServlet {
   
    PrintWriter out;
   int ok = 0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       out = response.getWriter();
         
       out.println("<html><head><title>Agenda telefonica </title></head>");
       out.println("<body>" + "<form method=GET " + "action=agenda>");
       
       BD bd=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
            Statement stmt = con.createStatement();
            bd = new BD(stmt);
            
            }
            catch (SQLException e) { System.out.println(e); }
            catch (ClassNotFoundException e) { }
        
         String s = request.getQueryString(); 
         s = request.getParameter("Buton");

        
         
         String nume = request.getParameter("nume");
         String mnume = request.getParameter("mnume");
         String prenume = request.getParameter("prenume");
         String mprenume = request.getParameter("mprenume");
         String telefonmobil = request.getParameter("telefonmobil");
         String mtelefonmobil = request.getParameter("mtelefonmobil");
         String telefonfix = request.getParameter("telefonfix");
         String mtelefonfix = request.getParameter("mtelefonfix");
         String email = request.getParameter("email");
         String memail = request.getParameter("memail");
         String adresa = request.getParameter("adresa");
         String madresa = request.getParameter("madresa");
         String oras = request.getParameter("oras");
         String moras = request.getParameter("moras");
         String judet = request.getParameter("judet");
         String mjudet = request.getParameter("mjudet");
         String codpostal = request.getParameter("codpostal");
         String mcodpostal = request.getParameter("mcodpostal");
         
         if(nume.length()>0) {
             if(bd.editeaza("nume",nume,mnume)==1)
                 ok = 1;
             else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
         }
          if(prenume.length()>0){
              if(bd.editeaza("prenume",prenume,mprenume)==1)
                  ok = 1;
              else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
          } 
             
              
         if(telefonmobil.length()>0) {
            if( bd.editeaza("telefonmobil",telefonmobil,mtelefonmobil)==1)
               ok = 1;
            else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
         }
               
          if(telefonfix.length()>0){
             if( bd.editeaza("telefonfix",telefonfix,mtelefonfix)==1)
                 ok = 1;
             else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
          } 
                
          if(email.length()>0){
              if(bd.editeaza("email",email,memail)==1)
                  ok = 1;
              else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
           
          } 
               
          if(adresa.length()>0) {
              if(bd.editeaza("adresa",adresa,madresa)==1)
                  ok = 1;
              else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
          }
                 
          if(oras.length()>0) {
             if(bd.editeaza("oras",oras,moras)==1)
                 ok = 1;
             else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
         }
               
          if(judet.length()>0) {
             if(bd.editeaza("judet",judet,mjudet)==1)
                 ok = 1;
             else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
         }
                
         if(codpostal.length()>0) {           
             if( bd.editeaza("codpostal",codpostal,mcodpostal)==1)
               ok = 1;
            else  out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = 'Back'>");
             
        }
              
         if( nume.equals("") &&prenume.equals("")&&telefonmobil.equals("") &&telefonfix.equals("") &&email.equals("") &&adresa.equals("")&&oras.equals("")&&judet.equals("")&&codpostal.equals("") ) 
                response.sendRedirect("editare1.jsp");
          if( ok == 1)try {
             afisare(bd);
            } catch (Exception ex) {
            Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        out.println("</form></body></html>"); 
     
    }
  public void afisare(BD bd) throws Exception {
    String html = "<h3>Agenda telefon</h3>";
  
    html+="<table border='1' cellpadding ='10'><tr><th> Nume</th><th>Prenume</th><th><Telefon mobil</th><th>Telefon fix</th><th>Email</th><th>Adresa</th><th>Oras</th><th>Judet</th><th>Cod postal</th></tr>";

    Vector v = bd.cauta();
    for (int i=0; i<v.size(); i++) {
       contact c = (contact) v.elementAt(i); 
      html+="<tr><td>" + c.rNume() + "</td><td> " + c.rPrenume() + "</td>";
      html+="<td>" + c.rTelefonmobil() + "</td><td>" + " " + c.rTelefonfix() + "</td>";
      html+="<td>" + c.rEmail() + "</td><td>" + " " + c.rAdresa() + "</td>";
      html+="<td>" + c.rOras() + "</td><td>" +" " + c.rJudet() + "</td>";
      html+="<td>" + c.rCodpostal() + "</td></tr>"; 
    }

    html+="</table><br><input type = 'submit' name = 'Buton' value = 'Inapoi'>";
    out.println(html);
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
