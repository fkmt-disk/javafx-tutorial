package tutorial

import javafx.application.Application
import javafx.stage.Stage

class Form extends Application {
  
  override def start(stage: Stage): Unit = {
    stage.setTitle("JavaFX Welcome")
    stage.show()
  }
  
}

object Form {
  
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Form], args:_*)
  }
  
}
