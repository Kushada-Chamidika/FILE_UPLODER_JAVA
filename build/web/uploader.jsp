<%-- 
    Document   : uploader
    Created on : Feb 3, 2021, 8:27:39 AM
    Author     : 1999k
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
        <div align="center">           
            <h1>File Upload Test!</h1>
            <form method="POST" action="register" enctype="multipart/form-data">
                <span>Name :</span>
                <input type="text" name="name" placeholder="Enter Your Name"/>
                <br/>
                <br/>
                <span>Message :</span>
                <input type="text" name="msg" placeholder="Enter Your Name"/>
                <br/>
                <br/>
                <span>File :</span>
                <input type="file" name="fileDa"/>
                <br/>
                <br/>
                <input type="submit" name="button" value="Submit"/>
            </form>
        </div>
    </body>
</html>
