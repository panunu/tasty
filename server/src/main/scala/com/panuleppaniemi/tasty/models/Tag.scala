package com.panuleppaniemi.tasty.models

import scala.slick.driver.MySQLDriver.simple._

case class Tag(id: Option[Int] = None, name: String)

object Tags extends Table[Tag]("tags") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")

  def * = id.? ~ name <> (Tag, Tag.unapply(_))

  def nameIsUnique = index("name_unique", name, unique = true)
}
