credentials += Credentials(Path.userHome / ".sbt" / "sonatype_central_credentials")

ThisBuild / organization         := "io.github.charpov"
ThisBuild / organizationName     := "charpov"
ThisBuild / organizationHomepage := Some(url("https://github.com/charpov"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/charpov/TinyScalaUtilsJava"),
    "scm:git@github.com:charpov/TinyScalaUtilsJava.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "charpov",
    name = "Michel Charpentier",
    email = "Michel.Charpentier@unh.edu",
    url = url("https://github.com/charpov")
  )
)

ThisBuild / description     := "Java bridges for the TinyScalaUtils library."
ThisBuild / licenses        := Seq(License.Apache2)
ThisBuild / homepage        := Some(url("https://github.com/charpov/TinyScalaUtilsJava"))
ThisBuild / apiURL          := Some(url("https://charpov.github.io/TinyScalaUtilsJava/"))
ThisBuild / releaseNotesURL := Some(url("https://github.com/charpov/TinyScalaUtilsJava/releases"))

ThisBuild / versionScheme        := Some("semver-spec")
ThisBuild / publishMavenStyle    := true
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo            := localStaging.value
