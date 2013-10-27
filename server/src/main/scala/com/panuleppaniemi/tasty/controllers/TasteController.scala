package com.panuleppaniemi.tasty.controllers

import org.scalatra._
import com.panuleppaniemi.components.Controller
import com.panuleppaniemi.tasty.models._

class TasteController extends Controller {

  get("/tastes") {
    tasteService.all.map(taggingService.withTags(_))
  }

  post("/tastes") {
    val tags = tagService.findByNameOrCreate(((parsedBody \ "tags").values).asInstanceOf[List[String]])
    val taste = tasteService.add(parsedBody.extract[Taste])

    taggingService.tag(taste, tags)
  }

}
