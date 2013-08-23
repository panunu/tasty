package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.tasty.services.TasteService

class TasteController extends ScalatraServlet {

  get("/") {
    TasteService().all // TODO: Dependency-injectify.

    "Hello"
  }
  
}
