package org.example.models;

public class Departments {
    private int id;
    private String departmentname;
    private String description;

    private int employeeCount;
    private String createdAt;
    private String updatedAt;

    public Departments(String name, String description) {
        this.departmentname = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public String getDescription() {
        return description;
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

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}
