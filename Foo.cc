#include "Foo.h"
#include <iostream>

void Foo::useType(const StringType type) {
    std::cout << "Foo useType: " << type.get() << std::endl;
}

void Bar::useType(const NoWrapStringType type) {
    std::cout << "Bar useType: " << type.get() << std::endl;
}

void Baz::noWrapMapIn(std::map<NoWrapStringType, NoWrapStringType> in) {

}

std::map<NoWrapStringType, NoWrapStringType> Baz::noWrapMap() {
    return std::map<NoWrapStringType, NoWrapStringType>();
}
