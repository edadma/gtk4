package io.github.edadma.gtk

import io.github.edadma.gtk.extern.LibGTK as lib

import scala.collection.mutable

import scala.scalanative.unsafe._
import scala.scalanative.runtime._

type SignalCallback = lib.gpointer => Unit

private[gtk] val signalMap = new mutable.HashMap[Ptr[Byte], SignalCallback]
private[gtk] var signalSerial: Long = 0

private[gtk] def signalSerialNext: Ptr[Byte] =
  signalSerial += 1
  fromRawPtr[Byte](Intrinsics.castLongToRawPtr(signalSerial))

private[gtk] def signalCallback(ptr: lib.gpointer, serial: Ptr[Byte]): Unit = signalMap(serial)(ptr)
