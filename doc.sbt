lazy val docoptions = taskKey[Unit]("Prints java options (doc)")
ThisBuild / docoptions := {
   println(Attributed.data((Compile / fullClasspath).value).mkString("-classpath\n", ":", ""))
}

This / Compile / doc := {
   import scala.sys.process._
   val script = baseDirectory.value / "makedocs.sh"
   val out    = baseDirectory.value / "docs"
   s"zsh $script" ! streams.value.log
   out
}

//This / Compile / doc := baseDirectory.value / "docs"
