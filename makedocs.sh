#!/usr/bin/env zsh

[[ -z $1 ]] && printf "missing classpath\n" 1>&2 && exit 1

exec javadoc \
  -classpath "$1" \
  -Xdoclint:none \
  -sourcepath src/main/java \
  -d docs \
  -doctitle "TinyScalaUtils (Java bridges)" \
  -link https://jspecify.dev/docs/api/ \
  tinyscalautils.java 2>&1
