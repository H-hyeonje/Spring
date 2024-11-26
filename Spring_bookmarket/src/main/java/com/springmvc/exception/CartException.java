package com.springmvc.exception;

import com.springmvc.dao.CartRepository;
import com.springmvc.dto.Cart;

public class CartException extends RuntimeException {
	private static final long serialVersionUID=-5192041563033358491l;
	private String cartId;
	
	public CartException(String cartId) {
		this.cartId=cartId;
	}
	
	public String getCartId() {
		return cartId;
	}
	
}
