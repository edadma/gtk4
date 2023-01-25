import io.github.edadma.gtk

@main def run(): Unit =
  val app = gtk.applicationNew("test", gtk.ApplicationFlags.DEFAULT_FLAGS)

def activate(app: gtk.Application): Unit =
  val window = app.windowNew

  window.setTitle("Window")
  window.setDefaultSize(200, 200)
  window.setVisible(true)
