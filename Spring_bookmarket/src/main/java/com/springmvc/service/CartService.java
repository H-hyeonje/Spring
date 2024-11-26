package com.springmvc.service;

import com.springmvc.dto.Cart;

public interface CartService {
	Cart create(Cart cart);
	Cart read(String cartId);
	void update(String cartId, Cart cart);
	Cart validateCart(String cartId);
	void delete(String cartId);
}
