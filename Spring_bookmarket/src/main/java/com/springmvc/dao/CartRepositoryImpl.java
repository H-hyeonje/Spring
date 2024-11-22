package com.springmvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.dto.Cart;
@Repository
public class CartRepositoryImpl  implements CartRepository{
	
	private Map<String,Cart> listofCarts;
	
	public CartRepositoryImpl() {
		listofCarts =new HashMap<String, Cart>();
		}
	
	@Override
	public Cart create(Cart cart) {
		if(listofCarts.keySet().contains(cart.getCartId())) {
			throw new IllegalAccessError(String.format("장바구니를 생성할 수 없습니다. 장바구니 id(%)가 존재 합니다.", cart.getCartId()));
		}
		return cart;
	}

	@Override
	public Cart read(String catId) {
		// TODO Auto-generated method stub
		return listofCarts.get(catId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if(!listofCarts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String.format("장바구니 목록을 갱신 할 수 없습니다. 장바구니 id(%)가 존재 하지 않습니다.", cartId));
		}
		listofCarts.put(cartId, cart);
	}
	
}
