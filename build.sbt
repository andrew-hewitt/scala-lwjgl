name := """scala-lwjgl"""

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-feature", "-deprecation")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

testOptions += Tests.Argument("-oD")

libraryDependencies ++= Seq(
  "org.scalatest"     %% "scalatest"      % "2.2.4"  % "test",
  "com.typesafe.akka" %% "akka-actor"     % "2.3.11",
  "org.lwjgl"          % "lwjgl"          % "3.0.0a",
  "org.lwjgl"          % "lwjgl-platform" % "3.0.0a" classifier "natives-windows",
  "org.lwjgl"          % "lwjgl-platform" % "3.0.0a" classifier "natives-linux",
  "org.lwjgl"          % "lwjgl-platform" % "3.0.0a" classifier "natives-osx"
)

fork in run := true

// Required for OSX
javaOptions ++= Seq("-XstartOnFirstThread")
