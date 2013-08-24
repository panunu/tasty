package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import com.panuleppaniemi.tasty.services.Container

abstract class Controller extends ScalatraServlet with Container with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }
}