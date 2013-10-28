package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TagService(database: Database) {
  def findAll = database.connection.withSession {
    Query(Tags).list
  }

  def findByNameOrCreate(tags: List[String]) = tags.map(findOneByNameOrCreate(_))

  def findOneByNameOrCreate(name: String) = {
    findOneByName(name) match {
      case Some(tag: Tag) => tag
      case None => add(new Tag(None, name.toLowerCase))
    }
  }

  def findOneByName(name: String) = database.connection.withSession {
    Query(Tags).filter(_.name === name.toLowerCase).firstOption
  }

  def add(tag: Tag) = database.connection.withSession {
    val inserted = Tags returning Tags.id insert(tag)
    tag.copy(id=Some(inserted)) // TODO: Extract copy mechanism somehow.
  }
}
