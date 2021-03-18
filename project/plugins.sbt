addSbtPlugin("org.jetbrains" % "sbt-ide-settings" % "1.1.0")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.7")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.x")

addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full
)