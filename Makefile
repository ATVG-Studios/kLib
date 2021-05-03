GRADLE="./gradlew"
GRAARG=

all: lint compile package doc

compile:
	$(GRADLE) $(GRAARG) build

package:
	$(GRADLE) $(GRAARG) shadowJar
	$(GRADLE) $(GRAARG) jar
	$(GRADLE) $(GRAARG) sourcesJar

publish: compile package
	$(GRADLE) $(GRAARG) publish

lint:
	$(GRADLE) $(GRAARG) lintKotlin

format:
	$(GRADLE) $(GRAARG) formatKotlin

test:
	$(GRADLE) $(GRAARG) test

doc:
	$(GRADLE) $(GRAARG) dokkaHtml

upgrade:
	$(GRADLE) wrapper

code-version:
	find src/main/kotlin -name "*.kt" -type f -exec sed -i 's/<NEXT_VERSION>/$(VERSION)/g' {} \;
	sed -i 's/<NEXT_VERSION>/$(VERSION)/g' build.gradle Compatibility.md maven/**
