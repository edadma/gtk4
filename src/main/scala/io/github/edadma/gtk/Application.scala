package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Application(val ptr: lib.GtkApplication_p) extends AnyVal
