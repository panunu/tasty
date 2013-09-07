package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TasteService(database: Database) {
  def all = {
    database.connection withSession { // TODO: Figure out a way to abstract DB layer.
      Query(Tastes).list
    }
  }

  def add(taste: Taste) = {
    database.connection withSession {
      Tastes.insert(taste)
    }
  }
}