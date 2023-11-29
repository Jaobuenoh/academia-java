package com.demo.dashboard.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_item_estoque")
public class TipoItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_item_estoque;
    private String descricao_tipo_item_estoque;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoItemEstoque")
    private List<ItemEstoque> itemEstoques;

    public TipoItemEstoque(String descricao_tipo_item_estoque) {
        this.descricao_tipo_item_estoque = descricao_tipo_item_estoque;
    }
}
