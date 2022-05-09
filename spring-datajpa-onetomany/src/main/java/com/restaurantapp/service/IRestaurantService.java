package com.restaurantapp.service;


import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;

import java.util.List;

public interface IRestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);
    void updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(int restaurantId);

    Restaurant getByRestaurantId(int restaurantId);
    List<Restaurant> getByCity(String city);
    List<Restaurant> getByType(Type type);
    List<Restaurant> getByRating(double city);

    List<Restaurant>getByItemNameString(String itemName);
   List<Restaurant>getByItemNameCategory(String itemName, Category Category);
  List<Restaurant>getByCuisine(String cusine);
  List<Restaurant>getByCategory(String category);
    List<Restaurant>getByCuisineAndType(String cuisine,String type);
    List<Restaurant> getByItemNameLessPrice(String itemName, double price);
}
