package com.generalstore.test;

import org.testng.annotations.Test;

import com.generalstore.pages.AddProductToCart;
import com.test.wrappers.NativeBaseTest;

public class TC002ProductList extends NativeBaseTest {

	@Test
	public void tc002AddProductToCart() {

		new AddProductToCart()
		.addItemToCart("Air Jordan 9 Retro")
		.addItemToCart("Jordan 6 Rings")
		.navigateToCart();

	}
	

}
