package com.juaracoding.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Products> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public void addProduct(Products product) {
		items.add(product);
	}

	public List<Products> getItems() {
		return items;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}
}
