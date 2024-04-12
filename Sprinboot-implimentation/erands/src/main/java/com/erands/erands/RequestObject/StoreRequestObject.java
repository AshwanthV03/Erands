package com.erands.erands.RequestObject;

import com.erands.erands.Model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreRequestObject {
    private Long id;
    private String storeName;
    private String address;
    private Long seller_id;
}
