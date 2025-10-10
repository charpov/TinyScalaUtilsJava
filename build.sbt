ThisBuild / version      := "1.9.0"
ThisBuild / scalaVersion := "3.3.7"

val JSpecify = "org.jspecify"      % "jspecify"      % "1.0.0"
val JUnit    = "org.junit.jupiter" % "junit-jupiter" % "6.0.0"

ThisBuild / crossPaths            := false
ThisBuild / transitiveClassifiers := Seq("sources")

ThisBuild / Test / fork                 := true
ThisBuild / Test / parallelExecution    := false
ThisBuild / Test / run / outputStrategy := Some(StdoutOutput)

ThisBuild / javacOptions := Seq("-Xlint:all", "--release", "17")

ThisBuild / scalacOptions := Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-feature",     // Emit warning for usages of features that should be imported explicitly.
  "-unchecked",   // Enable detailed unchecked (erasure) warnings.
  "-language:noAutoTupling", // no auto-tupling
  "-Wunused:linted",         // unused stuff
  "-java-output-version:17", // Target Java 17, which is needed anyway
  "-source:future",          // source version.
)

lazy val tinyscalautilsjava = (project in file(".")).settings(
  name := "Tiny-Scala-Utils-Java",
  libraryDependencies ++= Seq(
    JSpecify,
    JUnit                  % Test,
    "io.github.charpov"   %% "tiny-scala-utils"  % version.value,
    "com.github.sbt.junit" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test,
  ),
)
