package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Widget(val ptr: lib.GtkWidget_p) extends AnyVal
