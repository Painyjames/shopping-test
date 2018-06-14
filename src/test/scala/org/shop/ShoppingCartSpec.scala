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
  }
}
