package io.github.edadma.gtk.extern

import scala.scalanative.unsafe._

@link("gtk-4")
@link("pangocairo-1.0")
@link("pango-1.0")
@link("harfbuzz")
@link("gdk_pixbuf-2.0")
@link("cairo-gobject")
@link("cairo")
@link("graphene-1.0")
@link("gio-2.0")
@link("gobject-2.0")
@link("glib-2.0")
@extern
object LibGTK:
  type gpointer = Ptr[Byte]

  // Gtk Widget

  type GtkWidget = gpointer

  def gtk_widget_set_visible(widget: GtkWidget, visible: CInt): Unit = extern

  // gtkapplicationwindow.h

  type GtkWindow = gpointer

  def gtk_application_window_new(application: GtkApplication): GtkWindow = extern

  // gtkwindow.h

  def gtk_window_set_title(window: GtkWindow, title: CString): Unit = extern
  def gtk_window_set_default_size(window: GtkWindow, width: CInt, height: CInt): Unit = extern

  // gtkapplication.h

  type GtkApplication = gpointer

  def gtk_application_new(application_id: CString, flags: CInt): GtkApplication = extern

  // gapplication.h

  type GApplication = gpointer

  def g_application_run(application: GApplication, argc: CInt, argv: Ptr[CString]): CInt = extern

  // gsignal.h

  type GCallback = CFuncPtr2[gpointer, gpointer, Unit]

  def g_signal_connect_data(
      instance: gpointer,
      detailed_signal: CString,
      c_handler: GCallback,
      data: gpointer,
      destroy_data: Ptr[Byte],
      connect_flags: CInt,
  ): CUnsignedLong = extern

  // gobject.h

  def g_object_unref(objec: gpointer): Unit = extern

  // gtkbutton.h

  def gtk_button_new_with_label(label: CString): GtkWidget = extern
