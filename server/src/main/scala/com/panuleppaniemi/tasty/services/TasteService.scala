package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models.Tastes

class TasteService(database: Database) {
  def all = {
    database.connection withSession { // TODO: Figure out a way to abstract persistence layer.
      // TODO: Try Query() here instead.
      val q = for {
        t <- Tastes
      } yield t

      q.list
    }
  }
}