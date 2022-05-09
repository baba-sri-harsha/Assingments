package com.restaurantapp.repository;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestaurentRepository extends JpaRepository<Restaurant,Integer> {

    Restaurant findByRestaurantId(int restaurantId);
    List<Restaurant> findByCity(String city);
    List<Restaurant> findByType(Type type);
    List<Restaurant> findByRating(double rating);

    @Query("from Restaurant r inner join r.items  i where i.itemName like %?1%")
    List<Restaurant>findByItemNameString(String itemName);

    @Query("from Restaurant r inner join r.items i where i.itemName=?1 and i.category=?2")
    List<Restaurant>findByItemNameCategory(String itemName, Category Category);

    @Query("from Restaurant r inner join r.items i where i.cuisine=?1")
    List<Restaurant>findByCuisine(String Cuisine);

    @Query("from Restaurant r inner join r.items i where i.category=?1")
    List<Restaurant>findByCategory(String category);

    @Query("from Restaurant r inner join r.items i where i.cuisine=?1 and r.type=?2")
    List<Restaurant>findByCuisineAndType(String Cuisine,String type);


    @Query("from Restaurant r inner join r.items i where i.itemName=?1 and i.price<=?2")
    List<Restaurant>findByItemNameLessPrice(String itemName,double price);
}
