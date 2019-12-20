/**
  * Special typemaps to handle Scalar classes as primitive in applicable cases.
  */

// Disable directors for Scalars
%feature("nodirector") Scalar;

// StringType
%typemap(jni) Scalar<std::string>, const Scalar<std::string> "jstring"
%typemap(jtype) Scalar<std::string>, const Scalar<std::string> "String"
%typemap(jstype) Scalar<std::string>, const Scalar<std::string> "String"
%typemap(javain) Scalar<std::string>, const Scalar<std::string> "/*javain*/ $javainput"
%typemap(javaout) Scalar<std::string>, const Scalar<std::string> {
  // javaout
  return $jnicall;
}
%typemap(in) const Scalar<std::string> *, const Scalar<std::string> &
%{  // in
    // Our input is a long ptr to the Scalar<std::string> object, not a jstring
    $1 = *(Scalar<std::string> **)&$input;
    if (!$1) {
      SWIG_JavaThrowException(jenv, SWIG_JavaNullPointerException, "StringType const & reference is null");
      return $null;
    } %}
%typemap(out) Scalar<std::string>, const Scalar<std::string>
%{  // out
    std::string $1_str = $1.isNull() ? "" : $1.get();
    jbyteArray dataBytes = jenv->NewByteArray((jsize) $1_str.length());
    jenv->SetByteArrayRegion(dataBytes, 0, (jsize) $1_str.length(), (jbyte *) $1_str.c_str());

    jclass strClazz = jenv->FindClass("java/lang/String");
    jmethodID strClazzInit = jenv->GetMethodID(strClazz, "<init>", "([B)V");
    jobject newObj = jenv->NewObject(strClazz, strClazzInit, dataBytes);
    $result = static_cast<jstring>(newObj);
    jenv->DeleteLocalRef(dataBytes);
%}
%typemap(directorin,descriptor="Ljava/lang/String;") Scalar<std::string>, const Scalar<std::string>
%{  // director in
    std::string $1_str = $1.isNull() ? "" : $1.get();
    jbyteArray dataBytes = jenv->NewByteArray((jsize) $1_str.length());
    jenv->SetByteArrayRegion(dataBytes, 0, (jsize) $1_str.length(), (jbyte *) $1_str.c_str());

    jclass strClazz = jenv->FindClass("java/lang/String");
    jmethodID strClazzInit = jenv->GetMethodID(strClazz, "<init>", "([B)V");
    jobject newObj = jenv->NewObject(strClazz, strClazzInit, dataBytes);
    $input = static_cast<jstring>(newObj);
    jenv->DeleteLocalRef(dataBytes);
    Swig::LocalRefGuard $1_refguard(jenv, $input);
%}

%typemap(jboxtype) Scalar<std::string> "NoWrapStringType"

%include "Foo.h"


%template(WrapStringType) Scalar<std::string>;

%template(NoWrapMap) std::map<NoWrapStringType, NoWrapStringType, std::less<NoWrapStringType>>;
%template(StdStringMap) std::map<std::string, std::string>;
%template(BarMap) std::map<Bar, Bar>;