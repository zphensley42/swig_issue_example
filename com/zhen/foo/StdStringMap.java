/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.zhen.foo;

public class StdStringMap extends java.util.AbstractMap<String, String> {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected StdStringMap(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(StdStringMap obj) {
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
        FooModuleJNI.delete_StdStringMap(swigCPtr);
      }
      swigCPtr = 0;
    }
  }


  public int size() {
    return sizeImpl();
  }

  public boolean containsKey(java.lang.Object key) {
    if (!(key instanceof String)) {
      return false;
    }

    return containsImpl((String)key);
  }

  public String get(java.lang.Object key) {
    if (!(key instanceof String)) {
      return null;
    }

    Iterator itr = find((String) key);
    if (itr.isNot(end())) {
      return itr.getValue();
    }

    return null;
  }

  public String put(String key, String value) {
    Iterator itr = find((String) key);
    if (itr.isNot(end())) {
      String oldValue = itr.getValue();
      itr.setValue(value);
      return oldValue;
    } else {
      putUnchecked(key, value);
      return null;
    }
  }

  public String remove(java.lang.Object key) {
    if (!(key instanceof String)) {
      return null;
    }

    Iterator itr = find((String) key);
    if (itr.isNot(end())) {
      String oldValue = itr.getValue();
      removeUnchecked(itr);
      return oldValue;
    } else {
      return null;
    }
  }

  public java.util.Set<Entry<String, String>> entrySet() {
    java.util.Set<Entry<String, String>> setToReturn =
        new java.util.HashSet<Entry<String, String>>();

    Iterator itr = begin();
    final Iterator end = end();
    while (itr.isNot(end)) {
      setToReturn.add(new Entry<String, String>() {
        private Iterator iterator;

        private Entry<String, String> init(Iterator iterator) {
          this.iterator = iterator;
          return this;
        }

        public String getKey() {
          return iterator.getKey();
        }

        public String getValue() {
          return iterator.getValue();
        }

        public String setValue(String newValue) {
          String oldValue = iterator.getValue();
          iterator.setValue(newValue);
          return oldValue;
        }
      }.init(itr));
      itr = itr.getNextUnchecked();
    }

    return setToReturn;
  }

  public StdStringMap() {
    this(FooModuleJNI.new_StdStringMap__SWIG_0(), true);
  }

  public StdStringMap(StdStringMap other) {
    this(FooModuleJNI.new_StdStringMap__SWIG_1(StdStringMap.getCPtr(other), other), true);
  }

  static protected class Iterator {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;
  
    protected Iterator(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(Iterator obj) {
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
          FooModuleJNI.delete_StdStringMap_Iterator(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    private StdStringMap.Iterator getNextUnchecked() {
      return new StdStringMap.Iterator(FooModuleJNI.StdStringMap_Iterator_getNextUnchecked(swigCPtr, this), true);
    }
  
    private boolean isNot(StdStringMap.Iterator other) {
      return FooModuleJNI.StdStringMap_Iterator_isNot(swigCPtr, this, StdStringMap.Iterator.getCPtr(other), other);
    }
  
    private String getKey() {
      return FooModuleJNI.StdStringMap_Iterator_getKey(swigCPtr, this);
    }
  
    private String getValue() {
      return FooModuleJNI.StdStringMap_Iterator_getValue(swigCPtr, this);
    }
  
    private void setValue(String newValue) {
      FooModuleJNI.StdStringMap_Iterator_setValue(swigCPtr, this, newValue);
    }
  
  }

  public boolean isEmpty() {
    return FooModuleJNI.StdStringMap_isEmpty(swigCPtr, this);
  }

  public void clear() {
    FooModuleJNI.StdStringMap_clear(swigCPtr, this);
  }

  private StdStringMap.Iterator find(String key) {
    return new StdStringMap.Iterator(FooModuleJNI.StdStringMap_find(swigCPtr, this, key), true);
  }

  private StdStringMap.Iterator begin() {
    return new StdStringMap.Iterator(FooModuleJNI.StdStringMap_begin(swigCPtr, this), true);
  }

  private StdStringMap.Iterator end() {
    return new StdStringMap.Iterator(FooModuleJNI.StdStringMap_end(swigCPtr, this), true);
  }

  private int sizeImpl() {
    return FooModuleJNI.StdStringMap_sizeImpl(swigCPtr, this);
  }

  private boolean containsImpl(String key) {
    return FooModuleJNI.StdStringMap_containsImpl(swigCPtr, this, key);
  }

  private void putUnchecked(String key, String value) {
    FooModuleJNI.StdStringMap_putUnchecked(swigCPtr, this, key, value);
  }

  private void removeUnchecked(StdStringMap.Iterator itr) {
    FooModuleJNI.StdStringMap_removeUnchecked(swigCPtr, this, StdStringMap.Iterator.getCPtr(itr), itr);
  }

}