package com.example.MR.Barda.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;
    @Column(nullable = false, length = 60, unique = true)
    private String userName;
    @Column(nullable = false, length = 60, unique = true)
    private String email;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false)
    private Date dateCreation;
    @Column(nullable = false)
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="id_user", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name="id_role", referencedColumnName = "idRole"))
    private List<Rols> roles;
}
