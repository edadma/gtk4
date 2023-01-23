package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

enum ApplicationFlags(bit: Int):
  case IS_SERVICE extends ApplicationFlags(1 << 0)
  case IS_SERVICE extends ApplicationFlags(1 << 0)

def applicationNew(application_id: String, flags: Int): Application = extern
