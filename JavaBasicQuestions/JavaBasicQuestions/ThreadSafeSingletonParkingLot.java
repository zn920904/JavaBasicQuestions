package com.JavaBasicQuestions;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeSingletonParkingLot {
	private static ThreadSafeSingletonParkingLot instance = null;
	private List<Level> levels;
	private ThreadSafeSingletonParkingLot() {
		levels = new ArrayList<Level>();
	}
	
	public static synchronized ThreadSafeSingletonParkingLot getInstance() {
		if(instance == null) {
			instance = new ThreadSafeSingletonParkingLot();
		}
		return instance;
	}
}
