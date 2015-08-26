#!/usr/bin/env sh

# Implementation to use for building base
DIR=$(dirname $(readlink -f $0))
BASE_IMPL=$DIR/awt
BASE_CLASS=com.jtsymon.exptest.impl.Browser

compile() {
    (
    $LOG
    make CLASSPATH=$CLASSPATH -f $DIR/build.Makefile -C $1
    )
}

run() {
    compile $1
    (
    $LOG
    java -cp $CLASSPATH $BASE_CLASS
    )
}

unset LOG
if [ a$DEBUG == a1 ]; then
    LOG="set -vx"
fi

CLASSPATH=$DIR/base:$CLASSPATH
for target in "$@"; do
    case $target in
        "base")
            (
            CLASSPATH=$BASE_IMPL:$CLASSPATH
            compile $target
            )
            ;;
        "clean")
            echo 'Removing class files...'
            find $DIR -iname '*.class' -print -delete
            ;;
        run:*)
            (
            target=${target:4}
            CLASSPATH=$DIR/$target:$CLASSPATH
            run $target
            )
            ;;
        *)
            (
            CLASSPATH=$DIR/$target:$CLASSPATH
            compile $target
            )
            ;;
    esac
done
