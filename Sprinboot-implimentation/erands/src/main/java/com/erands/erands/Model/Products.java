package com.erands.erands.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Products {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String title;
    private String Description;
    private float price;
    private String image;
    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Store> stores = new ArrayList<>();

}
