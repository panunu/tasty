package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.components.Controller
import com.panuleppaniemi.tasty.models._

class TasteController extends Controller {

  get("/tastes") {
    tasteService.all
  }

  post("/tastes") {
    // TODO: How to avoid Any?

    val tags = tagService.findByNameOrCreate(((parsedBody \ "tags").values).asInstanceOf[List[String]])
    val taste = tasteService.add(parsedBody.extract[Taste])
    tagService.tag(taste.asInstanceOf[Taste], tags.asInstanceOf[List[Tag]])
  }

}
