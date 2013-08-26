package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.components.Controller

class TasteController extends Controller {

  get("/tastes") {
    tasteService.all
  }
  
}
