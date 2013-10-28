package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TasteService(database: Database, taggingService: TaggingService) {
  def findAll = database.connection.withSession {
    Query(Tastes).list
  }

  def add(taste: Taste) = database.connection.withSession {
    val inserted = Tastes returning Tastes.id insert(taste)
    taste.copy(id=Some(inserted))
  }

  def withTags(taste: Taste) = database.connection.withSession {
    // TODO: Try to reduce into a single query.

    val q = for {
      tagging <- Taggings
      tag <- Tags
      if tagging.taste === taste.id
      if tagging.tag === tag.id
    } yield (tag)

    TasteWithTags(taste, q.list)
  }
}
