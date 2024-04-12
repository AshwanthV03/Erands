package com.erands.erands.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String storeName;
    private String address;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private Seller seller;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name ="Store_products",
            joinColumns = @JoinColumn(name = "store_product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> products = new ArrayList<Products>();

}
