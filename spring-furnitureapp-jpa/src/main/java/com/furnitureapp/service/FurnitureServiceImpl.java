package com.furnitureapp.service;


import com.furnitureapp.exceptions.FurnitureNotFoundException;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.Style;
import com.furnitureapp.repository.IFurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FurnitureServiceImpl implements IFurnitureService {

    private IFurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureServiceImpl(IFurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public void addFurniture(Furniture furniture) {
         furnitureRepository.save(furniture);

    }

    @Override
    public void updateFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    @Override
    public void deleteFurniture(int furnitureId) {
        furnitureRepository.deleteById(furnitureId);
    }

    @Override
    public Furniture getById(int furnitureId) throws FurnitureNotFoundException {
        return furnitureRepository.findByFurnitureId(furnitureId);
    }

    @Override
    public List<Furniture> getByBrand(String brand) throws FurnitureNotFoundException {
        return furnitureRepository.findByBrand(brand);
    }

    @Override
    public List<Furniture> getByCategory(String category) throws FurnitureNotFoundException {
        return furnitureRepository.findByCategory(category);
    }

    @Override
    public List<Furniture> getByRoomType(String roomType) throws FurnitureNotFoundException {
        return furnitureRepository.findByRoomType(roomType);
    }

    @Override
    public List<Furniture> getByMaterial(String material) throws FurnitureNotFoundException {
        return furnitureRepository.findByMaterial(material);
    }

    @Override
    public List<Furniture> getByStyle(Style style) throws FurnitureNotFoundException {
        return furnitureRepository.findByStyle(style);
    }

    @Override
    public List<Furniture> getByStorageAvailable(boolean Storage) {
        return furnitureRepository.findByStorageAvailable(Storage);
    }

    @Override
    public List<Furniture> getByPriceRange(double minPrice, double maxPrice) {
        return furnitureRepository.findByPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<Furniture> getByMatAndBrand(String material, String brand) {
        return furnitureRepository.findByMatAndBrand(material,brand);
    }

    @Override
    public List<Furniture> getByRoomAndCategory(String RoomType, String category) {
        return furnitureRepository.findByRoomAndCategory(RoomType,category);
    }

    @Override
    public Integer getTotal() {
        return furnitureRepository.findTotal();
    }

    @Override
    public Integer getCategoryCost(String category) {
        return furnitureRepository.findCategoryCost(category);
    }
}
