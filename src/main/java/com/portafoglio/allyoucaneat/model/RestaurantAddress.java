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
@Table(name = "resturant_address")
public class RestaurantAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_address_id")
    private Long addressId;

    @Column(name ="city")
    private String city;

    @Column(name ="zip_code")
    private String zip_code;

    @Column(name ="address")
    private String address;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}

