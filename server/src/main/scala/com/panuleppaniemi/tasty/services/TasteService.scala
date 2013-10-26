package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TasteService(database: Database) {
  def all = database.connection.withSession {
    Query(Tastes).list
  }

  def allCombinedWithTags = database.connection.withSession {
    val query = for {
      taste <- Tastes
    } yield (taste)

    //println(query.selectStatement)
    //println(query.list)

    println()
    println()


    val q = Taggings.filter(_.tag == 1)
    println(q.selectStatement)
    println(q.list)

  }

  def add(taste: Taste) = database.connection.withSession {
    taste.copy(id=Some(Tastes returning Tastes.id insert(taste))) // TODO: too much code.
  }
}