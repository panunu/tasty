package com.panuleppaniemi.tasty

import org.scalatra._

class TasteController extends ScalatraServlet with UrlSupport {

  get("/") {
    "Hello"
  }
  
}
