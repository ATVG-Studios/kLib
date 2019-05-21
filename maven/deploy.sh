#!/bin/bash
VERSION="1.3.0"

mvn gpg:sign-and-deploy-file \
	-DrepositoryId=atvg-studios \
	-Durl=file:///data/atjontv/git/maven-repo \
	-DgroupId=com.atvgstudios \
	-DartifactId=klib \
	-Dversion=$VERSION \
	-Dpackaging=jar \
	-Dsources=build/libs/klib-$VERSION-sources.jar \
	-Dfile=build/libs/klib-$VERSION.jar \
	-DpomFile=maven/pom.xml
