package com.panuleppaniemi.tasty.services

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TasteService(database: Database) {
  def all = database.connection.withSession {
    Query(Tastes).list
  }

  def add(taste: Taste) = database.connection.withSession {
    val inserted = Tastes returning Tastes.id insert(taste)
    taste.copy(id=Some(inserted)) // TODO: Get rid of too much code.
  }
}
