package io.github.edadma.gtk

import scala.scalanative.unsafe._

import io.github.edadma.gtk.extern.LibGTK as lib

private[gtk] def bool(b: Boolean): CInt = if (b) 1 else 0

enum ApplicationFlags(val bit: Int):
  case DEFAULT_FLAGS extends ApplicationFlags(0)
  case IS_SERVICE extends ApplicationFlags(1 << 0)
  case IS_LAUNCHER extends ApplicationFlags(1 << 1)
  case HANDLES_OPEN extends ApplicationFlags(1 << 2)
  case HANDLES_COMMAND_LINE extends ApplicationFlags(1 << 3)
  case SEND_ENVIRONMENT extends ApplicationFlags(1 << 4)
  case NON_UNIQUE extends ApplicationFlags(1 << 5)
  case CAN_OVERRIDE_APP_ID extends ApplicationFlags(1 << 6)
  case ALLOW_REPLACEMENT extends ApplicationFlags(1 << 7)
  case REPLACE extends ApplicationFlags(1 << 8)

val G_CONNECT_DEFAULT: CInt = 0
val G_CONNECT_AFTER = 1 << 0
val G_CONNECT_SWAPPED = 1 << 1

def applicationNew(application_id: String, flags: ApplicationFlags): Application =
  Zone(implicit z => lib.gtk_application_new(toCString(application_id), flags.bit))

def buttonNewWithLabel(label: String): Widget = Zone(implicit z => lib.gtk_button_new_with_label(toCString(label)))
