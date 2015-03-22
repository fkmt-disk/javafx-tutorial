package tutorial

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

class FXMLExample extends Application {

  override def start(stage: Stage): Unit = {
    val root: Parent = FXMLLoader.load(getClass.getResource("fxml.fxml"))

    val scene = new Scene(root, 300, 275)

    stage.setTitle("FXML Welcome")
    stage.setScene(scene)
    stage.show()
  }

}

object FXMLExample {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[FXMLExample], args:_*)
  }

}

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.text.Text

class FXMLExampleController {

  @FXML private var actiontarget: Text = _

  @FXML protected def handleSubmitButtonAction(event: ActionEvent): Unit = {
    actiontarget.setText("Sign in button pressed")
  }

}
