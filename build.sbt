import sbtprotobuf.{ProtobufPlugin=>PB}

//scalaVersion := "2.10.4"

scalaVersion := "2.11.8"

version in PB.protobufConfig := "2.5.0"

val rest = (project in file(".")).
  settings(
    libraryDependencies ++= Seq(
    // For finding google/protobuf/descriptor.proto
    //"com.trueaccord.scalapb" %% "scalapb-runtime" % "0.5.29" % PB.protobufConfig
    //  "org.kevoree.modeling" % "org.kevoree.modeling.kotlin.standalone" % "3.5.5"
    //  "com.google.protobuf" % "protobuf-java" % (version in PB.protobufConfig).value % PB.protobufConfig.name
    ),
    PB.protobufSettings,
    PB.runProtoc in PB.protobufConfig := { args =>
      com.github.os72.protocjar.Protoc.runProtoc("-v250" +: args.toArray)
    }
  )