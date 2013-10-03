package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.components.Controller
import com.panuleppaniemi.tasty.models._

class TasteController extends Controller {

  get("/tastes") {
    tasteService.all
  }

  post("/tastes") {
    //println(tags)
    println(parsedBody.extract[Tags].tags)
    println(parsedBody.extract[Tags])
    val tags = parsedBody.extract[Tags].tags.map(tagService.findOneOrCreate _)
    tasteService.add(parsedBody.extract[Taste])
  }

}
