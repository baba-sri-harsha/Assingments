package com.restaurantapp;

import com.restaurantapp.model.*;
import com.restaurantapp.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringDataJpaRestaurantApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaRestaurantApplication.class, args);
	}


	@Autowired
	IRestaurantService restaurantService;

	@Override
	public void run(String... args) throws Exception {

		Item item1 = new Item("kebab", Category.MAINCOURSE, Cuisine.SOUTHINDIAN.name(), Type.NONVEG,100);
		Item item2 = new Item("biriyani", Category.MAINCOURSE, Cuisine.SOUTHINDIAN.name(), Type.NONVEG,200);
		Item item3 = new Item("grill", Category.STARTERS, Cuisine.CHINEESE.name(),  Type.NONVEG,340);
		Item item4 = new Item("chicken lollipop", Category.STARTERS, Cuisine.ITALIAN.name(),  Type.NONVEG,300);


		List<Item> itemList = Arrays.asList(item1, item2, item3,item4);
		Set<Item> items = new HashSet<>(itemList);
		Restaurant restaurant2 = new Restaurant("nanadanas","banglore",Type.NONVEG,5,items);
//		restaurantService.addRestaurant(restaurant2);
//
//
//		Restaurant restaurant1= restaurantService.getByRestaurantId(1);

//		restaurant1.setName("mehfil");
//		restaurant1.setRating(3.5);
//		restaurant1.setCity("hyderbad");
//		restaurantService.updateRestaurant(restaurant1);
//
//
//		restaurantService.deleteRestaurant(1);

//		restaurantService.getByCity("hyderabad").forEach(System.out::println);

//		restaurantService.getByType(Type.VEG).forEach(System.out::println);

//		restaurantService.getByRating(5).forEach(System.out::println);

//		restaurantService.getByItemNameString("uthapam").forEach(System.out::println);

//		restaurantService.getByItemNameCategory("uthapam",Category.BREAKFAST).forEach(System.out::println);
//
//	restaurantService.getByCuisine("chineese").forEach(System.out::println);

// 		restaurantService.getByCategory(Category.BREAKFAST.name()).forEach(System.out::println);

//		restaurantService.getByItemNameLessPrice("chicken lollipop",300).forEach(System.out::println);


	}
}
