package com.springmvc.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {
	private String cartId;
	private Map<String,CartItem> cartItems;
	private int grandTotal;
	
	public Cart() {
		cartItems=new HashMap<String,CartItem>();
		grandTotal=0;
	}

	public Cart(String cartId) {
		super();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public void updateGrandTotal() {
		grandTotal=0;
		for(CartItem item : cartItems.values()) {
			grandTotal=grandTotal+item.getTotalPrice();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if(cartId==null) {
			if(other.cartId !=null) {
				return false;
			}
		} else if(!cartId.equals(other.cartId))
			return false;
		return true;
	}
	
	public void addCartItem(CartItem item) {
		String bookId=item.getBook().getBookId();
		
		
		if(cartItems.containsKey(bookId)) {
			CartItem cartItem = cartItems.get(bookId);//등록된 도서 ID에 대한 정보 가져오기
			
			cartItem.setQuantity(cartItem.getQuantity()+item.getQuantity());
			cartItems.put(bookId,cartItem);
		}else {
			cartItems.put(bookId,item);
		}
		updateGrandTotal();
	}
	
	
}
