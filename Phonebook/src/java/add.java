/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/add"})
public class add extends HttpServlet {
   
    PrintWriter out;
  
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

        
         
         String nume = request.getParameter("nume");
         String prenume = request.getParameter("prenume");
         String telefonmobil = request.getParameter("telefonmobil");
         String telefonfix = request.getParameter("telefonfix");
         String email = request.getParameter("email");
         String adresa = request.getParameter("adresa");
         String oras = request.getParameter("oras");
         String judet = request.getParameter("judet");
         String codpostal = request.getParameter("codpostal");
         if( telefonfix.equals("")) telefonfix = "-";
         if( adresa.equals("")) adresa = "  -";
         if( oras.equals("")) oras = "  -";
         if( judet.equals("")) judet = "  -";
         if( codpostal.equals("")) codpostal = "-";
         contact c = new contact(nume,prenume,telefonmobil,telefonfix,email,adresa,oras,judet,codpostal);
         if( nume.equals("") || prenume.equals("") || telefonmobil.equals("") || email.equals(""))
             response.sendRedirect("alert.jsp");
        else{
            try {

                 bd.adauga(c);
                } catch (Exception ex) {
                    System.out.println("Eroare la adaugare");
                    }
           try {
                 afisare(bd);
                } catch (Exception ex) {
                     System.out.println("Eroare la afisare");
                    }
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
