import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/agenda"})
public class AgendaResource extends HttpServlet {

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
        } catch (ClassNotFoundException e) {
        }

        String s = request.getQueryString();
        s = request.getParameter("Buton");

        if (s.equals("Adauga")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/add");
            rd.forward(request, response);
        } else if (s.equals("Editeaza")) {
            response.sendRedirect("editare.jsp");
        } else if (s.equals("Modifica")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit");
            rd.forward(request, response);
        } else if (s.equals("Cauta")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/search");
            rd.forward(request, response);
        } else if (s.equals("Sterge")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/delete");
            rd.forward(request, response);
        } else if (s.equals("Inapoi")) {
            response.sendRedirect("index.jsp");
        } else if (s.equals("Back")) {
            response.sendRedirect("editare.jsp");
        }
        out.println("</form></body></html>");

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
