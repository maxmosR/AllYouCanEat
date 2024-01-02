package com.portafoglio.allyoucaneat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_items_id")
    private Long cartItemsId;

    @Column(name = "quantity")
    private Integer quantity;

    @DecimalMin("0.00")
    @Digits(integer = 5, fraction = 2)
    @Column(name = "sub_total")
    private BigDecimal subTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
