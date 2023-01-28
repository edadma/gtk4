package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

trait GObjectTrait extends Any:
  val ptr: lib.gpointer

  def signalConnect(signal: String, callback: SignalCallback): Long =
    val serial = signalSerialNext

    signalMap(serial) = (callback, signal)
    Zone(implicit z =>
      lib.g_signal_connect_data(
        ptr,
        toCString(signal),
        signalCallback,
        serial,
        null,
        0,
      ),
    ).toLong

implicit class GObject(val ptr: lib.gpointer) extends AnyVal with GObjectTrait
