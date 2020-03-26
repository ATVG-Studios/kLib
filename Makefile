GRADLE="./gradlew"
KTLINT="./ktlint"

all: lint compile package doc

compile:
	$(GRADLE) build

package:
	$(GRADLE) shadowJar
	$(GRADLE) jar
	$(GRADLE) sourcesJar

lint:
	$(GRADLE) $(GRAARG) lintKotlin

format:
	$(GRADLE) $(GRAARG) formatKotlin

test:
	$(GRADLE) test

doc:
	$(GRADLE) dokka

code-version:
	find src/main/kotlin -name "*.kt" -type f -exec sed -i 's/<NEXT_VERSION>/$(VERSION)/g' {} \;
	sed -i 's/<NEXT_VERSION>/$(VERSION)/g' build.gradle Compatibility.md maven/**
