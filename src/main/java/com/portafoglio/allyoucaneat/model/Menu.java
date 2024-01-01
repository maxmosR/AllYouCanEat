package com.portafoglio.allyoucaneat.model;

import jakarta.persistence.*;
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
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "category")
    private String category;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "resturant_id")
    private Restaurant resturant;

}
