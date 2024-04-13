package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> posts;


    public FBFeed() {
        this.posts = new ArrayList<FBPost>();
    }

    public FBFeed(List<FBPost> posts) {
        this.posts = posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public FBFeed(FBFeed f){
        this.posts = f.getPosts();
    }

    public List<FBPost> getPosts() {
        return this.posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    public void setPosts(List<FBPost> posts) {
        this.posts = posts.stream().map(FBPost::clone).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FBFeed)) {
            return false;
        }
        FBFeed fBFeed = (FBFeed) o;
        return Objects.equals(posts, fBFeed.posts);
    }

    @Override
    public String toString() {
        return "{" +
            " posts='" + getPosts() + "'" +
            "}";
    }

    public FBFeed clone(){
        return new FBFeed(this);
    }

    public int nrPosts(String user){
        return (int) this.getPosts().stream().filter(f -> f.getUser().equals(user)).count();
    }

    public List<FBPost> postsOf(String user){
        return this.getPosts().stream().filter(f -> f.getUser().equals(user)).collect(Collectors.toList());
    }

    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        return this.getPosts().stream().filter(f -> f.getUser().equals(user))
                                       .filter(f -> f.getTimeI().isAfter(inicio))
                                       .filter(f -> f.getTimeF().isBefore(fim)).collect(Collectors.toList());
    }
    
    public FBPost getPost(int id){
        Optional<FBPost> post = this.getPosts().stream().filter(f -> f.getId() == id).findFirst();

        return post.orElse(null);
    }

    public void comment (FBPost post, String comentario){
        // fiquei aqui
    }
}
