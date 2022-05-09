package com.restaurantapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(generator="rest_gen", strategy = GenerationType.AUTO)
    @SequenceGenerator(name="rest_gen", sequenceName = "rest_seq", initialValue = 1,allocationSize = 1)
    private Integer restaurantId;
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String city;
    @Enumerated(EnumType.STRING)
    private Type type;
    private double rating;




    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
// this column will be added to item table refers to foreign key hotelid
    @JoinColumn(name= "restaurantId")
    private Set<Item> items;

    public Restaurant(String name, String city, Type type, double rating, Set<Item> itemsList) {
        this.name = name;
        this.city = city;
        this.type = type;
        this.rating = rating;
        this.items = itemsList;
    }
}
