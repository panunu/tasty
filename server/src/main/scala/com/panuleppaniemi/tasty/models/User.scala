package com.panuleppaniemi.tasty.models

import scala.slick.driver.MySQLDriver.simple._

case class User(id: Option[Int] = None, email: String)

object Users extends Table[User]("users") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def email = column[String]("email")
  def password = column[String]("password")

  def * = id.? ~ name ~ email ~ password <> (User, User.unapply(_))

  def emailIsUnique = index("email_unique", email, unique = true)
}
