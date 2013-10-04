package com.panuleppaniemi.tasty.models

import scala.slick.driver.MySQLDriver.simple._

case class Tag(id: Option[Long] = None, name: String)

object Tags extends Table[Tag]("tags") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")

  def * = id.? ~ name <> (Tag, Tag.unapply(_))

  def nameIsUnique = index("index_name_unique", (name), unique = true)
}
