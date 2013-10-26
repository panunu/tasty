package com.panuleppaniemi.tasty.models

import scala.slick.driver.MySQLDriver.simple._
import so.delicious.validation._

case class Taste(id: Option[Long] = None, name: String, description: String, rating: Int) extends Validated {
  rating ~ "must range from 0 to 5" ~ (0 <= rating && rating <= 5)
}

case class TasteWithTags(taste: Taste, tags: List[Tag])

object Tastes extends Table[Taste]("tastes") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def description = column[String]("description")
  def rating = column[Int]("rating")

  def tags = Taggings.filter(_.taste === id).flatMap(_.tagForeignKey)

  def * = id.? ~ name ~ description ~ rating <> (Taste, Taste.unapply _)
}
