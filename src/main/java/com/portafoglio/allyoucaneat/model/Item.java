package com.portafoglio.allyoucaneat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(name = "name")
    private String name;

    @DecimalMin("0.00")
    @Digits(integer = 5, fraction = 2)
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "gluten_free", columnDefinition = "boolean default true")
    private boolean glutenFree;

    @Column(name = "vegan", columnDefinition = "boolean default true")
    private boolean vegan;

    @Column(name = "halal", columnDefinition = "boolean default true")
    private boolean halal;

    @Column(name = "availability", columnDefinition = "boolean default true")
    private boolean availability;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

}
