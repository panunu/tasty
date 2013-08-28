package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.components.Controller
import com.panuleppaniemi.tasty.models.Taste

class TasteController extends Controller {

  get("/tastes") {
    tasteService.all
  }

  post("/tastes") {
    println(parsedBody.extract[Taste])
  }
  
}
