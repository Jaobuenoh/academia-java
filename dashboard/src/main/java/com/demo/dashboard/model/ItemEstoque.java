package com.demo.dashboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_estoque")
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item_estoque;
    private String lote_item_estoque;
    private String quantidade_item_estoque;
    private String data_entrada_item_estoque;
    private String validade_item_estoque;

    @ManyToOne
    @JoinColumn(name = "tipo_item_estoque", referencedColumnName = "id_tipo_item_estoque", nullable = true)
    private TipoItemEstoque tipoItemEstoque;

    public ItemEstoque(String lote_item_estoque, String quantidade_item_estoque, String data_entrada_item_estoque, String validade_item_estoque) {
        this.lote_item_estoque = lote_item_estoque;
        this.quantidade_item_estoque = quantidade_item_estoque;
        this.data_entrada_item_estoque = data_entrada_item_estoque;
        this.validade_item_estoque = validade_item_estoque;
    }
}