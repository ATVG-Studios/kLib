# kLib

| Branch | Status |
|--------|--------|
| master | [![pipeline status](https://gitlab.atvg-studios.atvg.cloud/atvg-studios/kLib/badges/master/pipeline.svg)](https://gitlab.atvg-studios.at/atvg-studios/kLib/commits/master) |
| release/5.2.x | [![pipeline status](https://gitlab.atvg-studios.atvg.cloud/atvg-studios/kLib/badges/release/5.2.x/pipeline.svg)](https://gitlab.atvg-studios.at/atvg-studios/kLib/commits/release/5.2.x) |
| release/5.3.x | [![pipeline status](https://gitlab.atvg-studios.atvg.cloud/atvg-studios/kLib/badges/release/5.2.x/pipeline.svg)](https://gitlab.atvg-studios.at/atvg-studios/kLib/commits/release/5.2.x) |
| release/6.0.x | [![pipeline status](https://gitlab.atvg-studios.atvg.cloud/atvg-studios/kLib/badges/release/5.2.x/pipeline.svg)](https://gitlab.atvg-studios.at/atvg-studios/kLib/commits/release/6.0.x) |
| Coverage | [![coverage report](https://gitlab.atvg-studios.atvg.cloud/atvg-studios/kLib/badges/master/coverage.svg)](https://gitlab.atvg-studios.atvg.cloud/atvg-studios/kLib/-/commits/master) |

kLib is a Generic Kotlin Library to simplify development

kLib is available via the ATVG-Studios Maven repository.  
You can find the Git repository that hosts the Maven data [here](https://gitlab.atvg-studios.atvg.cloud/atvg-studios/maven-repository).  
The Maven Repository itself is available here: https://atvg-studios.pages.atvg.cloud/maven-repository

Adding the latest version of kLib using Gradle:

```
repositories {
    maven { url 'https://atvg-studios.pages.atvg.cloud/maven-repository' }
}

dependencies {
    implementation "com.atvgstudios:klib:+"
}
```

Adding the latest version of kLib using Maven:

```
<repositories>
  <repository>
    <id>atvg-studios</id>
    <name>ATVG-Studios Maven</name>
    <url>https://atvg-studios.pages.atvg.cloud/maven-repository</url>
  </repository>
</repositories>
<dependencies>
  <dependency>
    <groupId>com.atvgstudios</groupId>
    <artifactId>klib</artifactId>
    <version>[0.1.0,)</version>
  </dependency>
</dependencies>
```

# Compiling

To compile kLib yourself, first off clone the repository.

Go into the kLib folder, now you have two ways to compile:

###### Compile with Make (*nix Only)

This is the simplest way, just run:

```
$ make
```

Uses: gradlew
Runs: ktlint, gradle tasks: build shadowjar jar sourcejar dokka

###### Compile manually with gradlew

Manually run the Gradle tasks.

(**Windows**: Use `./gradlew.bat` when using Powershell | Use `.\gradlew.bat` when using CMD)

```
$ ./gradlew build shadowjar
```

# Contributing

If you want to contribute, please add your name, email, company (if any) and homepage (if any) to the Authors Array in the kLibInfo.

Please read the [CONTRIBUTION GUIDE](CONTRIBUTING.md) before doing any dedicated development.

# Version Compatibility

Checkout our doc about [Compatibility](Compatibility.md).  
It contains information about which versions are compatible without issues.  
Also what breaking changes where made when and which will come up in near future!

## Outdated Versions

All listed versions are considered Legacy and are no longer developed or supported.  
Versions later then the "Last Version" listed are still supported.

| Version Tree | Last Version |
|--------------|--------------|
|    0.1.x     |    0.1.6     |
|    0.2.x     |    0.2.2     |
|    1.x.x     |    1.4.0     |
|    2.x.x     |    2.1.1     |
|    3.x.x     |    3.2.0     |
|    4.x.x     |    4.1.0     |
|    5.x.x     |    5.0.0     |

# Policy for Feature removal

As removing Features is a Major breaking change, and might cause User unhappyness, we have though about how to deal with them.

Features planed for removal must go through this process:

* Issue opened, informing about why the removal makes sense.
* Marking the Feature as deprecated in a Minor release.
* Waiting for 9 Months, awaiting User feedback about the planned removal.
* Removing the feature in the next Major release, if no user feedback on keeping the feature was received.
* Removal of the Deprecated Status if user feedback requests to keep the feature

Following this process allowes users of Features that are planed to be removed to respond, and prevent the removal.

# License

kLib is distributed under the [MPL 2.0](/LICENSE).
