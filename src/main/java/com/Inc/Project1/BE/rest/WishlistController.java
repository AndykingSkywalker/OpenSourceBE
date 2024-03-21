package com.Inc.Project1.BE.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inc.Project1.BE.domain.Wishlist;
import com.Inc.Project1.BE.service.WishlistService;

@CrossOrigin
@RequestMapping("/wishlist")
@RestController
public class WishlistController {

	private WishlistService service;

	public WishlistController(WishlistService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist newWishlist) {
		return this.service.createWishlist(newWishlist);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteWishlist(@PathVariable Integer id) {
		return this.service.deleteWishlist(id);
	}

	@GetMapping("/get")
	public List<Wishlist> getWishlists() {
		return this.service.getWishlists();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Wishlist> getWishlist(@PathVariable Integer id) {
		return this.service.getWishlist(id);
	}

	@PatchMapping("add/{itemId}/{wishlistId}")
	public ResponseEntity<Object> addToBasket(@PathVariable int itemId, @PathVariable int basketId) {
		return this.service.addToBasket(itemId, basketId);
	}
}
