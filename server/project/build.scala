import sbt._
import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._

object TastyBuild extends Build {
  val Organization = "com.panuleppaniemi"
  val Name = "Tasty"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.10.3"
  val ScalatraVersion = "2.2.1"

  lazy val project = Project (
    "tasty",
    file("."),
    settings = seq(com.typesafe.startscript.StartScriptPlugin.startScriptForClassesSettings: _*) ++ Defaults.defaultSettings ++ ScalatraPlugin.scalatraWithJRebel ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "com.typesafe.slick" %% "slick" % "1.0.1",
        "mysql" % "mysql-connector-java" % "5.1.13",
        "c3p0" % "c3p0" % "0.9.1.2",
        "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
        "com.softwaremill.macwire" %% "core" % "0.4",
        "com.softwaremill.macwire" %% "scopes" % "0.4",
        "org.scalatra" %% "scalatra-json" % "2.2.1",
        "org.json4s" %% "json4s-jackson" % "3.2.4",
        "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "compile;container",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "compile;container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
      )
    )
  ).dependsOn(deliciousValidation)

  lazy val deliciousValidation = RootProject(uri("git://github.com/mpartel/delicious-validation"))
}
