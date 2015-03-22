package tutorial

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class HelloWorld extends Application {
  
  override def start(stage: Stage): Unit = {
    
    val btn = new Button
    
    btn.setText("Say 'Hello World'")
    
    btn.setOnAction(new EventHandler[ActionEvent] {
      override def handle(event: ActionEvent): Unit = {
        System.out.println("Hello World!")
      }
    })
    
    val root = new StackPane
    root.getChildren.add(btn)
    
    val scene = new Scene(root, 300, 250)
    
    stage.setTitle("Hello World!")
    stage.setScene(scene)
    stage.show()
  }
  
}

object HelloWorld {
  
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[HelloWorld], args:_*)
  }
  
}
