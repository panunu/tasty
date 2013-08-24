import org.scalatra._
import javax.servlet.ServletContext
import com.panuleppaniemi.tasty.controllers.TasteController
import com.panuleppaniemi.tasty.services.Container

class ScalatraBootstrap extends LifeCycle with Container {
  override def init(context: ServletContext) {
    context.mount(new TasteController, "/*")
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
    database.source.close
  }
}
