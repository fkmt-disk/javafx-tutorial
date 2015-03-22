package tutorial

import javafx.application.Application
import javafx.event.{ActionEvent, EventHandler}
import javafx.geometry.{Insets, Pos}
import javafx.scene.Scene
import javafx.scene.control.{Button, TextField, PasswordField, Label}
import javafx.scene.layout.{HBox, GridPane}
import javafx.scene.paint.Color
import javafx.scene.text.{Font, FontWeight, Text}
import javafx.stage.Stage

class Css extends Application {
  
  override def start(stage: Stage): Unit = {
    stage.setTitle("JavaFX Welcome")

    val grid = new GridPane
    grid.setAlignment(Pos.CENTER)
    grid.setHgap(10)
    grid.setVgap(10)
    grid.setPadding(new Insets(25, 25, 25, 25))

    val scenetitle = new Text("Welcome")
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20))
    scenetitle.setId("welcome-text")
    grid.add(scenetitle, 0, 0, 2, 1)

    val userName = new Label("User Name:")
    grid.add(userName, 0, 1)

    val userTextField = new TextField
    grid.add(userTextField, 1, 1)

    val pw = new Label("Password:")
    grid.add(pw, 0, 2)

    val pwBox = new PasswordField
    grid.add(pwBox, 1, 2)

    val actiontarget = new Text
    grid.add(actiontarget, 1, 6)

    val btn = new Button("Sign in")
    btn.setOnAction(new EventHandler[ActionEvent]() {
      override def handle(e: ActionEvent): Unit = {
        actiontarget.setFill(Color.FIREBRICK)
        actiontarget.setText("Sign in button pressed")
        actiontarget.setId("actiontarget")
      }
    })

    val hbBtn = new HBox(10)
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT)
    hbBtn.getChildren.add(btn)
    grid.add(hbBtn, 1, 4)

    val scene = new Scene(grid, 300, 275)
    stage.setScene(scene)
    scene.getStylesheets.add(classOf[Css].getResource("css.css").toExternalForm)

    stage.show()
  }
  
}

object Css {
  
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Css], args:_*)
  }
  
}
