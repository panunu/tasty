package com.panuleppaniemi.tasty

import org.scalatra._
import scalate.ScalateSupport

class TastyServlet extends ScalatraServlet {

  get("/") {
    "Hello"
  }
  
}
