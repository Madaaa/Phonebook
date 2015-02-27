/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Contact {
    private String nume;
    private String prenume;
    private String telefonfix;
    private String telefonmobil; private String email;
    private String adresa;
    private String oras;
    private String judet;
    private String codpostal;

    public Contact(String n, String p, String tf, String tm, String e, String a, String o, String j, String c) {
        nume = n;
        prenume = p;
        telefonmobil = tm;
        telefonfix = tf;
        email = e;
        adresa = a;
        oras = o;
        judet = j;
        codpostal = c;
    }

    public String rNume() {
        return nume;
    }

    public String rPrenume() {
        return prenume;
    }

    public String rTelefonfix() {
        return telefonfix;
    }

    public String rTelefonmobil() {
        return telefonmobil;
    }

    public String rEmail() {
        return email;
    }

    public String rAdresa() {
        return adresa;
    }

    public String rOras() {
        return oras;
    }

    public String rJudet() {
        return judet;
    }

    public String rCodpostal() {
        return codpostal;
    }

    public String toString() {
        return nume + " " + prenume + " " + telefonfix + " " + " " + telefonmobil + " " + email + " " + adresa + " " + oras + " " + judet + " " + codpostal;
    }


}
