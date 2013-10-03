package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TagService(database: Database) {
  def all = {
    database.session {
      Query(Tags).list
    }
  }

  def findOneOrCreate(name: String) = {
    println(name)
    findByName(name) match {
      case tag: Tag => tag
      case None => add(new Tag(None, name))
    }
  }

  def findByName(name: String) = {
    database.session {
      Query(Tags).filter(_.name == name).list
    }
  }

  def add(tag: Tag) = {
    database.session {
      Tags.insert(tag)
    }
  }
}