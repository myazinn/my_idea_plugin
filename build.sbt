lazy val intellijVersion = "251.26094.121"
lazy val scalaPluginVersion = "2025.1.801:Nightly"

ThisBuild / intellijPluginName := "my-idea-plugin"
ThisBuild / intellijBuild := intellijVersion

Global / intellijAttachSources := true

(Global / javacOptions) := Seq("--release", "17")

ThisBuild / scalacOptions ++= Seq("-Ytasty-reader")

lazy val root =
  Project("my-idea-plugin", file("."))
    .settings(
      name := "my-idea-plugin",
      scalaVersion := "2.13.18",
      version := s"2025.1.111",
      intellijPlugins := Seq(
        "com.intellij.java".toPlugin,
        s"org.intellij.scala:$scalaPluginVersion".toPlugin
      ),
    )
    .enablePlugins(SbtIdeaPlugin)

