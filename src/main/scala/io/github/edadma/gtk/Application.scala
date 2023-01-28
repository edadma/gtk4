package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

import scala.collection.mutable
import scala.scalanative.unsafe.Ptr

implicit class Application(val ptr: lib.GtkApplication_p) extends AnyVal with GObjectTrait:
  def windowNew: Window = lib.gtk_application_window_new(ptr)

  def activate(callback: (Application, String) => Unit): Long =
    super.signalConnect("activate", (app: GObject, signal: String) => callback(app.ptr, signal))

  def run: Int =
    val status = lib.g_application_run(ptr, 0, null)

    lib.g_object_unref(ptr)
    status
