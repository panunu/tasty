package com.panuleppaniemi.tasty

import org.scalatra._

class TasteController extends ScalatraServlet {

  get("/") {
    "Hello"
  }
  
}
