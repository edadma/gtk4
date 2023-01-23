package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Window(val window_ptr: lib.GtkWindow_p) extends AnyVal:
  def setTitle(title: String): Unit = Zone(implicit z => lib.gtk_window_set_title(window_ptr, toCString(title)))
  def setDefaultSize(width: Int, height: Int): Unit = lib.void gtk_window_set_default_size (window_ptr, width, height)
