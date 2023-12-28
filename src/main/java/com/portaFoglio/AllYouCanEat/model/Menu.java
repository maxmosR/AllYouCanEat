package com.portaFoglio.AllYouCanEat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "menu_id")
    Integer menuId;

    @Column(name = "category")
    String category;

    //@JoinColumn(name = "resturant_id")
    //Resturant resturant;

}
