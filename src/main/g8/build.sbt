val scala3Version = "3.4.2"
val scalac3Options = Seq(
  "-deprecation",
  "-explain",
  "-explain-types",
  "-indent",
  "-language:existentials",
  "-language:higherKinds",
  "-new-syntax",
  "-print-lines",
  "-source:future",
  "-unchecked",
  // "-rewrite",
  "-Wnonunit-statement",
  "-Wunused:all",
  "-Wvalue-discard",
  "-Ysafe-init"
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "$name$",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,
    scalacOptions ++= scalac3Options,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
