GRADLE="./gradlew"
KTLINT="./ktlint"

all: lint compile package docs

compile:
	$(GRADLE) build

package:
	$(GRADLE) shadowJar
	$(GRADLE) sourcesJar

lint:
	$(KTLINT) "src/main/**/*.kt" -F

test:
	$(GRADLE) test

docs:
	$(GRADLE) dokka
