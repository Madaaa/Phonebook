<%-- 
    Document   : editare1
    Created on : Nov 19, 2013, 4:07:34 PM
    Author     : Madalina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda de telefon</title>
    </head>
    <body>
           <h1>Agenda de telefon</h1>
           <form method ="GET" action ="agenda">
            <p>Nume curent/Nume modificat</p><input type ="text" name ="nume"> / <input type ="text" name ="mnume">
            <p>Prenume curent/Prenume modificat</p><input type ="text" name ="prenume"> / <input type ="text" name ="mprenume">
            <p>Telefon mobil curent/Telefon mobil modificat</p><input type ="text" name="telefonmobil"> / <input type ="text" name ="mtelefonmobil">
            <p>Telefon fix curent/Telefon fix modifcat</p><input type ="text" name ="telefonfix"> / <input type ="text" name ="mtelefonfix">
            <p>Email curent/Email modificat</p><input type ="text" name ="email"> / <input type ="text" name ="memail">
            
            <p>Adresa curenta/Adresa modificata</p><input type ="text" name="adresa"> / <input type ="text" name ="madresa">
            <p>Oras curent/Oras modificat</p><input type ="text" name ="oras"> / <input type ="text" name ="moras">
            <p>Judet curent/Judet modificat</p><input type ="text" name ="judet"> / <input type ="text" name ="mjudet">
            <p>Cod Postal curent/Cod postal modificat</p><input type ="text" name ="codpostal"> / <input type ="text" name ="mcodpostal">
            <br>
            <p><i>Nu ati completat niciun camp al valorilor curente</i></p>
            <br>
            <input type ="submit" name ="Buton" value ="Modifica">
            <input type ="submit" name ="Buton"  value ="Inapoi">
    </body>
    </body>
</html>
