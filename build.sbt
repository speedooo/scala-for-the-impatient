lazy val commonSettings = Seq(
  organization := "com.github.cbismuth",
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.11.5"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "scala-for-the-impatient"
  )

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

import scalariform.formatter.preferences._

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignParameters, true)
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
