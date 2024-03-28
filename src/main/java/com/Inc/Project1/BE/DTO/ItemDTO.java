package com.Inc.Project1.BE.DTO;

import com.Inc.Project1.BE.domain.Item;

public class ItemDTO {

	private int itemId;

	private String itemName;

	private Double price;

	public ItemDTO(Item item) {
		super();
		this.setItemId(item.getId());
		this.setItemName(item.getName());
		this.setPrice(item.getPrice());

	}

	public ItemDTO() {
		super();
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
