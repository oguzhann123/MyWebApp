package com.mycompany.user;

import jakarta.persistence.*;

// this entity class jpi annotations to indicate that this java class will map with a table in the database,
// so we need to use the entity annotations
@Entity
@Table(name = "users") // mapping table is users and then we declare the fields in this entity class first one is
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
@Column(length = 45, nullable = false, name = "Name")  // column  annotation to specify some additional properties such as
    private  String Name;
@Column(length = 45, nullable = false, name = "Surname")
    private String Surname;
@Column(length = 15, nullable = false)
    private String password;


private boolean enabled;


// this is encapsulated Fields Visibility
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
