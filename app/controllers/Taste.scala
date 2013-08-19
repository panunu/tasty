package controllers

import play.api.mvc._
import play.api.Play.current
import play.api.db.slick.DB
import play.api.db.slick.Config.driver.simple._
import scala.slick.session.Session
import models.Tastes

object Taste extends Controller {

  def list = Action {
    // TODO: Move to Service.
    DB.withSession { implicit session: scala.slick.session.Session =>
      val tastes = for {
        t <- Tastes
      } yield (t)

      Ok(views.html.Taste.list(tastes.list))
    }
  }

  def add = TODO
}
