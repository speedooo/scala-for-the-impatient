libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"

lazy val commonSettings = Seq(
  organization := "com.github.cbismuth",
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.10.4"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "playground-scala"
  )
