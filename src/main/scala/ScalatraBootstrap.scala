import org.scalatra._
import com.panuleppaniemi.tasty.TasteController
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new TasteController, "/*")
  }
}
