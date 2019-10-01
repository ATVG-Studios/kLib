# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased

### Added
* KSocket (`klib.net.socket.KSocket`)
* KString (`klib.text.KString`)
* `asFileInputStream` extension for String
* `asFileOutputStream` extension for String
* Light weight JSON Parser (`net.jemzart.jsonkraken`)
* `toListOfType` extension for JsonArray
* `toObjectOfType` extension for JsonObject
### Changed
* Moved and Renamed a lot of packages (Major Breaking Change)
* `toObjectFromType` extension on String uses Generics
* `toObjectFromType` extension on String uses Generics
### Deprecated
* kSock (`klib.net.socket.kSock`)
### Removed
* SimpleJSON was removed again (`org.json.*`)
* GSON was removed again (`com.google.gson`)
* `toObject(json, type)` function from Json interface
### Fixed
### Security

## 3.2.0 - 12.09.2019

### Added
- `print` Top-Level Function
- `binSearch` extension for List
- `binSearch` extension for MutableList
- Http.custom function
- Konfig now supports Lists/Arrays
- kLib is now shipping with JSON Parser (it adds about 300KB to builds)

### Changed
- Extended Http.get with headers parameter
- Extended Http.post with headers parameter
- Default JsonHandler now uses JSON Parser and actually works

## 3.1.0 - 12.06.2019

### Added
- `smartMerge` extension to MutableMap (With value type converter)
- `fullMerge` extension to MutableMap (With value type converter)
- `mergeArrays` extension to MutableMap (With value type converter)
- `toListWithConvert` extension to List
- `toListWithConvert` extension to MutableList
- `fromUrl` extension to File
- `toFile` extension to URL
- `toObjectOfType` extension to URL
- `Http` class
- `Http.DataTypes` Enum Class
- `readText` extension to InputStream
- `fromHex` extension to String
- `fromHexToLong` extension to String
- `toHex` extension to Byte
- `binSearch` extension to IntArray (Using Recursion, its 50% faster)

### Changed
- Moved Library API from Experimental to Stable

## 3.0.0 - 08.06.2019

### IMPORTANT NOTICE
- kLib is now licensed under the OSPL20 (a MPL 2.0 Fork), kLib prior to 3.0 will stay MIT!

### Added
- `smartMerge` extension to MutableMap
- `fullMerge` extension to MutableMap
- `mergeArrays` extension to MutableMap
- `openIfExist` parameter for ZipFile.open
- `reset` extension to File
- `kSock` object class
- `every` extension to Function `() -> Unit`

### Removed
- `version` property of kLibInf (Replaced with semver)
- `versionId` property of kLibInf (Replaced with semver)
- `klibRequire` for versionId (Replaced with semver)
- `klibRequire` for versionId range (Replaced with semver)

### Fixed
- Fixed bug in SemVer parsing crashing when preRelease and buildMetadata was not given

## 2.1.1 - 01.06.2019

### Fixed
- Removed Experimental Annotations from ZipFile functions/classes

## 2.1.0 - 28.05.2019

### Added
- `new` function to LClass (To be used with `is` and `as` and Interfaces)
- `semver` property of kLibInf is now priority
- `kLibRequire` Top-Level Function gets semver support
- `extract` function to ZipFile
- `unzip` function to ZipFile

### Changed
- Moved `ZipFile` out of Experimental

### Deprecated
- `version` property of kLibInf (Replaced with semver)

### Fixed
- `println` ran in infinite loop

## 2.0.1 - 27.05.2019

### Fixed
- `String.deny` failing on empty strings
- `String.require` not considering empty strings
- `kLibInf.version` having the wrong version number

## 2.0.0 - 27.05.2019

### Added
- `checksum` property for HashResult
- `getBytes` function for HashResult
- `Sha1` Object Class
- `asSha1` extension for String
- `inBoundsOf` extension for Int
- `hashSha256` extension for File
- `hashSha1` extension for File
- `Sha256Checksum` extension for File
- `Sha1Checksum` extension for File
- `asSha1` extension for ByteArray
- `toStrInt` extension for Char
- `semver` property for kLibInf
- `SemVer` Type Class
- `InvalidTypeException` Exception Class

### Removed
- `KonfParseException` Exception Class

### Fixed
- `String.deny` failed on empty string or param; Now only fails on empty param
- `Konfig.parse` crashing on empty lines

## 1.4.0 - 22.05.2019

### Changed
- Extended Experimental Library implementation
  - LClass now supports super class functions
  - LClass now supports direct method invocation
  - LClass now provides a list of LFunction's defined in Host class (and Supers)
  - LFunction now supports one-argument method invocations

### Fixed
- `zipPath` not being used when using `addFiles` on ZipFile

## 1.3.0 - 21.05.2019

### Added
- `Library` Object Class
- `LClass` Type Class
- `LFunction` Type Class
- `loadAsLibraryWithClass` extension for File
- `loadAsLibraryWithClass` extension for String
- `loadAsLibraryWithFunction` extension for File
- `loadAsLibraryWithFunction` extension for String

## 1.2.0 - 17.05.2019

### Added
- `toJson` extension for Any
- `println` Top-Level Function
- `asFile` extension for String
- `ZipFile` Type Class (Experimental API)
- `toFile` extension for InputStream
- `toFileInZipFile` extension for InputStream
- `addToZipFile` extension for File

## 1.1.0 - 16.05.2019

### Added
- `abs` property for Int
- `isTrue` property for Int
- `isFalse` property for Int
- `KonfigParseException` Exception
- `pairOf` Top-Level Function
- `p` Top-Level Function
- `deny` extension for Pair
- `require` extension for Pair
### Deprecated
- `KonfParseException` Exception

