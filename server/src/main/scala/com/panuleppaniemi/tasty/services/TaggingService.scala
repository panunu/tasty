package com.panuleppaniemi.tasty.services

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TaggingService(database: Database) {

  def tag(taste: Taste, tags: List[Tag]): List[Tagging] = tags.map(tag(taste, _))

  def tag(taste: Taste, tag: Tag) = database.connection.withSession { // TODO: Map to a Case class?
  val tagging = new Tagging(None, taste.id.getOrElse(0), tag.id.getOrElse(0))
    tagging.copy(id=Some(Taggings returning Taggings.id insert(tagging)))
  }

}
