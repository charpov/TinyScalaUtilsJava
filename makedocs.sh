#!/usr/bin/env zsh

exec javadoc @<(sbt --batch --error docoptions) \
  -Xdoclint:none \
  -sourcepath src/main/java \
  -d docs \
  -doctitle "TinyScalaUtils (Java bridges)" \
  -link https://jspecify.dev/docs/api/ \
  tinyscalautils.java 2>&1
