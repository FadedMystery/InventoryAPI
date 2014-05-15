package me.fadedmystery.invapi.api;

public enum InventorySize {

	NINE(9),
	EIGHTEEN(18),
	TWENTY_SEVEN(27),
	THIRTY_SIX(36),
	FORTY_FIVE(45);
	
	private int value;
	
	InventorySize(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}