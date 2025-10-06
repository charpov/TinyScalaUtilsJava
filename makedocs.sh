#!/usr/bin/env zsh

javadoc @<(sbt --batch --error docoptions) \
  -Xdoclint:none \
  -sourcepath src/main/java \
  -d docs \
  -doctitle "TinyScalaUtils (Java bridges)" \
  -link https://jspecify.dev/docs/api/ \
  tinyscalautils.java
