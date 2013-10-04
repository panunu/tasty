package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TasteService(database: Database) {
  def all = database.session {
    Query(Tastes).list
  }

  def add(taste: Taste) = database.session {
    Tastes.insert(taste)
  }
}