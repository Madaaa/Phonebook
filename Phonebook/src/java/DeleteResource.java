import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/delete"})
public class DeleteResource extends HttpServlet {

    PrintWriter out;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();

        out.println("<html><head><title>Agenda telefonica </title></head>");
        out.println("<body>" + "<form method=GET " + "action=agenda>");

        DataBase bd = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "");
            Statement stmt = con.createStatement();
            bd = new DataBase(stmt);

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {}

        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String telefonmobil = request.getParameter("telefonmobil");
        String telefonfix = request.getParameter("telefonfix");
        String email = request.getParameter("email");
        String adresa = request.getParameter("adresa");
        String oras = request.getParameter("oras");
        String judet = request.getParameter("judet");
        String codpostal = request.getParameter("codpostal");

        if (nume.length() > 0)
            try {
                if (bd.sterge("nume", nume) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");


            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (prenume.length() > 0)
            try {
                if (bd.sterge("prenume", prenume) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");


            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (telefonmobil.length() > 0)
            try {
                if (bd.sterge("telefonmobil", telefonmobil) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");

            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (telefonfix.length() > 0)
            try {
                if (bd.sterge("telefonfix", telefonfix) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");

            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (email.length() > 0)
            try {
                if (bd.sterge("email", email) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");

            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (adresa.length() > 0)
            try {
                if (bd.sterge("adresa", adresa) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");

            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (oras.length() > 0)
            try {
                if (bd.sterge("oras", oras) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</p><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");

            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (judet.length() > 0)
            try {
                if (bd.sterge("judet", judet) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");

            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else if (codpostal.length() > 0)
            try {
                if (bd.sterge("codpostal", codpostal) == 1)
                    afisare(bd);
                else
                    out.println("<h3>Agenda de telefon</h3><p>Nu a fost gasit niciun contact cu informatiile introduse</p><br><input type = 'submit' name = 'Buton' value = Inapoi>");

            } catch (Exception ex) {
                System.out.println("Nu s-a putut efectua stergerea");
            }
        else response.sendRedirect("delete1.jsp");


        out.println("</form></body></html>");

    }

    public void afisare(DataBase bd) throws Exception {
        String html = "<h3>Agenda telefon</h3>";

        html += "<table border='1' cellpadding ='10'><tr><th> Nume</th><th>Prenume</th><th><Telefon mobil</th><th>Telefon fix</th><th>Email</th><th>Adresa</th><th>Oras</th><th>Judet</th><th>Cod postal</th></tr>";

        Vector v = bd.cauta();
        for (int i = 0; i < v.size(); i++) {
            Contact c = (Contact) v.elementAt(i);
            html += "<tr><td>" + c.rNume() + "</td><td> " + c.rPrenume() + "</td>";
            html += "<td>" + c.rTelefonmobil() + "</td><td>" + " " + c.rTelefonfix() + "</td>";
            html += "<td>" + c.rEmail() + "</td><td>" + " " + c.rAdresa() + "</td>";
            html += "<td>" + c.rOras() + "</td><td>" + " " + c.rJudet() + "</td>";
            html += "<td>" + c.rCodpostal() + "</td></tr>";
        }

        html += "</table>";
        html += "<br><input type = 'submit' name = 'Buton' value = 'Inapoi'>";
        out.println(html);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
    }

}
