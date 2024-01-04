package com.basitdev.ems.models;

public class Department {

    private String departmentId;
    private String name;
    private String branch;
    private Position position;

    public Department() {
    }

    public Department(String departmentId, String name, String branch, Position position) {
        this.departmentId = departmentId;
        this.name = name;
        this.branch = branch;
        this.position = position;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
