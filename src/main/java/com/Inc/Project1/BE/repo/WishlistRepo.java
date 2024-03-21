package com.Inc.Project1.BE.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inc.Project1.BE.domain.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

}
