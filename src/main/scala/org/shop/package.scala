package org

package object shop {
  sealed trait Fruit { val cost: BigDecimal; val name: String }
  case object Apple extends Fruit { val cost = 0.6; val name = "apple" }
  case object Orange extends Fruit { val cost = 0.25; val name = "orange" }

  val validFruits = Seq(Apple, Orange)
  implicit def convert(fruits: Seq[String]): Seq[Fruit] =
    fruits.flatMap(fruit => validFruits.find(_.name == fruit))

  case class ShoppingCart(fruits: Seq[Fruit]) {
    lazy val totalCost: BigDecimal =
      fruits.foldLeft(BigDecimal(0))(_ + _.cost)
  }

  sealed trait Offer { def applyTo(cost: BigDecimal, fruits: Seq[Fruit]): BigDecimal }
  final case class FruitAmountOffer(fruit: Fruit, offerAmount: Int) extends Offer {
    def applyTo(cost: BigDecimal, fruits: Seq[Fruit]): BigDecimal = {
      val timesToApplyDiscount = fruits.count(_ == fruit) / offerAmount
      val discount = timesToApplyDiscount * fruit.cost
      cost - discount
    }
  }

  final case class Checkout(shoppingCart: ShoppingCart, offers: Seq[Offer]) {
    lazy val cost = {
      offers.foldRight(shoppingCart.totalCost)(_.applyTo(_, shoppingCart.fruits))
    }
  }
}
