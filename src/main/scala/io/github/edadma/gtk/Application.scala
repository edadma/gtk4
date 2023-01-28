package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

import scala.collection.mutable
import scala.scalanative.unsafe.Ptr

implicit class Application(val ptr: lib.gpointer) extends AnyVal with GObjectTrait:
  def windowNew: Window = lib.gtk_application_window_new(ptr)

  def activate(callback: Application => Unit): Long = super.signalConnect("activate", ptr => callback(ptr))

  def run: Int =
    val status = lib.g_application_run(ptr, 0, null)

    lib.g_object_unref(ptr)
    status
