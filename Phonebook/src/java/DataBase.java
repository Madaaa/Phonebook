import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    Statement stmt;

    DataBase(Statement s) {
        stmt = s;
    }

    public Vector cauta() throws Exception {
        Vector v = new Vector();
        Contact c = null;
        int i = 0;
        String my_query = "SELECT * FROM CONTACTE";
        ResultSet rs = stmt.executeQuery(my_query);
        while (rs.next()) {
            c = new Contact(rs.getString("nume"),
                    rs.getString("prenume"),
                    rs.getString("telefonmobil"),
                    rs.getString("telefonfix"),
                    rs.getString("email"),
                    rs.getString("adresa"),
                    rs.getString("oras"),
                    rs.getString("judet"),
                    rs.getString("codpostal"));
            v.addElement(c);
        }
        return v;
    }

    public void adauga(Contact c) throws Exception {
        String my_stmt = "INSERT INTO CONTACTE (NUME,PRENUME,TELEFONMOBIL,TELEFONFIX,EMAIL,ADRESA,ORAS,JUDET,CODPOSTAL)"
                + "VALUES('" + c.rNume() + "','"
                + c.rPrenume() + "','"
                + c.rTelefonmobil() + "','"
                + c.rTelefonfix() + "','"
                + c.rEmail() + "','"
                + c.rAdresa() + "','"
                + c.rOras() + "','"
                + c.rJudet() + "','"
                + c.rCodpostal() + "');";

        int i = stmt.executeUpdate(my_stmt);
    }

    public int sterge(String camp, String valoare) throws Exception {
        Vector v = new Vector();

        v = cauta_persoana(camp, valoare);
        if (v.size() > 0) {
            String my_stmt = "DELETE FROM CONTACTE WHERE( " + camp + " = " + "'" + valoare + "');";
            int i = stmt.executeUpdate(my_stmt);
            return 1;
        }
        return 0;
    }

    public Vector cauta_persoana(String camp, String valoare) throws Exception {
        Vector v = new Vector();
        Contact c = null;
        String my_query = "SELECT * FROM CONTACTE WHERE( " + camp + " = " + "'" + valoare + "');";
        ResultSet rs = stmt.executeQuery(my_query);
        while (rs.next()) {
            c = new Contact(rs.getString("nume"),
                    rs.getString("prenume"),
                    rs.getString("telefonmobil"),
                    rs.getString("telefonfix"),
                    rs.getString("email"),
                    rs.getString("adresa"),
                    rs.getString("oras"),
                    rs.getString("judet"),
                    rs.getString("codpostal"));
            v.addElement(c);
        }
        return v;
    }


    public int editeaza(String camp, String valoare, String modificare) {
        Vector v = new Vector();
        try {
            v = cauta_persoana(camp, valoare);
        } catch (Exception ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (v.size() > 0) {
            String my_stmt = "UPDATE CONTACTE SET " + camp + " = " + "'" + modificare + "' WHERE( " + camp + " = " + "'" + valoare + "');";
            try {
                int i = stmt.executeUpdate(my_stmt);
            } catch (SQLException ex) {
                System.out.println("Nu a fost gasita persoana de contact in agenda");
            }
            return 1;
        }
        return 0;
    }


}
