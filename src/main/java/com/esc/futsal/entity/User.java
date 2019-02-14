package com.esc.futsal.entity;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;



    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;


    @Column(name = "lastname")
    private String lastName;


    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;



    @Column(name = "phone_no")
    private String phoneNo;


    @Column(name = "username")
    private String username;



    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList;



    @Transient
    private MultipartFile userImage;

    @Column(name ="imagepath")
    private String imagePath;



    @Column(name = "status")
    private Boolean status;


    public User() {
    }

    public User( String firstName,  String lastName, String address, String email, String phoneNo,String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }



    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public MultipartFile getUserImage() {
        return userImage;
    }
    public void setUserImage(MultipartFile userImage) {
        this.userImage = userImage;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }



}

