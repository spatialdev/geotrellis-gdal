import sbt._

name := "geotrellis-gdal"
libraryDependencies ++= Seq(
  "org.gdal"         % "gdal"       % "1.11.1",
  "com.azavea.geotrellis" %% "geotrellis-raster" % "0.10.0-SNAPSHOT",
  "com.azavea.geotrellis" %% "geotrellis-spark" % "0.10.0-SNAPSHOT",
  "com.azavea.geotrellis" %% "geotrellis-spark-etl" % "0.10.0-SNAPSHOT",
  "com.github.nscala-time" %% "nscala-time" % "2.6.0",
  "org.apache.spark" %% "spark-core" % Version.spark % "provided",
  "org.apache.hadoop" % "hadoop-client" % Version.hadoop % "provided",
  "com.github.scopt" %% "scopt" % "3.3.0"
)

fork in test := false
parallelExecution in Test := false

javaOptions += s"-Djava.library.path=${Environment.javaGdalDir}"
