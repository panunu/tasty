package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import com.panuleppaniemi.tasty.components.Controller

class TasteController extends Controller {

  get("/") {
    tasteService.all
  }
  
}
