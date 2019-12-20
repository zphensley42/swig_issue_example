#ifndef SWIG_DEPREC_FOO_H
#define SWIG_DEPREC_FOO_H

#include <string>
#include <map>

template <typename T>
class Scalar {
public:
    Scalar<T>() = default;
    ~Scalar<T>() = default;
    explicit Scalar<T>(T data) : m_data{data} {}

    inline T get() const {
        return m_data;
    }

private:
    T m_data;
};

using StringType = Scalar<std::string>;
using NoWrapStringType = Scalar<std::string>;

class Foo {
public:
    Foo() = default;
    ~Foo() = default;

    void useType(StringType type);
};

class Bar {
public:
    Bar() = default;
    ~Bar() = default;

    void useType(NoWrapStringType type);
};

class Baz : public Foo {
public:
    Baz() = default;
    ~Baz() = default;

    std::map<std::string, std::string> stdStringMap();
    std::map<Bar, Bar> barMap();
    std::map<NoWrapStringType, NoWrapStringType> noWrapMap();
    void noWrapMapIn(std::map<NoWrapStringType, NoWrapStringType> in);
};


#endif //SWIG_DEPREC_FOO_H
