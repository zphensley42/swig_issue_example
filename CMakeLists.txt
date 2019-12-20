cmake_minimum_required(VERSION 3.13)
project(swig_deprec)

set(CMAKE_CXX_STANDARD 11)

find_package(JNI REQUIRED)

add_library(foo SHARED Foo.cc FooWrap.cc)
target_include_directories(foo PUBLIC ${JNI_INCLUDE_DIRS})
target_link_libraries(foo PUBLIC ${JNI_LIBRARIES})

add_executable(foo_main main.cpp)
target_link_libraries(foo_main PUBLIC foo)