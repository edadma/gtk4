package io.github.edadma.gtk.example

import io.github.edadma.gtk

// direct translation of the GTK "Hello, World!" example: https://www.gtk.org/
@main def GtkHelloWorld(): Unit =
  def on_activate(app: gtk.Application): Unit =
    val window = app.windowNew
    val button = gtk.buttonNewWithLabel("Hello, World!")

    button.clicked(_ => window.close())
    window.setChild(button)
    window.present()

  val app = gtk.applicationNew("io.github.edadma.gtk.example", gtk.ApplicationFlags.DEFAULT_FLAGS)

  app.activate(on_activate)
  app.run

// more concise version
@main def GtkHelloWorld2(): Unit =
  gtk
    .applicationNew("io.github.edadma.gtk.example", gtk.ApplicationFlags.DEFAULT_FLAGS)
    .activate(app =>
      val window = app.windowNew

      window
        .setChild(gtk.buttonNewWithLabel("Hello, World!").clicked(_ => window.close()))
        .present(),
    )
    .run
