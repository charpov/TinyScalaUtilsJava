import scala.sys.process._

This / Compile / doc := {
   val classpath = Attributed.data((Compile / fullClasspath).value).mkString(":")
   val script = (baseDirectory.value / "makedocs.sh").toString
   Seq("zsh", script, classpath) ! streams.value.log
   baseDirectory.value / "docs"
}
