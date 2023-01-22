package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Application(val application_ptr: lib.GtkApplication_p) extends AnyVal:
  def applicationWindowNew: Window = lib.gtk_application_window_new(application_ptr)
