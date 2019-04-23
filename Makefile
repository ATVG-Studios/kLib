GRADLE="./gradlew"
KTLINT="./ktlint"

all: lint compile package docs

compile:
	$(GRADLE) build

package:
	$(GRADLE) shadowJar

lint:
	$(KTLINT) "src/main/**/*.kt"

docs:
	$(GRADLE) dokka
