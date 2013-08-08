package controllers

import play.api.mvc._
import play.api.db._
import play.api.Play.current
import models.Tastes

object Taste extends Controller {

  def list = Action {
    // TODO: Move to Service.
    val connection = DB.getConnection()

    Ok("Lus")
  }

  def add = TODO
}
