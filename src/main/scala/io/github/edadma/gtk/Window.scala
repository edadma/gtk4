package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Window(val ptr: lib.GtkWindow_p) extends AnyVal
