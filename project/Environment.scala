import scala.util.Properties

object Environment {
  lazy val javaGdalDir = Properties.envOrElse("JAVA_GDAL_DIR", "/usr/local/lib")
  lazy val hadoopVersion  = Properties.envOrElse("SPARK_HADOOP_VERSION", "2.2.0")
  lazy val sparkVersion   = Properties.envOrElse("SPARK_VERSION", "1.5.2")
}

