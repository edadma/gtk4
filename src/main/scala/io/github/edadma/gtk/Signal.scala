package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

import scala.collection.mutable

import scala.scalanative.unsafe._
import scala.scalanative.runtime._

private[gtk] val signalMap = new mutable.HashMap[Ptr[Byte], ((Application, String) => Unit, String)]
private[gtk] var signalSerial: Long = 0

private[gtk] def signalSerialNext: Ptr[Byte] =
  signalSerial += 1
  fromRawPtr[Byte](Intrinsics.castLongToRawPtr(signalSerial))

private[gtk] def signalCallback(ptr: lib.GtkApplication_p, serial: Ptr[Byte]): Unit =
  val (cb, signal) = signalMap(serial)

  cb(ptr, signal)
