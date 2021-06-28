package com.JavaBasicQuestions;

import java.util.ArrayList;
import java.util.List;

public class BasicSingletonParkingLot {
	private static BasicSingletonParkingLot instance = null;
	private List<Level> levels;
	private BasicSingletonParkingLot() {
		levels = new ArrayList<Level>();
	}
	
	public static BasicSingletonParkingLot getInstance() {
		if(instance == null) {
			instance = new BasicSingletonParkingLot();
		}
		return instance;
	}
}
