package models

import play.api.db.slick.Config.driver.simple._

object Tastes extends Table[(Long, String, String, Int)]("tastes") {
  def id   = column[Long]("id", O.PrimaryKey)
  def name = column[String]("name", O.NotNullable)
}