package com.panuleppaniemi.tasty.components

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

abstract class Controller extends ScalatraServlet with Container with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }
}