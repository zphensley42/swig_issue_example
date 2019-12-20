#!/usr/bin/env bash

FORCE_INSTALL=false
REMOVE_OLD=false

scriptdir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo "Installing to $scriptdir/install"


function installDeps() {
    if [ "$(uname)" == "Darwin" ]; then
        brew install autoconf
        brew install automake
        brew install bison
        brew install pcre
    elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
        sudo apt-get install build-essential libpcre3-dev
        sudo apt-get install autoconf automake libtool bison subversion git
        sudo apt-get install libboost-dev
    fi
}

POSITIONAL=()
while [[ $# -gt 0 ]]; do
key="$1"

case $key in
    -f|--force)
    FORCE_INSTALL=true
    shift # past argument
    ;;
    -r|--removeold)
    REMOVE_OLD=true
    shift # past argument
    ;;
    -h|--help)
    echo "Usage: install_swig.sh [-f|--force] [-r|--removeold] [-h|--help]"
    exit 0
    ;;
    *)    # unknown option
    shift # past argument
    ;;
esac
done

case "$(uname -s)" in

    CYGWIN*|MINGW*|MSYS*)
        echo 'MS Windows detected - swig install skipped - using system Swig 4.0'
        ;;

    *)
        echo 'Linux or Mac OS'


        if [[ "$REMOVE_OLD" = true ]]; then
            rm -r "$scriptdir/install"
        fi

        # Initial checks
        if [ -f "$scriptdir/install/bin/swig" ] && [[ "$FORCE_INSTALL" = false ]]; then
            echo "SWIG already installed -- doing nothing"
        else
            echo "Installing SWIG from submodule"

            mkdir -p "$scriptdir/install"
            cd "$scriptdir/gitswig"

            # Dependencies
            installDeps

            ./autogen.sh
            ./configure --prefix="$scriptdir/install"
            make
            make install
        fi
    ;;
esac