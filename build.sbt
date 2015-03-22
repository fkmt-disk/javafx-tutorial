lazy val root = (project in file(".")).settings(
  name := "javafx-tutorial",
  scalaVersion := "2.11.5",
  libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % Test,
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  scalacOptions += "-target:jvm-1.8",
  unmanagedJars in Compile += file(s"""sys.get("JAVA_HOME")/jre/lib/ext/jfxrt.jar"""),
  fork := true
)
