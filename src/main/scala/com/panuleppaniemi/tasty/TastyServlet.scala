package com.panuleppaniemi.tasty

import org.scalatra._
import scalate.ScalateSupport

class TastyServlet extends TastyStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
}
