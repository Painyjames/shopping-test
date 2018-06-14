package org.shop

import org.scalatest.{Matchers, WordSpecLike}

class CheckoutSpec extends WordSpecLike
  with Matchers {
  "Checkout" should {
    "apply specific offers to shopping cart and expect the correct cost" in {
      val twoForOneAppleOffer = FruitAmountOffer(Apple, 2)
      val threeForTwoOrangeOffer = FruitAmountOffer(Orange, 3)
      val fruits = Seq(Orange, Orange, Apple, Orange, Apple)
      val shoppingCart = ShoppingCart(fruits)
      val checkout = new Checkout(shoppingCart, Seq(twoForOneAppleOffer, threeForTwoOrangeOffer))
      val expectedCost = Orange.cost * 2 + Apple.cost

      checkout.cost shouldBe expectedCost
    }
  }
}