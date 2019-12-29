# kLib

| Branch | Status |
|--------|--------|
| master | [![pipeline status](https://gitlab.atvg-studios.com/atvg-studios/kLib/badges/master/pipeline.svg)](https://gitlab.atvg-studios.at/atvg-studios/kLib/commits/master) |
| release/3.2.x | [![pipeline status](https://gitlab.atvg-studios.com/atvg-studios/kLib/badges/release/3.2.x/pipeline.svg)](https://gitlab.atvg-studios.at/atvg-studios/kLib/commits/release/3.2.x) |
| release/4.0.x | [![pipeline status](https://gitlab.atvg-studios.com/atvg-studios/kLib/badges/release/4.0.x/pipeline.svg)](https://gitlab.atvg-studios.at/atvg-studios/kLib/commits/release/4.0.x) |

kLib is a in Kotlin written Library by ATVG-Studios containing a set of useful Functions,
Extensions and Types.

kLib works as a Standard Library at ATVG-Studios containing code that can be used across many applications in a generic way.

Checkout the Homepage over [here](https://klib.atvg-studios.com).

kLib is now available via a custom Maven repository.  
You can find the Git repository that hosts the Maven data [here](https://gitlab.atvg-studios.com/atvg-studios/maven-repository).  
The Maven Repository itself is available here: https://mvn.atvg-studios.com

Adding the latest version of kLib using Gradle:

```
repositories {
    maven { url 'https://mvn.atvg-studios.com' }
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
    <url>https://mvn.atvg-studios.com</url>
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

# Contributing

If you want to contribute, please add your name, email, company (if any) and homepage (if any) to the Authors Array in the kLibInfo.

Please read the [CONTRIBUTION GUIDE](CONTRIBUTING.md) before doing any dedicated development.

# Third-Party Code

kLib may contain code that was written by ATVG-Studios based on code by others.

Copying code is strictly **NOT** allowed. Rewriting code in our in-house coding style however, may be allow as long as the
original code is **NOT** protected by a License, Patent or Agreement.

# Version Compatibility

Checkout our doc about [Compatibility](Compatibility.md).  
It contains information about which versions are compatible without issues.  
Also what breaking changes where made when and which will come up in near future!

## Outdated Versions

All listed versions are considered Legacy and are no longer developed or supported.

| Version Tree | Last Version |
|--------------|--------------|
|    0.1.x     |    0.1.6     |
|    0.2.x     |    0.2.2     |
|    1.x.x     |    1.4.0     |
|    2.x.x     |    2.1.1     |
|    3.x.x     |    3.2.0     |

# License

kLib is distributed under the [OSPL 20](LICENSE) License (a MPL 2.0 Fork).

The usage of kLib may be written in a "Open-Source Licenses" section of a Legal Notice or a End User License Agreement (EULA). (This is **NOT** a strict requirement.)
