package com.example.loja.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fornecedor;
    private String nome_fornecedor;
    private String endereco_fornecedor;
    private String contato_fornecedor;

    @ManyToMany(mappedBy = "fornecedores")
    List<ItemEstoque> itensEstoque;


    public Fornecedor(String nome_fornecedor, String endereco_fornecedor, String contato_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
        this.endereco_fornecedor = endereco_fornecedor;
        this.contato_fornecedor = contato_fornecedor;
    }
}
