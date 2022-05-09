package com.restaurantapp.service;

import com.restaurantapp.model.Category;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;
import com.restaurantapp.repository.IRestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRestaurantServiceImpl implements IRestaurantService {


    private IRestaurentRepository restaurentRepository;

    @Autowired
    public void setRestaurntRepository(IRestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
          return restaurentRepository.save(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
         restaurentRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        restaurentRepository.deleteById(restaurantId);
    }

    @Override
    public Restaurant getByRestaurantId(int restaurantId) {
        return restaurentRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public List<Restaurant> getByCity(String city) {
        return restaurentRepository.findByCity(city);
    }

    @Override
    public List<Restaurant> getByType(Type type) {
        return restaurentRepository.findByType(type);
    }

    @Override
    public List<Restaurant> getByRating(double rating) {
        return restaurentRepository.findByRating(rating);
    }

    @Override
    public List<Restaurant> getByItemNameString(String itemName) {
        return restaurentRepository.findByItemNameString(itemName);
    }

    @Override
    public List<Restaurant> getByItemNameCategory(String itemName, Category Category) {
        return restaurentRepository.findByItemNameCategory(itemName, Category);
    }

    @Override
    public List<Restaurant> getByCuisine(String cusine) {
        return restaurentRepository.findByCuisine(cusine);
    }

    @Override
    public List<Restaurant> getByCategory(String category) {
        return restaurentRepository.findByCategory(category);
    }

    public List<Restaurant> getByCuisineAndType(String cusine, String type) {
        return restaurentRepository.findByCuisineAndType(cusine, type);
    }

    @Override
    public List<Restaurant> getByItemNameLessPrice(String itemName, double price) {

        return restaurentRepository.findByItemNameLessPrice(itemName, price);

    }
}
