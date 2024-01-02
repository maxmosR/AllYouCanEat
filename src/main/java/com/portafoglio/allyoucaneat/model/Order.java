package com.portafoglio.allyoucaneat.model;

import com.portafoglio.allyoucaneat.model.enums.Estatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Estatus status;

    @Column(name = "note")
    private String note;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @OneToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "order_address_id", nullable = false, referencedColumnName = "order_address_id")
    private OrderAddress orderAddress;
}
