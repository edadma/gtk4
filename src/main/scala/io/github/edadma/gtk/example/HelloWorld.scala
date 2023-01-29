package io.github.edadma.gtk.example

import io.github.edadma.gtk

// direct translation of the "Hello, World": https://docs.gtk.org/gtk4/getting_started.html#hello-world
@main def HelloWorld(): Unit =
  def activate(app: gtk.Application): Unit =
    val window = app.windowNew
    val button = gtk.buttonNewWithLabel("Hello World")

    button.clicked(_ => window.close())
    window.setChild(button)
    window.present()

  val app = gtk.applicationNew("io.github.edadma.gtk.example", gtk.ApplicationFlags.DEFAULT_FLAGS)

  app.activate(activate)
  app.run

// more concise version
@main def HelloWorld2(): Unit =
  gtk
    .applicationNew("io.github.edadma.gtk.example", gtk.ApplicationFlags.DEFAULT_FLAGS)
    .activate(app =>
      val window = app.windowNew

      window
        .setChild(gtk.buttonNewWithLabel("Hello, World!").clicked(_ => window.close()))
        .present(),
    )
    .run
