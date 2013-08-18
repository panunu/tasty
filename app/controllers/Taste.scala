package controllers

import play.api.mvc._
import play.api.db._
import play.api.Play.current
import models.Tastes

import play.api.db.slick.Config.driver.simple._
import Database.threadLocalSession

object Taste extends Controller {

  def list = Action {
    // TODO: Move to Service.
    lazy val database = Database.forDataSource(DB.getDataSource())

    database withSession {
      val q = for {
        t <- Tastes
      } yield (t)
    }

    Ok("Lus")
  }

  def add = TODO
}
