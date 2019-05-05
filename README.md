# kLib

kLib is a in Kotlin written Library by ATVG-Studios containing a set of useful Functions,
Extensions and Types.

kLib works as a Standard Library at ATVG-Studios containing code that can be used across many applications in a generic way.

Checkout the Homepage over [here](https://klib.atvg-studios.com).

kLib is now available via a custom Maven repository.  
You can find the Git repository that hosts the Maven data [here](https://gitlab.atvg-studios.at/atvg-studios/maven-repository).  
The Maven Repository itself is available here: https://mvn.osmium.software

Adding kLib using Gradle:

```
repositories {
    maven { url 'https://mvn.osmium.software' }
}

dependencies {
    implementation "com.atvgstudios:klib:0.2.1"
}
```

Adding kLib using Maven:

```
<repositories>
  <repository>
    <id>atvg-studios</id>
    <name>ATVG-Studios Maven</name>
    <url>https://mvn.osmium.software</url>
  </repository>
</repositories>
<dependencies>
  <dependency>
    <groupId>com.atvgstudios</groupId>
    <artifactId>klib</artifactId>
    <version>0.2.1</version>
  </dependency>
</dependencies>
```

The above versions may be outdated.  
Please check the Changelog for the latest version.  
Also check the Compatibility list if you want to upgrade your current dependency.

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

# License

kLib is distributed under the [MIT](LICENSE) License and available for everyone at any time.

The usage of kLib however, may be written in a "Open-Source Licenses" section of a Legal Notice or a End User License Agreement (EULA).

Users may be informed about the Usage of kLib in your product.

This is **NOT** a strict requirement, but a helpful feature for both ATVG-Studios and the User.