package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FBPost {
    private int id;
    private String user;
    private LocalDateTime timeI;
    private LocalDateTime timeF;
    private String content;
    private int likes;
    private List<String> comments;

    public FBPost(){
        id = 0;
        user = "";
        timeI = LocalDateTime.now();
        timeF = LocalDateTime.now();
        content = "";
        likes = 0;
        comments = new ArrayList<String>();
    }


    public FBPost(int id, String user, LocalDateTime timeI, LocalDateTime timeF, String content, int likes, List<String> comments) {
        this.id = id;
        this.user = user;
        this.timeI = timeI;
        this.timeF = timeF;
        this.content = content;
        this.likes = likes;
        this.comments = comments;
    }

    public FBPost(FBPost p){
        this.id = p.getId();
        this.user = p.getUser();
        this.timeI = p.getTimeI();
        this.timeF = p.getTimeF();
        this.content = p.getContent();
        this.likes = p.getLikes();
        this.comments = p.getComments();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getTimeI() {
        return this.timeI;
    }

    public void setTimeI(LocalDateTime time) {
        this.timeI = time;
    }

    public LocalDateTime getTimeF() {
        return this.timeF;
    }

    public void setTimeF(LocalDateTime time) {
        this.timeF = time;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return this.comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FBPost)) {
            return false;
        }
        FBPost fBPost = (FBPost) o;
        return id == fBPost.id && Objects.equals(user, fBPost.user) && timeI == fBPost.timeI && Objects.equals(content, fBPost.content) && likes == fBPost.likes && Objects.equals(comments, fBPost.comments);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", timeI='" + getTimeI() + "'" +
            ", timeF='" + getTimeF() + "'" +
            ", content='" + getContent() + "'" +
            ", likes='" + getLikes() + "'" +
            ", comments='" + getComments() + "'" +
            "}";
    }

    public FBPost clone(){
        return new FBPost(this);
    }
    
}
