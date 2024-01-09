package com.portafoglio.allyoucaneat.model;

import jakarta.persistence.*;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "category")
    private String category;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "resturant_id")
    private Restaurant resturant;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Item> items; //anche altre data structures si possono usare qui oltre a list

}
