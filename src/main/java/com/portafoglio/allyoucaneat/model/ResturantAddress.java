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
public class ResturantAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name ="city")
    private String city;

    @Column(name ="zip_code")
    private String zip_code;

    @Column(name ="address")
    private String address;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resturant_id")
    private Restaurant restaurant;
}

