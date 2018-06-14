package org.shop

import org.scalatest.{Matchers, WordSpecLike}

class OfferSpec extends WordSpecLike
  with Matchers {
  "FruitAmountOffer" should {
    "apply offer 2x1 on apples" in {
      val fruits = Seq(Apple, Apple)
      val fruitsCost = fruits.foldLeft(BigDecimal(0))(_ + _.cost)
      val offer = Offer(Apple, 2)
      val expectedCostAfterOffer = Apple.cost

      val cost = offer.applyTo(fruitsCost, fruits)

      cost shouldBe expectedCostAfterOffer
    }
    "apply offer 3x2 on oranges" in {
      val fruits = Seq(Orange, Orange, Orange)
      val fruitsCost = fruits.foldLeft(BigDecimal(0))(_ + _.cost)
      val offer = Offer(Orange, 3)
      val expectedCostAfterOffer = Orange.cost * 2

      val cost = offer.applyTo(fruitsCost, fruits)

      cost shouldBe expectedCostAfterOffer
    }
  }
}
