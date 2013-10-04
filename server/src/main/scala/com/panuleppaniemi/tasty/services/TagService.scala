package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TagService(database: Database) {
  def all = database.connection.withSession { // TODO: Extract again...
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
    tag.copy(id=Some(Tags returning Tags.id insert(tag))) // TODO: Extract copy mechanism somehow.
  }

  def tag(taste: Taste, tags: List[Tag]): List[Tagging] = tags.map(tag(taste, _))

  def tag(taste: Taste, tag: Tag) = database.connection.withSession {
    val tagging = new Tagging(None, taste.id.getOrElse(0), tag.id.getOrElse(0))
    tagging.copy(id=Some(Taggings returning Taggings.id insert(tagging)))
  }
}