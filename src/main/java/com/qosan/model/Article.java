package com.qosan.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Article {

    private String id;
    private LocalDateTime creationDate;
    private String signature;
    private LocalDateTime modifyDate;
    private Status status;
    private List<String> imagesIds;
    private String title;
    private String content;

    private Article() {
    }

    private Article(String id, LocalDateTime creationDate, String signature, LocalDateTime modifyDate, Status status, List<String> imagesIds, String title, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.signature = signature;
        this.modifyDate = modifyDate;
        this.status = status;
        this.imagesIds = imagesIds;
        this.title = title;
        this.content = content;
    }

    public Article createArticle(String id, LocalDateTime creationDate, String signature, LocalDateTime modifyDate, Status status, List<String> imagesIds, String title, String content) {

        return new Article(id,creationDate,signature,modifyDate,status,imagesIds,title,content);
    }

    public Article updateArticle(Article article, LocalDateTime modifyDate) {
        return new Article(article.getId(),article.getCreationDate(), article.getSignature(), modifyDate
        ,article.getStatus(), article.getImagesIds(), article.getTitle(), article.getContent());
    }

    public Article changeStatus(Article article, Status status) {
        return new Article(article.getId(),article.getCreationDate(), article.getSignature(), article.getModifyDate()
                ,status, article.getImagesIds(), article.getTitle(), article.getContent());
    }


        public String getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getSignature() {
        return signature;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public com.qosan.model.Status getStatus() {
        return status;
    }

    public List<String> getImagesIds() {
        return imagesIds;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(creationDate, article.creationDate) && Objects.equals(signature, article.signature) && Objects.equals(modifyDate, article.modifyDate) && status == article.status && Objects.equals(imagesIds, article.imagesIds) && Objects.equals(title, article.title) && Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, signature, modifyDate, status, imagesIds, title, content);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", signature='" + signature + '\'' +
                ", modifyDate=" + modifyDate +
                ", status=" + status +
                ", imagesIds=" + imagesIds +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
