package geotrellis.gdal

import org.gdal.gdal.{Driver, gdal}
import org.scalatest.FunSpec

trait OnlyIfJpeg2000PluginInstalled extends FunSpec {

  // Only run f if some GDAL JPEG2000 plugin is installed.
  def ifJpeg2000PluginInstalled(f: => Unit): Unit = {
    val jpeg2000Drivers: List[String] =
        List("JPEG2000", "JP2ECW", "JP2KAK", "JP2Lura", "JP2MrSID", "JP2OpenJPEG", "JPIPKAK")

    val driversInstalled: List[Driver] = jpeg2000Drivers map { gdal.GetDriverByName }

    if (driversInstalled.exists(_ != null)) f
    else ignore("GDAL JPEG2000 plugins not installed, skipping") { }
  }
}
