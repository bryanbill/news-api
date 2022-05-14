package org.example.models;

public class News {
    private int id;
    private int departmentId;
    private String content;
    private String createdAt;
    private String updatedAt;

    public News(int departmentId, String content) {
        this.departmentId = departmentId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }
}
