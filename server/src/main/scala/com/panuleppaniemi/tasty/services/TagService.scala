package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TagService(database: Database) {
  def all = database.session {
    Query(Tags).list
  }

  def findByNameOrCreate(tags: List[String]) = tags.map(findOneByNameOrCreate(_))

  def findOneByNameOrCreate(name: String) = {
    findOneByName(name) match {
      case Some(tag: Tag) => tag
      case None => add(new Tag(None, name.toLowerCase))
    }
  }

  def findOneByName(name: String) = database.session {
    Query(Tags).filter(_.name === name.toLowerCase).firstOption
  }

  def add(tag: Tag) = database.session {
    Tags.insert(tag)
  }

  def tag(taste: Taste, tags: List[Tag]): List[Any] = tags.map(tag(taste, _))

  def tag(taste: Taste, tag: Tag): Any = database.session {
    Taggings.insert(new Tagging(None, taste.id.getOrElse(0), tag.id.getOrElse(0))) // TODO: This can't be like this?
  }
}