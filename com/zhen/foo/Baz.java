/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.zhen.foo;

public class Baz extends Foo {
  private transient long swigCPtr;

  protected Baz(long cPtr, boolean cMemoryOwn) {
    super(FooModuleJNI.Baz_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Baz obj) {
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
        FooModuleJNI.delete_Baz(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public Baz() {
    this(FooModuleJNI.new_Baz(), true);
  }

  public StdStringMap stdStringMap() {
    return new StdStringMap(FooModuleJNI.Baz_stdStringMap(swigCPtr, this), true);
  }

  public BarMap barMap() {
    return new BarMap(FooModuleJNI.Baz_barMap(swigCPtr, this), true);
  }

  public NoWrapMap noWrapMap() {
    return new NoWrapMap(FooModuleJNI.Baz_noWrapMap(swigCPtr, this), true);
  }

  public void noWrapMapIn(NoWrapMap in) {
    FooModuleJNI.Baz_noWrapMapIn(swigCPtr, this, NoWrapMap.getCPtr(in), in);
  }

}