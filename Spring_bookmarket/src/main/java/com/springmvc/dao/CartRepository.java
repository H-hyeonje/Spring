package com.springmvc.dao;

import com.springmvc.dto.Cart;

public interface CartRepository {
	Cart create(Cart cart);
	Cart read(String catId);
	void update(String cartId,Cart cart);
}
