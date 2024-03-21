package com.Inc.Project1.BE.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inc.Project1.BE.domain.Wishlist;
import com.Inc.Project1.BE.repo.WishlistRepo;

@Service
public class WishlistService {

	private WishlistRepo repo;

	public WishlistService(WishlistRepo repo) {
		super();
		this.repo = repo;
	}

	// Create Wishlist
	public ResponseEntity<Wishlist> createWishlist(Wishlist newWishlist) {
		Wishlist created = this.repo.save(newWishlist);

		return new ResponseEntity<Wishlist>(created, HttpStatus.CREATED);
	}

	// Delete Wishlist
	public boolean deleteWishlist(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// Read Wishlists
	public List<Wishlist> getWishlists() {
		return this.repo.findAll();
	}

	// Read Wishlist
	public ResponseEntity<Wishlist> getWishlist(Integer id) {
		Optional<Wishlist> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Wishlist>(HttpStatus.NOT_FOUND);
		}

		Wishlist body = found.get();

		return ResponseEntity.ok(body);
	}

	// Update Wishlist
	public ResponseEntity<Wishlist> updateWishlist(Integer id, Wishlist newWishlist) {
		Optional<Wishlist> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Wishlist>(HttpStatus.NOT_FOUND);
		}

		Wishlist existing = found.get();

		if (newWishlist.getItems() != null) {
			existing.setItems(newWishlist.getItems());
		}

		Wishlist updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

}
