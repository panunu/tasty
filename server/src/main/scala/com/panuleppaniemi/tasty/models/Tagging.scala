package com.panuleppaniemi.tasty.models

import scala.slick.driver.MySQLDriver.simple._

case class Tagging(id: Option[Long] = None, tag: Long, taste: Long)

object Taggings extends Table[Tagging]("taggings") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def tag = column[Long]("tag_id")
  def taste = column[Long]("taste_id")

  def * = id.? ~ tag ~ taste <> (Tagging, Tagging.unapply(_))
}
