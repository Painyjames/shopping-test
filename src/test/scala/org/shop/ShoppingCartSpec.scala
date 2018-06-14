package org.shop

import org.scalatest.{Matchers, WordSpecLike}

class ShoppingCartSpec extends WordSpecLike
  with Matchers {
  "ShoppingCart" should {
    "have a list of fruits" in {
      val fruits = Seq(Apple, Apple, Orange, Apple)
      val shoppingCart = ShoppingCart(fruits)

      shoppingCart.fruits should contain theSameElementsAs Seq(Apple, Apple, Orange, Apple)
    }
    "outputs the expected total cost" in {
      val fruits = Seq(Apple, Apple, Orange, Apple)
      val shoppingCart = ShoppingCart(fruits)
      val expectedCost = 2.05

      shoppingCart.totalCost shouldBe expectedCost
    }
    "have to consider the possibility that the input might be a list of strings" in {
      val fruits = Seq("apple", "apple", "orange", "apple")
      val shoppingCart = ShoppingCart(fruits)

      shoppingCart.fruits should contain theSameElementsAs Seq(Apple, Apple, Orange, Apple)
    }
  }
}
