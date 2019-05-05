GRADLE="./gradlew"
KTLINT="./ktlint"

all: lint compile package docs publish

compile:
	$(GRADLE) build

package:
	$(GRADLE) shadowJar

publish:
	$(GRADLE) publish

lint:
	$(KTLINT) "src/main/**/*.kt"

test:
	$(GRADLE) test

docs:
	$(GRADLE) dokka
