package com.example.mvccurd;

import javax.persistence.*;

@Entity
@Table(name="susa")
public class User {
    @Id // To made column primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// To auto-increment
    private Integer id;
    @Column(nullable = false,unique = true,length = 35)
    private String email;
    @Column(nullable = false,length = 15)
    private String password;
    @Column(nullable = false,length = 30)
    private String firstName;
    @Column(nullable = false,length = 30)
    private String lastName;

    public User(Integer id, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
