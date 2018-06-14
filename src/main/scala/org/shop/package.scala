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
}
