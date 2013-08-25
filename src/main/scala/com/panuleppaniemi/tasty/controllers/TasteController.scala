package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.tasty.components.Controller

class TasteController extends Controller {

  get("/") {
    tasteService.all
  }
  
}
