package com.panuleppaniemi.components

import com.softwaremill.macwire.MacwireMacros._
import com.panuleppaniemi.tasty.services._

trait Container {
  lazy val database = wire[Database]

  lazy val tasteService = wire[TasteService]
  lazy val tagService = wire[TagService]
  lazy val taggingService = wire[TaggingService]
}