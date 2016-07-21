package custom_options
//import java.io.{ByteArrayOutputStream, File, FileOutputStream, ObjectOutputStream}
import java.io._

import custom_options.ReferenceTable._

//import com.trueaccord.scalapb.ScalaPbPlugin
//import my_opts._

object test{

  def main(args:Array[String]): Unit ={
    {
      //encode
     // val tmp = new ReferenceTable.ReferenceTableRecord(Option("12"),Option("32"),Option("323"),Option("333"))
      val tmp = ReferenceTableRecord.newBuilder
//      tmp.update(_.id := 11)
//      tmp.update(_.str := "hello")

      tmp.setRuleSetVersion("3")
      tmp.setRootSchema("32")
      tmp.setNamespaceInfo("sawa")
      tmp.setXmlTable("fwafwafsafwaf")
      println(tmp)

      val file = new File("test")
      val out = new FileOutputStream(file)
      val baos = new ByteArrayOutputStream()

      val res = tmp.build()

      res.writeTo(out)
      baos.writeTo(out)
      baos.flush()
      baos.close()
    }

    {
      //decode
      val file = new File ("test")
      val in = new FileInputStream(file)
      val bytes = new Array[Byte](file.length().toInt)
      in.read (bytes)
      in.close()

      val res = ReferenceTable.ReferenceTableRecord.parseFrom(bytes)

      println(res)
    }

  }

}
