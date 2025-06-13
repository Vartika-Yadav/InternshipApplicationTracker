package com.kiet.InternshipApplicationTrack;

import jakarta.persistence.*;

@Entity
public class InternshipApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String studentName;
    private String company;
    private String role;
    private String status; // e.g., pending, approved

    public InternshipApplication() {
    }

    public InternshipApplication(Integer id, String studentName, String company, String role, String status) {
        this.id = id;
        this.studentName = studentName;
        this.company = company;
        this.role = role;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
