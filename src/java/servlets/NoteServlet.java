package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    //used to display form in view or edit mode
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader (new FileReader(new File(path)));
        
        String noteTitle = br.readLine();
        
        String noteContents = br.readLine();
        
        Note newNote = new Note(noteTitle, noteContents);
        
        request.setAttribute("note", newNote);
        
        br.close();
        
        String edit = null;
        
        edit = request.getQueryString();
        
        if (edit == null) {
        
             
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        return;
        
        }
        
        if (edit != null) {
            
             getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
             
             return;
        }
        
        
       
    }
    
    //save the form from the edit mode
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String noteTitle = request.getParameter("title");
        
        String noteContents = request.getParameter("contents");
        
        Note newNote = new Note(noteTitle, noteContents);
        
        request.setAttribute("note", newNote);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        pw.println(noteTitle);
        
        pw.println(noteContents);
        
        pw.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
        return;
    }

}
