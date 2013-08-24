package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.tasty.services.Container

class TasteController extends ScalatraServlet with Container {

  get("/") {
    "Hello"
  }
  
}
