package org.shop

import org.scalatest.{Matchers, WordSpecLike}

class FruitSpec extends WordSpecLike
  with Matchers {
  "Apple" should {
    "cost 60p" in {
      Apple.cost shouldBe(0.6)
    }
  }
  "Orange" should {
    "cost 25p" in {
      Orange.cost shouldBe(0.25)
    }
  }
}
