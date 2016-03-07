lazy val commonSettings = Seq(
  version := Version.geotrellisGdal,
  scalaVersion := Version.scala,
  crossScalaVersions := Version.crossScala,
  description := "GeoTrellis benchmarking project",
  organization := "com.azavea.geotrellis",
  licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
  scalacOptions ++= Seq(
    "-deprecation",
    "-unchecked",
    "-Yinline-warnings",
    "-language:implicitConversions",
    "-language:reflectiveCalls",
    "-language:higherKinds",
    "-language:postfixOps",
    "-language:existentials",
    "-feature"),

  resolvers += Resolver.bintrayRepo("azavea", "maven"),
  libraryDependencies ++= Seq(
    "org.scalatest"       %%  "scalatest"      % "2.2.0" % "test"
  ),

  parallelExecution in Test := false,

  shellPrompt := { s => Project.extract(s).currentProject.id + " > " }
) ++ net.virtualvoid.sbt.graph.Plugin.graphSettings

lazy val root = Project("root", file(".")).
  aggregate(geotrellisRaster)

lazy val geotrellisRaster = Project("geotrellis-gdal", file("gdal")).
  settings(commonSettings: _*)

