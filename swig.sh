#!/usr/bin/env bash

pushd ./

rm -r swig_out || true
mkdir swig_out

rm FooWrap.*

headers="./"
wrapperfile="FooWrap.cc"
outdir="./swig_out"
package="com.zhen.foo"

install/bin/swig -debug-tmsearch -debug-tmused -macroerrors -v -c++ -java -package $package -outdir "$outdir" -o $wrapperfile -I"$headers" foo.i 2> ./warn.log

popd

mkdir -p com/zhen/foo
mv swig_out/*.java com/zhen/foo
rm -r swig_out

# Test java compilation
outLog="javcomp.log"
javac FooTest.java com/zhen/foo/*.java 2> "$outLog"
java -Djava.library.path=./cmake-build-debug RuntimeTest