package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import com.panuleppaniemi.tasty.components.Database
import com.panuleppaniemi.tasty.models.Tastes

class TasteService(database: Database) {

  def all = {
    database.connection withSession {
      val tastes = for {
        t <- Tastes
      } yield (t)
    }
  }

}