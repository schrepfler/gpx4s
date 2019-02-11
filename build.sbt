// *****************************************************************************
// Projects
// *****************************************************************************

lazy val gpx4s =
  project
    .in(file("."))
    .enablePlugins(AutomateHeaderPlugin)
    .enablePlugins(ScalaxbPlugin)
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        library.alpakkaXml,
        library.caseApp,
        library.scalaXml,
        library.scalaParserCombinators,
        library.scalaCheck % Test,
        library.scalaTest % Test,
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {

    object Version {
      val scalaCheck = "1.14.0"
      val scalaTest = "3.0.5"
      val alpakkaXml = "1.0-M2"
      val caseApp = "2.0.0-M3"
      val scalaXml = "1.1.1"
      val scalaParserCombinators = "1.1.1"
    }

    val scalaCheck = "org.scalacheck" %% "scalacheck" % Version.scalaCheck
    val scalaTest = "org.scalatest" %% "scalatest" % Version.scalaTest
    val alpakkaXml = "com.lightbend.akka" %% "akka-stream-alpakka-xml" % Version.alpakkaXml
    val caseApp = "com.github.alexarchambault" %% "case-app" % Version.caseApp
    val scalaXml = "org.scala-lang.modules" %% "scala-xml" % Version.scalaXml
    val scalaParserCombinators = "org.scala-lang.modules" % "scala-parser-combinators_2.12" % Version.scalaParserCombinators
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings =
  commonSettings ++
    scalafmtSettings ++
    scalaXmSettings

lazy val commonSettings =
  Seq(
    // scalaVersion from .travis.yml via sbt-travisci
    // scalaVersion := "2.12.8",
    organization := "Kimeru",
    organizationName := "Srdan Srepfler",
    startYear := Some(2019),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8",
      "-Ypartial-unification",
      "-Ywarn-unused-import",
    ),
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
    Compile / compile / wartremoverWarnings ++= Warts.unsafe,
  )

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true,
  )

lazy val scalaXmSettings =
  Seq(
    scalaxbPackageName in (Compile, scalaxb)     := "io.kimeru.gpx4s"
  )
