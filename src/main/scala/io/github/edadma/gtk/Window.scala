package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Window(val ptr: lib.GtkWidget_p /*GtkWindow_p*/ ) extends AnyVal with WidgetTrait:
  def setTitle(title: String): Unit = Zone(implicit z => lib.gtk_window_set_title(ptr, toCString(title)))
  def setDefaultSize(width: Int, height: Int): Unit = lib.gtk_window_set_default_size(ptr, width, height)
