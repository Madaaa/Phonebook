<%-- 
    Document   : alert
    Created on : Nov 18, 2013, 2:34:46 PM
    Author     : Madalina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda telefon</title>
    </head>
    <body>
        <h1>Agenda de telefon</h1>
        <form method ="GET" action ="agenda">
            <p>*Nume</p><input type ="text" name ="nume">
            <p>*Prenume</p><input type ="text" name ="prenume">
            <p>*Telefon mobil</p><input type ="text" name="telefonmobil">
            <p>Telefon fix</p><input type ="text" name ="telefonfix">
            <p>*Email</p><input type ="text" name ="email">
            
            <p>Adresa</p><input type ="text" name="adresa">
            <p>Oras</p><input type ="text" name ="oras">
            <p>Judet</p><input type ="text" name ="judet">
            <p>Cod Postal</p><input type ="text" name ="codpostal">
            <br>
            <p><i>Nu ati completat toate campurile!</i></p>
            <br>
            <input type ="submit" name ="Buton" value ="Adauga">
            <input type ="submit" name ="Buton" value ="Editeaza">
            <input type ="submit" name ="Buton" value ="Cauta">
            <input type ="submit" name ="Buton" value ="Sterge">
           
    </body>
</html>