## 1.0.0 - 13.05.2019

### Added
- `asInt` extension for Boolean
- `power` extension for Double
- `half` property for Int
- `third` property for Int
- `quarter` property for Int
- `fourth` property for Int
- `tenth` property for Int

## 0.2.2 - 11.05.2019

### Added
- `quicksort` extension for MutableList
- `quicksort` extension for List
- `plusAssign` Function to Queue
- `invoke` Function to Queue
- `startTimedExecution` Function to Queue
- `Konfig` Object Class (Experimental API)

## 0.2.1 - 05.05.2019

### Changed
- Make `Queue` non-experimental

## 0.2.0 - 03.05.2019

## Changed
- Renamed Package `com.atvgstudios.klib` to `klib`

## 0.1.6 - 03.05.2019

### Added
- `requireOrFail` Top-Level Function
- `requireAllOrFail` Top-Level Function
- `or` extension for Any?
- `orFun` extension for Any?
- `Function_Any` Type Alias
- `eHandled` Top-Level Function
### Removed
- `toObject` Function Json Interface
- `Base58` Object
### Fixed
- Removed Implementation of removed `toObject` in dummy.JsonHandler

## 0.1.5 - 29.04.2019

### Added
- `Experimental` Annotation Class
- `Function` Type Alias
- `Queue` Type Class (Experimental API)
- `toObject` Function to Json Interface (Using Type and Nullable)
- `toBase58` extension for String
- `toBase64` extension for String
- `fromBase64` extension for String
- `fromBase58` extension for String
- `doubleDigest` extension for ByteArray
- `Base58e` Object

### Deprecated
- `toObject` Function in Json Interface (Using Any)
- `Base58` Object (com.atvgstudios.klib.encoding.base.Base58)

### Removed
- `Json` Object (com.atvgstudios.klib.objects.json.Json)

## 0.1.4 - 27.04.2019

### Added
- `ofType` extension for Any
- `swap` extension for MutableList
- `replaceAll` extension for MutableList
- `isNumeric` extension for String
- `chop` extension for String
- `toHex` extension for Integer
- `popBegin` extension for MutableList
- `popEnd` extension for MutableList
- `prepend` extension for MutableList

## 0.1.3 - 27.04.2019

### Added
- `kLibRequire` a function that allows you to only make the application run on a supported kLib version
- `Json` Interface; This is for later use. (com.atvgstudios.klib.interfaces.Json)
- `power` infix extension for Integer
- `asSha256` extension for String
- `toUpperCaseOnUnderscore` extension for String
- `toFirstLetterUpperCase` extension for String
- `isEmail` extension for String
- `deny` extension for String
- `require` extension for String
- `count` infix extension for String
- `InvalidValueException` exception
- `RequireValueException` exception

### Changed
- `timesAs` was made a `infix`
- Upgraded Kotlin from 1.3.30 to 1.3.31

### Deprecated
- `Json` Object (com.atvgstudios.klib.objects.json.Json)

## 0.1.2 - 23.04.2019
### Added
- Integer `timesAs` Extension
- Top-Level `currentMillis` Function
- `Hasher` Interface
- `Base58` Object
- `Sha256` Object
- `Json`   Object
- Type Class `HashResult`

### Changed
- Moved `UniqueID` Object from Types to Objects package

## 0.1.1 - 21.04.2019
### Fixed
- Sematic issues shown by lint

## 0.1.0 - 21.04.2019
### Added
- First implementation

## Overview

* Unreleased - [Diff 3.2.0 to master](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/3.2.0...master)
* 3.2.0 - [Diff 3.1.0 to 3.2.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/3.1.0...3.2.0)
* 3.1.0 - [Diff 3.0.0 to 3.1.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/3.0.0...3.1.0)
* 3.0.0 - [Diff 2.1.1 to 3.0.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/2.1.1...3.0.0)
* 2.1.1 - [Diff 2.1.0 to 2.1.1](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/2.1.0...2.1.1)
* 2.1.0 - [Diff 2.0.0 to 2.1.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/2.0.0...2.1.0)
* 2.0.0 - [Diff 1.4.0 to 2.0.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/1.4.0...2.0.0)
* 1.4.0 - [Diff 1.3.0 to 1.4.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/1.3.0...1.4.0)
* 1.3.0 - [Diff 1.2.0 to 1.3.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/1.2.0...1.3.0)
* 1.2.0 - [Diff 1.1.0 to 1.2.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/1.1.0...1.2.0)
* 1.1.0 - [Diff 1.0.0 to 1.1.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/1.0.0...1.1.0)
* 1.0.0 - [Diff 0.2.2 to 1.0.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.2.2...1.0.0)
* 0.2.2 - [Diff 0.2.1 to 0.2.2](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.2.1...0.2.2)
* 0.2.1 - [Diff 0.2.0 to 0.2.1](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.2.0...0.2.1)
* 0.2.0 - [Diff 0.1.6 to 0.2.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.6...0.2.0)
* 0.1.6 - [Diff 0.1.5 to 0.1.6](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.5...0.1.6)
* 0.1.5 - [Diff 0.1.4 to 0.1.5](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.4...0.1.5)
* 0.1.4 - [Diff 0.1.3 to 0.1.4](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.3...0.1.4)
* 0.1.3 - [Diff 0.1.2 to 0.1.3](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.2...0.1.3)
* 0.1.2 - [Diff 0.1.1 to 0.1.2](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.1...0.1.2)
* 0.1.1 - [Diff 0.1.0 to 0.1.1](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.0...0.1.1)
* 0.1.0 - [0.1.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/tags/0.1.0)
