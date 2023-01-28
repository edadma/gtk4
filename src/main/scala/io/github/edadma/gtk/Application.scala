package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

import scala.collection.mutable
import scala.scalanative.unsafe.Ptr

implicit class Application(val ptr: lib.GtkApplication_p) extends AnyVal with GObjectTrait:
  def windowNew: Window = lib.gtk_application_window_new(ptr)

  def activate(callback: (Application, String) => Unit): Long =
    super.signalConnect("activate", callback.asInstanceOf[SignalCallback])
