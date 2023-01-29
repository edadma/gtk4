package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

implicit class Window(val ptr: lib.GtkWindow) extends AnyVal with WidgetTrait:
  def setTitle(title: String): Window =
    Zone(implicit z => lib.gtk_window_set_title(ptr, toCString(title)))
    this

  def setDefaultSize(width: Int, height: Int): Window =
    lib.gtk_window_set_default_size(ptr, width, height)
    this
