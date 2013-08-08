package controllers

import play.api.mvc._
import play.api.db._
import play.api.Play.current

object Taste extends Controller {

  def list = Action {
    val connection = DB.getConnection()

    Ok("Lus")
  }

  def add = TODO
}
