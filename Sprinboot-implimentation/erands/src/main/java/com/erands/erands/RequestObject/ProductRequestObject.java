package com.erands.erands.RequestObject;

import com.erands.erands.Model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequestObject {

    private Long storeId;
    private String title;
    private String Description;
    private float price;
    private String image;
    private List<Store> stores = new ArrayList<>();
}
