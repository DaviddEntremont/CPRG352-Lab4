package models;

import java.io.Serializable;

public class Note implements Serializable {
    private String title;
    private String contents;
    
    public Note () {
        title = "";
        contents = "";
    }
    
    public Note(String newTitle, String newContents) {
        this.title = newTitle;
        this.contents = newContents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    
}