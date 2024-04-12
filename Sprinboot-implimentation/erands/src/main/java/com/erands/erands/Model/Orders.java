package com.erands.erands.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    @OneToOne(cascade = CascadeType.ALL)
    private OrderRequestObject productOrdered;
    private LocalDateTime orderDateTime;
    private String orderStatus;
    // Add more fields as needed, e.g., totalAmount, orderStatus, etc.
}

