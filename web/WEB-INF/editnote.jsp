<%-- 
    Document   : editnote.jsp
    Created on : 10-Oct-2021, 2:11:41 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note - Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="POST" action="note">
            <label>Title:</label>
            <input type="text" name="title" value="${note.title}">
            <br>
            <label>Contents:</label>
            <textarea name="contents">${note.contents}</textarea>
            <br><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
