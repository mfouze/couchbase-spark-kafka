name := "CouchbaseConnect"

version := "0.1"

scalaVersion := "2.12.13"

val PlayVersion = "2.7.3"
val SwaggerVersion = "1.7.1"
val SbtVersion = "1.3.8"


val api = (project in file("./api"))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLogback)
  .settings(
    name := """playScalaKafka""",
    scalaVersion := "2.12.13",
    libraryDependencies ++= Seq(
      guice,
      filters,
      ws,
      "io.swagger"               %% "swagger-play2"             % "1.7.1",
      "com.github.stijndehaes"   %% "play-prometheus-filters"   % "0.5.0"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )

libraryDependencies ++= Seq(
  "com.couchbase.client" %% "scala-client" % "1.1.3",
  "org.apache.logging.log4j" %% "log4j-api-scala" % "11.0",
  "org.apache.spark" %% "spark-core" % "3.0.1",
  "org.apache.spark" %% "spark-sql" % "3.0.1",
  "org.apache.kafka" %% "kafka" % "2.7.0",

)

val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

