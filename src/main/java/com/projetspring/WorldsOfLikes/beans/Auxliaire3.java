package com.projetspring.WorldsOfLikes.beans;

public class Auxliaire3 {
    private String date;
    private String content;
    private int likeCount;
    private int shareCount;

    public Auxliaire3() {
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
        return "Auxliaire3{" +
                "date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", likeCount=" + likeCount +
                ", shareCount=" + shareCount +
                '}';
    }
}
