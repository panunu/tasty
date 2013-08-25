package com.panuleppaniemi.tasty.controllers

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
// TODO: Fixtures and a test database.
class TasteControllerSpec extends ScalatraSpec { def is =
  "GET /taste/list" ^
    "should return status 200" ! status200^
    end

  addServlet(classOf[TasteController], "/*")

  def status200 = get("/tastes") {
    status must_== 200
  }
}
