organization := "com.example"

name := "session"

version := "0.1.0-SNAPSHOT"

libraryDependencies ++= Seq(
   "net.databinder" %% "unfiltered-filter" % "0.5.3",
   "net.databinder" %% "unfiltered-scalatest" % "0.5.3",
   "javax.servlet" % "servlet-api" % "2.3" % "provided",
   "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container",
   "org.clapper" %% "avsl" % "0.3.6",
   "org.scalatest" % "scalatest_2.9.1" % "1.6.1" % "test",
   "net.databinder" %% "dispatch-http" % "0.8.7" % "test"
)

seq(webSettings :_*)
