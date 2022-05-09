package com.restaurantapp.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Item {
    @Id
    @GeneratedValue(generator="item_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="item_gen", sequenceName = "item_seq", initialValue = 1,allocationSize = 1)
    private Integer itemId;
    @Column(length = 30)
    private String itemName;
    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(length = 30)
    private String cuisine;
    @Enumerated(EnumType.STRING)
    private  Type type;
    double price;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Restaurant restaurant;

    public Item(String itemName, Category category, String cuisine, Type type, double price) {
        this.itemName = itemName;
        this.category = category;
        this.cuisine = cuisine;
        this.type = type;
        this.price = price;
    }
}

