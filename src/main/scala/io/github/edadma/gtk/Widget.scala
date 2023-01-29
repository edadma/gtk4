package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

trait WidgetTrait extends Any with GObjectTrait:
  val ptr: lib.GtkWidget

  def setVisible(visible: Boolean): WidgetTrait =
    lib.gtk_widget_set_visible(ptr, bool(visible))
    this

implicit class Widget(val ptr: lib.GtkWidget) extends AnyVal with WidgetTrait:
  def clicked(callback: Widget => Unit): Widget =
    super.signalConnect("clicked", ptr => callback(ptr))
    this
