package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

trait GObjectTrait extends Any:
  val ptr: lib.gpointer

  def signalConnect(signal: String, callback: SignalCallback): Long =
    val serial = signalSerialNext

    signalMap(serial) = (callback, signal)
    Zone(implicit z => lib.g_signal_connect_data(ptr, toCString(signal), signalCallback, serial, null, 0))

trait WidgetTrait extends Any:
  val ptr: lib.GtkWidget_p

  def setVisible(visible: Boolean): Unit = lib.gtk_widget_set_visible(ptr, bool(visible))

implicit class Window(val ptr: lib.GtkWidget_p /*GtkWindow_p*/ ) extends AnyVal with WidgetTrait:
  def setTitle(title: String): Unit = Zone(implicit z => lib.gtk_window_set_title(ptr, toCString(title)))
  def setDefaultSize(width: Int, height: Int): Unit = lib.gtk_window_set_default_size(ptr, width, height)
