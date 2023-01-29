package io.github.edadma.gtk.example

import io.github.edadma.gtk

// direct translation of "Hello, World": https://docs.gtk.org/gtk4/getting_started.html#hello-world
@main def HelloWorld(): Unit =
  def activate(app: gtk.Application): Unit =
    val window = app.windowNew

    window.setTitle("Window")
    window.setDefaultSize(200, 200)
    window.setVisible(true)

  val app = gtk.applicationNew("io.github.edadma.gtk.example", gtk.ApplicationFlags.DEFAULT_FLAGS)

  app.activate(activate)
  app.run
