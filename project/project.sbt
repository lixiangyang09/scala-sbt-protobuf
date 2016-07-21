//addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.5.29")


addSbtPlugin("com.github.gseitz" % "sbt-protobuf" % "0.5.2")


libraryDependencies ++= Seq(
  "com.github.os72" % "protoc-jar" % "3.0.0-b3"
  //  "com.github.os72" % "protobuf-java-shaded-250" % "0.9"
)
