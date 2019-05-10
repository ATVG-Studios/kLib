# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased

### Added
- `quicksort` extension for MutableList
- `quicksort` extension for List
- `plusAssign` Function to Queue
- `invoke` Function to Queue
- `startTimedExecution` Function to Queue
- `Konfig` Object Class (Experimental API)
### Changed
### Deprecated
### Removed
### Fixed
### Security

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
- `Base58` Object (com.atvgstudios.klib.objects.base.Base58)

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

* Unreleased - [Diff 0.2.2 to master](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.2.2...master)
* 0.2.1 - [Diff 0.2.0 to 0.2.1](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.2.0...0.2.1)
* 0.2.0 - [Diff 0.1.6 to 0.2.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.6...0.2.0)
* 0.1.6 - [Diff 0.1.5 to 0.1.6](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.5...0.1.6)
* 0.1.5 - [Diff 0.1.4 to 0.1.5](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.4...0.1.5)
* 0.1.4 - [Diff 0.1.3 to 0.1.4](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.3...0.1.4)
* 0.1.3 - [Diff 0.1.2 to 0.1.3](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.2...0.1.3)
* 0.1.2 - [Diff 0.1.1 to 0.1.2](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.1...0.1.2)
* 0.1.1 - [Diff 0.1.0 to 0.1.1](https://gitlab.atvg-studios.at/atvg-studios/kLib/compare/0.1.0...0.1.1)
* 0.1.0 - [0.1.0](https://gitlab.atvg-studios.at/atvg-studios/kLib/tags/0.1.0)
