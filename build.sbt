lazy val commonSettings = Seq(
  organization := "com.github.cbismuth",
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.11.5"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "playground-scala"
  )
