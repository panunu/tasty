package com.panuleppaniemi.tasty.models

import scala.slick.driver.MySQLDriver.simple._

case class Taste(id: Option[Long] = None, name: String, description: String, rating: Int)

object Tastes extends Table[Taste]("tastes") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def description = column[String]("description")
  def rating = column[Int]("rating")

  def * = id.? ~ name ~ description ~ rating <> (Taste, Taste.unapply _)
}
