// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val scalaVersions = Seq("2.12.2")
lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-template",
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-XX:MaxPermSize=256m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns),
    crossScalaVersions := scalaVersions
  )

ThisBuild / githubWorkflowJavaVersions := Seq("adopt@1.8.0-275", "adopt@1.11.0-9", "adopt@1.15.0-1")
ThisBuild / githubWorkflowScalaVersions := scalaVersions
ThisBuild / githubWorkflowBuildPostamble := Seq(
  // This runs the template with the default parameters, and runs test within the templated app.
  WorkflowStep.Run(List("sbt -Dfile.encoding=UTF8 -J-XX:ReservedCodeCacheSize=256M test")),

  WorkflowStep.Run(List("pushd target/sbt-test/dotty-template/scripted && sbt run test && popd")),
)
ThisBuild / githubWorkflowPublishTargetBranches := Nil
Global / onChangedBuildSource := ReloadOnSourceChanges