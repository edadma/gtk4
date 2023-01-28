package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

trait WidgetMixin extends Any:
  val ptr: lib.GtkWidget_p

  def setVisible(visible: Boolean): Unit = lib.gtk_widget_set_visible(ptr, bool(visible))
//  def signalConnect(signal: String, callback: WidgetMixin => Unit): Long =

implicit class Window(val ptr: lib.GtkWidget_p /*GtkWindow_p*/ ) extends AnyVal with WidgetMixin:
  def setTitle(title: String): Unit = Zone(implicit z => lib.gtk_window_set_title(ptr, toCString(title)))
  def setDefaultSize(width: Int, height: Int): Unit = lib.gtk_window_set_default_size(ptr, width, height)
