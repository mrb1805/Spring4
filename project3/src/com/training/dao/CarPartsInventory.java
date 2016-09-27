package com.training.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.training.entity.CarParts;


public interface CarPartsInventory {

	public void addNewPart(CarParts carParts);
	public CarParts loadCarParts(int partNo);
	public List<CarParts> loadAllAvailableCarParts();
}
