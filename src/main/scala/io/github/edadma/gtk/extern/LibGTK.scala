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
  type GtkApplication = CStruct0
  type GtkApplication_p = Ptr[GtkApplication]
  type GtkWidget = CStruct0
  type GtkWidget_p = Ptr[GtkWidget]
