package tutorial

import javafx.animation.{KeyValue, Timeline, KeyFrame}
import javafx.application.Application
import javafx.beans.value.WritableValue
import javafx.scene.effect.{BlendMode, BoxBlur}
import javafx.scene.paint.{Stop, CycleMethod, LinearGradient, Color}
import javafx.scene.shape.{Rectangle, Circle, StrokeType}
import javafx.scene.{Node, Scene, Group}
import javafx.stage.Stage
import javafx.util.Duration
import java.lang.Math.random
import scala.collection.JavaConverters._

class ColorfulCircles extends Application {

  override def start(stage: Stage): Unit = {
    val root = new Group

    val scene = new Scene(root, 800, 600, Color.BLACK)

    val circles = new Group

    for (i <- 0 to 30) {
      val circle = new Circle(150, Color.web("white", 0.05))
      circle.setStrokeType(StrokeType.OUTSIDE)
      circle.setStroke(Color.web("white", 0.16))
      circle.setStrokeWidth(4)
      circles.getChildren.add(circle)
    }

    circles.setEffect(new BoxBlur(10, 10, 3))

    val colors = new Rectangle(
      scene.getWidth,
      scene.getHeight,
      new LinearGradient(
        0d, 1d, 1d, 0d, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#f8bd55")),
        new Stop(0.14, Color.web("#c0fe56")),
        new Stop(0.28, Color.web("#5dfbc1")),
        new Stop(0.43, Color.web("#64c2f8")),
        new Stop(0.57, Color.web("#be4af7")),
        new Stop(0.71, Color.web("#ed5fc2")),
        new Stop(0.85, Color.web("#ef504c")),
        new Stop(1, Color.web("#f2660f"))
      )
    )

    colors.widthProperty.bind(scene.widthProperty)
    colors.heightProperty.bind(scene.heightProperty)

    root.getChildren.add(colors)
    root.getChildren.add(circles)

    val blendModeGroup =
      new Group(
        new Group(
          new Rectangle(
            scene.getWidth,
            scene.getHeight,
            Color.BLACK
          ),
          circles
        ),
        colors
      )

    colors.setBlendMode(BlendMode.OVERLAY)

    root.getChildren.add(blendModeGroup)

    stage.setScene(scene)


    val timeline = new Timeline
    for {
      circle: Node <- circles.getChildren.asScala
      x = circle.translateXProperty.asInstanceOf[WritableValue[Any]]
      y = circle.translateYProperty.asInstanceOf[WritableValue[Any]]
    } {
      timeline.getKeyFrames.addAll(
        new KeyFrame(Duration.ZERO, // set start position at 0
          new KeyValue(x, random * 800),
          new KeyValue(y, random * 600)
        ),
        new KeyFrame(new Duration(4000), // set end position at 40s
          new KeyValue(x, random * 800),
          new KeyValue(y, random * 600)
        )
      )
    }
    // play 40s of animation
    timeline.play()

    stage.show()
  }

}

object ColorfulCircles {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[ColorfulCircles], args:_*)
  }

}
