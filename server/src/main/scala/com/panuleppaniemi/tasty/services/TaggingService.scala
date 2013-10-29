package com.panuleppaniemi.tasty.services

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.session.Database.threadLocalSession
import com.panuleppaniemi.components.Database
import com.panuleppaniemi.tasty.models._

class TaggingService(database: Database) {

  def tag(taste: Taste, tags: List[Tag]): List[Tagging] = tags.map(tag(taste, _))

  def tag(taste: Taste, tag: Tag) = database.connection.withSession { // TODO: Map to a Case class?
    val tagging = new Tagging(None, taste.id.getOrElse(0), tag.id.getOrElse(0))
    val inserted = Taggings returning Taggings.id insert(tagging)
    tagging.copy(id=Some(inserted))
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
