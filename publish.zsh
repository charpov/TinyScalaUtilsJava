#!/usr/bin/env zsh
set -Feu

cd ~/GIT/TinyScalaUtilsJava

./mill compile
./mill javadocGenerated
rm -rf docs
cp -r out/javadocGenerated.dest/javadoc ./docs

MILL_SONATYPE_PASSWORD=$(security find-generic-password -a $USER -s SONATYPE_TOKEN -w)
MILL_PGP_SECRET_BASE64=$(gpg --export-secret-key -a 2B188F132F28D5CE | base64)
export MILL_SONATYPE_USERNAME=V60etz
export MILL_PGP_PASSPHRASE=''
export MILL_SONATYPE_PASSWORD MILL_PGP_SECRET_BASE64

./mill mill.javalib.SonatypeCentralPublishModule/ --shouldRelease false
