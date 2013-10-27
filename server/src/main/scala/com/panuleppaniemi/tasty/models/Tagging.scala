package com.panuleppaniemi.tasty.models

import scala.slick.driver.MySQLDriver.simple._

case class Tagging(id: Option[Int] = None, tag: Int, taste: Int)

object Taggings extends Table[Tagging]("taggings") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def tag = column[Int]("tag_id")
  def taste = column[Int]("taste_id")

  def * = id.? ~ tag ~ taste <> (Tagging, Tagging.unapply(_))
  def tagForeignKey = foreignKey("tag_fk", tag, Tags)(_.id)
  def tasteForeignKey = foreignKey("taste_fk", taste, Tastes)(_.id)
}
