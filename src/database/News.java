package database;


import java.time.LocalDateTime;

public class News {
    private int id;
    private String title;
    private String content;

    private NewsCategories newsCategories;

    private LocalDateTime postDate;

    public News() {}

    public News(int id, String title, String content, NewsCategories newsCategories, LocalDateTime postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.newsCategories = newsCategories;
        this.postDate = postDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }
}
