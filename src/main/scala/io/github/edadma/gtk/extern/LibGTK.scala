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
//  type GtkWidget = CStruct0
//  type GtkWidget_p = Ptr[GtkWidget]

  // gtkapplicationwindow.h

  type GtkWindow = CStruct0
  type GtkWindow_p = Ptr[GtkWindow]

  def gtk_application_window_new(application: GtkApplication_p): GtkWindow_p = extern

  // gtkwindow.h

  def gtk_window_set_title(window: GtkWindow_p, title: CString): Unit = extern

  // gtkapplication.h

  type GtkApplication = CStruct0
  type GtkApplication_p = Ptr[GtkApplication]

  def gtk_application_new(application_id: CString, flags: CInt): GtkApplication_p = extern

  // gapplication.h

  type GApplication = GtkApplication
  type GApplication_p = GtkApplication_p

  def g_application_run(application: GApplication_p, argc: CInt, argv: Ptr[CString]): CInt = extern
