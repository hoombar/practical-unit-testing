package main.java.ch10;

import java.awt.Color;

public class CarImpl implements Car {

	private Color color;
	private Engine engine;
	private Manufacturer manufacturer;
	
	public CarImpl(Engine engine, Color color, Manufacturer manufacturer) {
		this.engine = engine;
		this.color = color;
		this.manufacturer = manufacturer;
	}
	
	@Override
	public Engine getEngine() {
		return engine;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	@Override
	public boolean isSportsCar() {
		return getEngine().getNbOfCylinders() > 6
				&& Color.RED == getColor()
				&& "Ferrari".equals(getManufacturer().getName());
	}

}
