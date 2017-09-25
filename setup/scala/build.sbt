name := "SparkScalaTutorial2"

version := "1.0"

scalaVersion := "2.10.6"

resolvers += "DefaultMavenRepository" at "https://repo1.maven.org/maven2"

libraryDependencies ++= {
  val sparkVer = "2.1.1"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVer % "provided" withSources()
  )
}



