package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

import scala.collection.mutable
import scala.scalanative.unsafe.Ptr

private val signalMap = new mutable.HashMap[Ptr[Byte], ((Application, String) => Unit, String)]

private def signalCallback(ptr: lib.GtkApplication_p, serial: Ptr[Byte]): Unit =
  val (cb, signal) = signalMap(serial)

  cb(ptr, signal)

implicit class Application(val application_ptr: lib.GtkApplication_p) extends AnyVal:
  def windowNew: Window = lib.gtk_application_window_new(application_ptr)
