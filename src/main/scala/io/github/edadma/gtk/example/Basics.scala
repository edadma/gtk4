package io.github.edadma.gtk.example

import io.github.edadma.gtk

@main def Basics(): Unit =
  gtk
    .applicationNew("io.github.edadma.gtk", gtk.ApplicationFlags.DEFAULT_FLAGS)
    .activate(
      _.windowNew
        .setTitle("Window")
        .setDefaultSize(200, 200)
        .setVisible(true),
    )
    .run
