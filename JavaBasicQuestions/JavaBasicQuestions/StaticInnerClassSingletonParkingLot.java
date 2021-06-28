package com.JavaBasicQuestions;

public class StaticInnerClassSingletonParkingLot {
	private StaticInnerClassSingletonParkingLot() {}
	
	private static class LazyParkingLot{
		static final StaticInnerClassSingletonParkingLot instance = new StaticInnerClassSingletonParkingLot();
	}
	
	public static StaticInnerClassSingletonParkingLot getInstance() {
		return LazyParkingLot.instance;
	}
}
