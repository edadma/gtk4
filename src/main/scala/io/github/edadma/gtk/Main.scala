import io.github.edadma.gtk

@main def run(): Unit =
  val app = gtk.applicationNew("test", gtk.ApplicationFlags.DEFAULT_FLAGS)

