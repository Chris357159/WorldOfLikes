package com.projetspring.WorldsOfLikes.beans;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String content;
    private int likeCount;
    private int shareCount;

    public Post() {
    }

    public Post(String date, String content, short likeCount, short shareCount) {
        this.date = date;
        this.content = content;
        this.likeCount = likeCount;
        this.shareCount = shareCount;
    }

    public void setLikeCount(short likeCount) {
        this.likeCount = likeCount;
    }

    public void setShareCount(short shareCount) {
        this.shareCount = shareCount;
    }

    public Post(String date, String content, int likeCount, int shareCount) {
        this.date = date;
        this.content = content;
        this.likeCount = (short) likeCount;
        this.shareCount = (short) shareCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", likeCount=" + likeCount +
                ", shareCount=" + shareCount +
                '}';
    }
}

