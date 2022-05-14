package org.example.models;

public class Users {
    private int id;
    private String username;
    private String fullName;

    private int departmentId;
    private String email;
    private String phone;
    private String roles;
    private String position;
    private String address;
    private String createdAt;
    private String updatedAt;

    public Users(String username, String fullName, int departmentId,
                 String email, String phone, String roles, String position, String address) {

        this.username = username;
        this.fullName = fullName;
        this.departmentId = departmentId;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
        this.position = position;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRoles() {
        return roles;
    }

    public String getPosition() {
        return position;
    }

    public String getAddress() {
        return address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }


}
