package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import com.panuleppaniemi.tasty.models.Tastes

case class TasteService extends Service with Database {

  def all = {
    db withSession {
      val tastes = for {
        t <- Tastes
      } yield (t)
    }
  }

}