package com.panuleppaniemi.tasty.controllers

import org.scalatra._

class TasteController extends ScalatraServlet {

  get("/") {
    "Hello"
  }
  
}
