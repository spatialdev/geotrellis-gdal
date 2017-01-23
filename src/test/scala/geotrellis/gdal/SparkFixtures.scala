package geotrellis.gdal

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Fixtures for tests with Spark.
  */
trait SparkFixtures {
  /**
    * Creates a SparkContext for the test and stops it afterwards.
    */
  def withSpark(testCode: SparkContext => Any): Any = {

    val conf = new SparkConf()
    conf
      .setMaster("local")
      .setAppName("Test Context")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.kryo.registrator", "geotrellis.gdal.TestRegistrator")
    val sc = new SparkContext(conf)

    try {
      testCode(sc)
    } finally {
      sc.stop()
    }
  }
}
