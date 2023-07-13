package com.example.loja.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;

    private String password;

    private String fistName;

    private String lastName;

    @OneToMany(mappedBy = "account")
    private List<ItemEstoque> itemEstoques;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_authority",
      joinColumns = {@JoinColumn (name = "account_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})

    private Set<Authority> authorities = new HashSet<>();



}
