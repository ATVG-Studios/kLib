GRADLE="./gradlew"
GRAARG=
GRAVER="6.3"

all: lint compile package doc

compile:
	$(GRADLE) $(GRAARG) build

package:
	$(GRADLE) $(GRAARG) shadowJar
	$(GRADLE) $(GRAARG) jar
	$(GRADLE) $(GRAARG) sourcesJar

lint:
	$(GRADLE) $(GRAARG) lintKotlin

format:
	$(GRADLE) $(GRAARG) formatKotlin

test:
	$(GRADLE) $(GRAARG) test

doc:
	$(GRADLE) $(GRAARG) dokka

upgrade:
	$(GRADLE) wrapper --gradle-version $(GRAVER)

code-version:
	find src/main/kotlin -name "*.kt" -type f -exec sed -i 's/<NEXT_VERSION>/$(VERSION)/g' {} \;
	sed -i 's/<NEXT_VERSION>/$(VERSION)/g' build.gradle Compatibility.md maven/**
