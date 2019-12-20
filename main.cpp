#include <iostream>
#include "Foo.h"

int main() {
    Foo f;
    Bar b;
    Baz z;

    auto t1 = StringType("string data 1");
    auto t2 = StringType("string data 2");
    auto t3 = StringType("string data 3");
    f.useType(t1);
    b.useType(t2);
    z.useType(t3);

    return 0;
}