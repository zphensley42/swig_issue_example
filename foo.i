%module(directors="1") FooModule

%{
#include "Foo.h"
%}

// Include some default templating
%include "stdint.i"
%include "std_string.i"
%include "std_map.i"
%include "std_vector.i"
%include "scalar.i"

%javaconst(1);
