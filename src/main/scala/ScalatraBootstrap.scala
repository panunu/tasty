import org.scalatra._
import javax.servlet.ServletContext
import com.panuleppaniemi.tasty.controllers.TasteController

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new TasteController, "/*")
  }
}
