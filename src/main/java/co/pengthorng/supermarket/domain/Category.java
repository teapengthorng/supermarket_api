package co.pengthorng.supermarket.domain;

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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdatedDate;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
