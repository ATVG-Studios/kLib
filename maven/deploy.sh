#!/bin/bash

VERSION="4.1.0-dev.3"

ATVG_DIST="file:///data/atjontv/git/maven-repo"

DIST="$ATVG_DIST"
REPO="atvg-studios"

if [ "$1" = "-dev" ]
then
  DIST="$ATVG_DIST/snapshots"
fi

mvn gpg:sign-and-deploy-file \
	-DrepositoryId=$REPO \
	-Durl=$DIST \
	-DgroupId=com.atvgstudios \
	-DartifactId=klib \
	-Dversion=$VERSION \
	-Dpackaging=jar \
	-Dsources=build/libs/klib-$VERSION-sources.jar \
	-Dfile=build/libs/klib-$VERSION.jar \
	-DpomFile=maven/pom.xml
