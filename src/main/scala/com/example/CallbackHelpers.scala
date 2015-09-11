package com.example

import org.lwjgl.glfw.{
  GLFWCharCallback,
  GLFWCharModsCallback,
  GLFWCursorEnterCallback,
  GLFWCursorPosCallback,
  GLFWDropCallback,
  GLFWErrorCallback,
  GLFWFramebufferSizeCallback,
  GLFWKeyCallback,
  GLFWMonitorCallback,
  GLFWMouseButtonCallback,
  GLFWScrollCallback,
  GLFWWindowCloseCallback,
  GLFWWindowFocusCallback,
  GLFWWindowIconifyCallback,
  GLFWWindowPosCallback,
  GLFWWindowRefreshCallback,
  GLFWWindowSizeCallback
}

object CallbackHelpers {
  import scala.language.implicitConversions

  /** Called when a Unicode character is input */
  implicit def f2CharCB(f: (Long, Int) => Unit)
  : GLFWCharCallback =
    new GLFWCharCallback() {
      override def invoke(window: Long, codePoint: Int)
      : Unit = f(window, codePoint)
    }

  /** Called when a Unicode character is input */
  implicit def f2CharModsCB(f: (Long, Int, Int) => Unit)
  : GLFWCharModsCallback =
    new GLFWCharModsCallback() {
      override def invoke(window: Long, codePoint: Int, mods: Int)
      : Unit = f(window, codePoint, mods)
    }

  /** Called when the cursor enters or leaves the client area of the window */
  implicit def f2CursorEnterCB(f: (Long, Int) => Unit)
  : GLFWCursorEnterCallback =
    new GLFWCursorEnterCallback() {
      override def invoke(window: Long, entered: Int)
      : Unit = f(window, entered)
    }

  /** Called when the cursor is moved. */
  implicit def f2CursorPosCB(f: (Long, Double, Double) => Unit)
  : GLFWCursorPosCallback =
    new GLFWCursorPosCallback() {
      override def invoke(window: Long, xPos: Double, yPos: Double)
      : Unit = f(window, xPos, yPos)
    }

  /** Called when one or more dragged files are dropped on the window. */
  implicit def f2DropCB(f: (Long, Int, Long) => Unit)
  : GLFWDropCallback =
    new GLFWDropCallback() {
      override def invoke(window: Long, count: Int, names: Long)
      : Unit = f(window, count, names)
    }

  /** Called with an error code and description when a GLFW error occurs. */
  implicit def f2ErrorCB(f: (Int, Long) => Unit)
  : GLFWErrorCallback =
    new GLFWErrorCallback() {
      override def invoke(error: Int, desc: Long)
      : Unit = f(error, desc)
    }

  /** Called when the framebuffer of the specified window is resized. */
  implicit def f2FramebufferSizeCB(f: (Long, Int, Int) => Unit)
  : GLFWFramebufferSizeCallback =
    new GLFWFramebufferSizeCallback() {
      override def invoke(window: Long, width: Int, height: Int)
      : Unit = f(window, width, height)
    }

  /** Called when a key is pressed repeated or released. */
  implicit def f2KeyCB(f: (Long, Int, Int, Int, Int) => Unit)
  : GLFWKeyCallback =
    new GLFWKeyCallback() {
      override def invoke (
        window: Long, key: Int, scanCode: Int, action: Int, mods: Int
      ): Unit = f(window, key, scanCode, action, mods)
    }

  /** Called when a monitor is connected to or disconnected from the system */
  implicit def f2MonitorCB(f: (Long, Int) => Unit)
  : GLFWMonitorCallback =
    new GLFWMonitorCallback() {
      override def invoke (monitor: Long, event: Int)
      : Unit = f(monitor, event)
    }

  /** Called when a mouse button is pressed or released */
  implicit def f2MouseButtonCB(f: (Long, Int, Int, Int) => Unit)
  : GLFWMouseButtonCallback =
    new GLFWMouseButtonCallback() {
      override def invoke (window: Long, button: Int, action: Int, mods: Int)
      : Unit = f(window, button, action, mods)
    }

  /** Called when a monitor is connected to or disconnected from the system */
  implicit def f2ScrollCB(f: (Long, Double, Double) => Unit)
  : GLFWScrollCallback =
    new GLFWScrollCallback() {
      override def invoke (window: Long, xOffset: Double, yOffset: Double)
      : Unit = f(window, xOffset, yOffset)
    }

  /** Called when the user attempts to close the specified window. */
  implicit def f2WindowCloseCB(f: (Long) => Unit)
  : GLFWWindowCloseCallback =
    new GLFWWindowCloseCallback() {
      override def invoke (window: Long)
      : Unit = f(window)
    }

  /** Called when the window gains/loses focus. */
  implicit def f2WindowFocusCB(f: (Long, Int) => Unit)
  : GLFWWindowFocusCallback =
    new GLFWWindowFocusCallback() {
      override def invoke (window: Long, focused: Int)
      : Unit = f(window, focused)
    }

  /** Called when the window is Un/Iconified. */
  implicit def f2WindowIconifyCB(f: (Long, Int) => Unit)
  : GLFWWindowIconifyCallback =
    new GLFWWindowIconifyCallback() {
      override def invoke (window: Long, iconified: Int)
      : Unit = f(window, iconified)
    }

  /** Called when the window moves. */
  implicit def f2WindowPosCB(f: (Long, Int, Int) => Unit)
  : GLFWWindowPosCallback =
    new GLFWWindowPosCallback() {
      override def invoke (window: Long, xPos: Int, yPos: Int)
      : Unit = f(window, xPos, yPos)
    }

  /** Called when the window needs to be redrawn. */
  implicit def f2WindowRefreshCB(f: (Long) => Unit)
  : GLFWWindowRefreshCallback =
    new GLFWWindowRefreshCallback() {
      override def invoke (window: Long)
      : Unit = f(window)
    }

  /** Called when the window is resized. */
  implicit def f2WindowSizeCB(f: (Long, Int, Int) => Unit)
  : GLFWWindowSizeCallback =
    new GLFWWindowSizeCallback() {
      override def invoke (window: Long, width: Int, height: Int)
      : Unit = f(window, width, height)
    }
}
