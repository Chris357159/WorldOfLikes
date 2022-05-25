package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String userPhoto;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Post>posts=new ArrayList<>();
    /*@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Form login;*/
    private int isLoggedIn;



  /*  public Form getLogin() {
        return login;
    }

    public void setLogin(Form login) {
        this.login = login;
    }*/
   public SocialNetwork() {
   }

   public SocialNetwork(String username) {
        this.username = username;
   }

   public List<Post> getPosts() {
      return posts;
   }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public int isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(int loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPost() {
        return posts;
    }

    public void setPost(List<Post> posts) {
        this.posts = posts;
    }
    public void ajouterPost(Post post1){
        posts.add(post1);
    }
    @Override
    public String toString() {
        return "SocialNetwork{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", post=" + posts +
                '}';
    }
}
