package com.furnitureapp;

import com.furnitureapp.model.*;
import com.furnitureapp.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Table;

import static java.lang.Boolean.TRUE;

@SpringBootApplication
public class SpringFurnitureAppJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringFurnitureAppJpaApplication.class, args);
	}



	@Autowired
	IFurnitureService furnitureService;

	@Override
	public void run(String... args) throws Exception {

		//Furniture furniture= new Furniture("teapoi", Category.TABLE.name(), RoomType.LIVING.name(),Material.SWOOD.name() ,Style.valueOf("MODERN"),"nilkamal",100,false);

//		Furniture furniture= new Furniture("two door cabinet", Category.CABINETRY.name(), RoomType.OFFICE.name(),Material.TWOOD.name() ,Style.valueOf("MIDCENTURY"),"curlon",25000,TRUE);
//		Furniture furniture= new Furniture("GARDEN CHAIR", Category.CHAIR.name(), RoomType.KIDS.name(),Material.PLASTIC.name(), Style.valueOf("MODERN") ,"WAKE FIT",4000,TRUE);
//		Furniture furniture= new Furniture("THREE door cabinet", Category.CABINETRY.name(), RoomType.OFFICE.name(),Material.TWOOD.name() ,Style.valueOf("MIDCENTURY"),"RAJ INDUSTRIES",25600,TRUE);
//
//		furnitureService.addFurniture(furniture);
	
//		Furniture furnitureUpdate = furnitureService.getById(3);
//		System.out.println(furnitureUpdate);
//		furnitureUpdate.setPrice(4500);
//		furnitureService.updateFurniture(furnitureUpdate);
//		System.out.println(furnitureUpdate);

//		furnitureService.getByCategory(Category.TABLE.name()).forEach(System.out::println);

//		furnitureService.getByBrand("nilkamal").forEach(System.out::println);

//		furnitureService.getByRoomType("living").forEach(System.out::println);


//		furnitureService.getByMaterial("TWOOD").forEach(System.out::println);

//		furnitureService.getByStyle(Style.MODERN).forEach(System.out::println);

//		furnitureService.getByStorageAvailable(true).forEach(System.out::println);

//		furnitureService.getByPriceRange(2000,25000).forEach(System.out::println);

//		furnitureService.getByMatAndBrand("TWOOD","nilkamal").forEach(System.out::println);

//		furnitureService.getByRoomAndCategory("living","table").forEach(System.out::println);

//		System.out.println(furnitureService.getTotal());

//		System.out.println(furnitureService.getCategoryCost(Category.TABLE.name()));


	}
}
