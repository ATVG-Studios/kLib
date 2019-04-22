GRADLE="./gradlew"

all: compile package

compile:
	$(GRADLE) build

package:
	$(GRADLE) shadowJar
