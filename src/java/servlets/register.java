package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
//        String name = request.getParameter("name");
//        String file = request.getParameter("fileDa");
//        
//        response.getWriter().write("name->"+name);
//        response.getWriter().write("file->"+file);
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
//            response.getWriter().write("res->Multipart Found!" + "<br/>" + "<br/>");
            String realPath = getServletContext().getRealPath("/images/");

//            response.getWriter().write("Real Path ->" + realPath + "<br/>" + "<br/>");
            try {
                List<FileItem> list = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (int i = 0; i < list.size(); i++) {
                    FileItem item = list.get(i);
//                    response.getWriter().write("Feild Name :" + item.getFieldName() + " / " + "Name :" + item.getName() + "<br/>" + "<br/>");
                    if (item.isFormField()) {
//                        response.getWriter().write(item.getFieldName() + "- is A form Feild" + "<br/>" + "<br/>");

                        if (item.getFieldName().equals("name")) {
                            String itemValue = item.getString();
//                            response.getWriter().write("Item Value ->" + itemValue + "<br/>" + "<br/>");
                        } else if (item.getFieldName().equals("msg")) {
                            String itemValue = item.getString();
//                            response.getWriter().write("Item Value ->" + itemValue + "<br/>" + "<br/>");
                        }

                        String itemValue = item.getString();

                        switch (item.getFieldName()) {
                            case "name":
//                                response.getWriter().write("Item Value ->" + itemValue + "<br/>" + "<br/>");
                                break;
                            case "msg":
//                                response.getWriter().write("Item Value ->" + itemValue + "<br/>" + "<br/>");
                                break;
                        }

                    } else {
//                        response.getWriter().write(item.getFieldName() + "- is not A form Feild" + "<br/>" + "<br/>");

                        try {
                            if (item.getFieldName().equals("fileDa")) {
                                if(item.getContentType().startsWith("image")){
                                response.getWriter().write("This is an IMage");
                                }
                                else{
                                response.getWriter().write("This is not an IMage");
                                }
                                if (item.getContentType().equals("application/pdf")) {
                                    item.write(new File(realPath + item.getName()));
                                    response.getWriter().write("<a href='images/" + item.getName() + "'>" + item.getContentType() + " / " + item.getName() + "</a><br/><br/>");
                                } else if (item.getContentType().equals("image/png")) {
                                    item.write(new File(realPath + item.getName()));
                                    response.getWriter().write("<a href='images/" + item.getName() + "'>" + item.getContentType() + " / " + item.getName() + "</a><br/><br/>");
                                } else if (item.getContentType().equals("image/jpeg")) {
                                    item.write(new File(realPath + item.getName()));
                                    response.getWriter().write("<a href='images/" + item.getName() + "'>" + item.getContentType() + " / " + item.getName() + "</a><br/><br/>");
                                } else if (item.getContentType().equals("image/jpg")) {
                                    item.write(new File(realPath + item.getName()));
                                    response.getWriter().write("<a href='images/" + item.getName() + "'>" + item.getContentType() + " / " + item.getName() + "</a><br/><br/>");
                                }
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
//                response.getWriter().write("File Upload Successfully!" + "<br/>" + "<br/>");
            } catch (FileUploadException ex) {
                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
//            response.getWriter().write("res->Multipart Not Found!" + "<br/>" + "<br/>");
            String name = request.getParameter("name");
            String file = request.getParameter("fileDa");

//            response.getWriter().write("name->" + name + "<br/>" + "<br/>");
//            response.getWriter().write("file->" + file);
        }

    }

}
