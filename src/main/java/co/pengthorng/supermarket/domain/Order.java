package co.pengthorng.supermarket.domain;

import co.pengthorng.supermarket.domain.emun.OrderStatus;
import co.pengthorng.supermarket.domain.emun.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private Double taxAmount;

    @Column
    private String shippingAddress;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;  // PAID, UNPAID, PENDING

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;  // PENDING, SHIPPED, DELIVERED, CANCELLED

    private LocalDateTime orderDate;

    private LocalDateTime shippingDate;

    private LocalDateTime deliveryDate;

}
