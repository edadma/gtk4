package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

trait WidgetTrait extends Any with GObjectTrait:
  val ptr: lib.GtkWidget_p

  def setVisible(visible: Boolean): Unit = lib.gtk_widget_set_visible(ptr, bool(visible))

implicit class Widget(val ptr: lib.GtkWidget_p) extends AnyVal with WidgetTrait
