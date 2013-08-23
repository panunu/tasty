package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import scala.slick.driver.MySQLDriver.simple._
import com.panuleppaniemi.tasty.services.Database
import com.panuleppaniemi.tasty.models.Tastes

class TasteController extends ScalatraServlet with Database {

  get("/") {
    db withSession {
      val tastes = for {
        t <- Tastes
      } yield (t)

      "Hello"
    }
  }
  
}
