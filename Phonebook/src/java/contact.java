/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madalina
 */
public class contact {
    private String nume, prenume, telefonfix, telefonmobil, email, adresa, oras, judet, codpostal;
    
    public contact(String n,String p,String tf,String tm, String e, String a,String o, String j, String c){
        nume = n;
        prenume = p;
        telefonmobil = tm;
        telefonfix =tf;
        email = e;
        adresa = a;
        oras = o;
        judet = j;
        codpostal = c;
        }
    
    public String rNume() {return nume;}
    public String rPrenume() {return prenume;}
    public String rTelefonfix() { return telefonfix;}
    public String rTelefonmobil() { return telefonmobil;}
    public String rEmail() { return email;}
    public String rAdresa() { return adresa;}
    public String rOras() { return oras;}
    public String rJudet() { return judet;}
    public String rCodpostal() { return codpostal;}
    
    public String toString() { 
        return nume + " " + prenume + " " + telefonfix + " " + " " + telefonmobil + " " + email + " " + adresa + " " + oras + " " + judet + " " + codpostal;
        }
    
    
}
