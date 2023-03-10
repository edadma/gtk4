package io.github.edadma.gtk.example

import io.github.edadma.gtk

// direct translation of "Basics": https://docs.gtk.org/gtk4/getting_started.html#basics
@main def Basics(): Unit =
  def activate(app: gtk.Application): Unit =
    val window = app.windowNew

    window.setTitle("Window")
    window.setDefaultSize(200, 200)
    window.setVisible(true)

  val app = gtk.applicationNew("io.github.edadma.gtk.example", gtk.ApplicationFlags.DEFAULT_FLAGS)

  app.activate(activate)
  app.run

// more concise version
@main def Basics2(): Unit =
  gtk
    .applicationNew("io.github.edadma.gtk.example", gtk.ApplicationFlags.DEFAULT_FLAGS)
    .activate(
      _.windowNew
        .setTitle("Window")
        .setDefaultSize(200, 200)
        .setVisible(true),
    )
    .run
