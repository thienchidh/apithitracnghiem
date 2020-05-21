package com.thienchidh.apithitracnghiem.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonProperty("pass")
    private String password;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;
}
