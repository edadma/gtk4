package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Window(val window_ptr: lib.GtkWindow_p) extends AnyVal:
  def windowSetTitle(title: String): Unit = Zone(implicit z => lib.gtk_window_set_title(window_ptr, toCString(title)))
