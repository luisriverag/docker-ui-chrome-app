
scalaVersion in ThisBuild := "2.11.6"

lazy val js = project.in(file("js"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "js",
    persistLauncher := true,
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "upickle" % "0.2.6",
      "org.scala-js" %%% "scalajs-dom" % "0.8.0" withSources() withJavadoc(),

      // react.js
      "com.github.japgolly.scalajs-react" %%% "extra" % "0.8.2"
    ),
    artifactPath in (Compile, fastOptJS) := (baseDirectory in ThisBuild).value / "chromeapp" / "scalajs-fastopt.js",
    artifactPath in (Compile, packageScalaJSLauncher) := (baseDirectory in ThisBuild).value / "chromeapp" / "scalajs-launcher.js"
  )

//lazy val root = project.aggregate(ui, chromeapp)

pollInterval := 100
fork in run := true