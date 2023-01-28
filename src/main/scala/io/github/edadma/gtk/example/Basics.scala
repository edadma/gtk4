package io.github.edadma.gtk.example

import io.github.edadma.gtk

@main def Basics(): Unit =
  val app = gtk.applicationNew("io.github.edadma.gtk", gtk.ApplicationFlags.DEFAULT_FLAGS)

  app.activate(app =>
    val window = app.windowNew

    window.setTitle("Window")
    window.setDefaultSize(200, 200)
    window.setVisible(true),
  )
  app.run
