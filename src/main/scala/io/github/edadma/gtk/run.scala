import io.github.edadma.gtk

@main def run(): Unit =
  val app = gtk.applicationNew("io.github.edadma.gtk", gtk.ApplicationFlags.DEFAULT_FLAGS)

  app.activate(activate)
  app.run

def activate(app: gtk.Application, signal: String): Unit =
  val window = app.windowNew

  window.setTitle("Window")
  window.setDefaultSize(200, 200)
  window.setVisible(true)
