/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.zhen.foo;

public class Bar {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Bar(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Bar obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        FooModuleJNI.delete_Bar(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Bar() {
    this(FooModuleJNI.new_Bar(), true);
  }

  public void useType(String type) {
    FooModuleJNI.Bar_useType(swigCPtr, this, /*javain*/ type);
  }

}
