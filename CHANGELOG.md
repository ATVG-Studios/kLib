# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](keep-a-changelog.md),
and this project adheres to [Semantic Versioning](semver.md).

## Unreleased

### Added
* `ZipFile.addFiles(newFiles: List<File>)` which doesn't use spread-operator
* `isCallableMethodModifier` extension on Int
* DataTypes.GRAPHQL (`klib.net.http.Http.DataTypes`) to send `application/graphql` Content-Type Header
* DataTypes.PLAIN (`klib.net.http.Http.DataTypes`) to send `text/plain` Content-Type Header
* DataTypes.NONE (`klib.net.http.Http.DataTypes`) to send no Content-Type Header
* `ul` property for Long
* BaseBlock (`klib.blockchain.BaseBlock`)
* Block (`klib.blockchain.Block` as BaseBlock<String>)
* `anagrams` infix extension on String
* `isAnagramOf` extension on String
### Changed
* Multiple internal API changes based on Detekt findings
* `Konfig.writeFile` now throws FileNotWritableException instead of generic Exception
* Http.post (`klib.net.http.Http`) defaults to JSON for DataType
* SemVer is now Spec compliant in pre-release vs release comparison (1.0.0 > 1.0.0-rc.1)
### Deprecated
* `ZipFile.addFiles(vararg newFiles: File)`, use `ZipFile.addFiles(newFiles: List<File>)` instead
### Removed
* AustrianBill, use RksvBill instead
* Queue (`klib.queue.Queue`)
* Function (`klib.queue.Function`)
* Function -> Any (`klib.queue.Function_Any`)
* Word (`klib.word.Word`)
### Fixed
### Security

## 5.3.0 - 2021-04-01

### Added
* `times` extension for String
* `TablePrinter` and table DSL to print Text Tables to any PrintStream
* `prompt<T>` global function as Text Prompt with type parsing
* `copyFrom` extension for anything that inherits from Any
* **Added JodaTime as a Dependency** (Adds ~600 KB to FAT jar)
### Changed
* `isNumeric` extension on String uses start and end in regex `^\d+$`

## 5.2.0 - 2021-02-01

### Added
* Link Value to RksvBill
* `alphanumericalRegex` global function
* `replaceAllOf` extension for String
* `normalize' extension for String
* `klib.parser.influx.Influx` object
* `klib.parser.influx.InfluxData` data class
* `toSimpleString` extension for Map
### Changed
* Allow access to Protected and Native methods in LClass
### Deprecated
* AustrianBill, use RksvBill instead

## 5.1.0 - 2020-12-08

### Added
- `string` extension for Random
- Directory as Directory2 alias
- `luhn10` extension for String
- `mod97` extension for String
- isVirtual parameter to ZipFile constructor
- ZipFile.openVirtual to output the file to a random Stream
- `klib.os.Platform` object
- Platform Extensions for System
- `IncompatibleArrayLengthException`
- `onConflict` to Map.`smartMerge` and Map.`mergeArrays`
### Changed
- Upgraded Kotlin from 1.3.71 to 1.4.10
- FFDB v1 files are read-only. (FFDB is still Experimental so this change is acceptable)
- fileName parameter of ZipFile constructor is Nullable (only allowed when isVirtual=true)
- ZipFile.open only opens a file if fileName!=null; throws an error if fileName==null && isVirtual==false
- In ZipFile all file accessors could throw a ZipTraversalNotAllowedException
- Map.`mergeArrays` throws `IncompatibleArrayLengthException` when arrays have different sizes 
### Deprecated
- Queue (`klib.queue.Queue`)
- Function (`klib.queue.Function`)
- Function -> Any (`klib.queue.Function_Any``)
- Word (`klib.word.Word`)
### Fixed
- String.`toUpperCaseOnUnderscore` was rewritten and works propperly now
### Security
- ZipFile reject all paths that seem like they could cause a traversal attack

## 5.0.0 - 2020-06-03

### Added
- JsonKraken 2.0 dependency
- `objectOutputStream` extension for File
- `objectInputStream` extension for File
- FFDB (FlatFile DataBase) (`klib.ffdb.FFDB`)
- IncompatibleDatabaseException (`klib.exceptions.IncompatibleDatabaseException`)
- `openFFDB` extension for String
- `splitBy` extension for String
- `trimSpace` extension for String
### Changed
- Upgraded Kotlin from 1.3.61 to 1.3.71
### Removed
- JsonKraken 1.0 Source
- kSock (`klib.net.socket.kSock`)
- Directory (`klib.files.Directory`)
- `asDirectory` extension for File
- Status number from `klib.files.Directory2.DirectoryError`
### Fixed
- FFDB now checks if the File exists before writing/reading
- FFDB now checks if the FIle is empty before reading

## 4.1.0 - 2020-02-25

### Added
- `Sha512` Object
- `asSha512` extension for ByteArray
- `partition` extension for IntArray
- `swap` extension for IntArray
- `lessThen` extension for Integer
- `lessThenOrEqualTo` extension for Integer
- `greaterThen` extension for Integer
- `greaterThenOrEqualTo` extension for Integer
- `kLibRequireMin` with a minimum only Version (Closes #6)
- `arrayBinSearch` global function
- `listQuicksort` global function
- `replaceLast` extension for String
- Implement [OpenSpec Konfig 19.3](https://gitlab.atvg-studios.com/atvg-studios/openspec/blob/master/Konfig/Konfig.pdf)
- Implement [OpenSpec Konfig 20.1](https://gitlab.atvg-studios.com/atvg-studios/openspec/blob/master/Konfig/Konfig.pdf)
- Implement [OpenSpec Konfig 20.2](https://gitlab.atvg-studios.com/atvg-studios/openspec/blob/master/Konfig/Konfig.pdf)
- `AustrianBill` Class
- Directory2 (`klib.files.Directory2`)

### Changed
- Upgraded Kotlin from 1.3.60 to 1.3.61
- Queue.enqueue `x` parameter renamed to `func`

### Deprecated
- Directory (`klib.files.Directory`)

### Fixed
- `kLibRequire` falsely made a `lessThen` comparison

## 4.0.0 - 2019-11-23

### Added
- KSocket (`klib.net.socket.KSocket`)
- KString (`klib.text.KString`)
- `asFileInputStream` extension for String
- `asFileOutputStream` extension for String
- Light weight JSON Parser (`net.jemzart.jsonkraken`)
- `toListOfType` extension for JsonArray
- `toObjectOfType` extension for JsonObject
- Directory (`klib.files.Directory`)
- `asDirectory` extension for File
- `readAll` extension for FileList
- `writeAll` extensions for FileList
- `replaceAllOf` extension for MutableFileList
- `readInt` global function
- `readLong` global function
- `runRandom` global function
- `orNullable` extension for Any
- `toSnakeCase` extension for String
- `asIntOr` extension for String
- `asLongOr` extensions for String

### Changed
- Upgraded Kotlin from 1.3.31 to 1.3.60
- Moved and Renamed a lot of packages (Major Breaking Change)
- `toObjectFromType` extension on String uses Generics
- `toObjectFromType` extension on String uses Generics

### Deprecated
- kSock (`klib.net.socket.kSock`)

### Removed
- SimpleJSON was removed again (`org.json.*`)
- GSON was removed again (`com.google.gson`)
- `toObject(json, type)` function from Json interface
- `binSearch` extension from MutableList

## 3.2.0 - 2019-09-12

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

## 3.1.0 - 2019-06-12

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

## 3.0.0 - 2019-06-08

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

## 2.1.1 - 2019-06-01

### Fixed
- Removed Experimental Annotations from ZipFile functions/classes

## 2.1.0 - 2019-05-28

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

## 2.0.1 - 2019-05-27

### Fixed
- `String.deny` failing on empty strings
- `String.require` not considering empty strings
- `kLibInf.version` having the wrong version number

## 2.0.0 - 2019-05-27

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

## 1.4.0 - 2019-05-22

### Changed
- Extended Experimental Library implementation
  - LClass now supports super class functions
  - LClass now supports direct method invocation
  - LClass now provides a list of LFunction's defined in Host class (and Supers)
  - LFunction now supports one-argument method invocations

### Fixed
- `zipPath` not being used when using `addFiles` on ZipFile

## 1.3.0 - 2019-05-21

### Added
- `Library` Object Class
- `LClass` Type Class
- `LFunction` Type Class
- `loadAsLibraryWithClass` extension for File
- `loadAsLibraryWithClass` extension for String
- `loadAsLibraryWithFunction` extension for File
- `loadAsLibraryWithFunction` extension for String

## 1.2.0 - 2019-05-17

### Added
- `toJson` extension for Any
- `println` Top-Level Function
- `asFile` extension for String
- `ZipFile` Type Class (Experimental API)
- `toFile` extension for InputStream
- `toFileInZipFile` extension for InputStream
- `addToZipFile` extension for File

## 1.1.0 - 2019-05-16

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

## 1.0.0 - 2019-05-13

### Added
- `asInt` extension for Boolean
- `power` extension for Double
- `half` property for Int
- `third` property for Int
- `quarter` property for Int
- `fourth` property for Int
- `tenth` property for Int

## 0.2.2 - 2019-05-11

### Added
- `quicksort` extension for MutableList
- `quicksort` extension for List
- `plusAssign` Function to Queue
- `invoke` Function to Queue
- `startTimedExecution` Function to Queue
- `Konfig` Object Class (Experimental API)

## 0.2.1 - 2019-05-05

### Changed
- Make `Queue` non-experimental

## 0.2.0 - 2019-05-03

## Changed
- Renamed Package `com.atvgstudios.klib` to `klib`

## 0.1.6 - 2019-05-03

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

## 0.1.5 - 2019-04-29

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

## 0.1.4 - 2019-04-27

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

## 0.1.3 - 2019-04-27

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

## 0.1.2 - 2019-04-23

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

## 0.1.1 - 2019-04-21

### Fixed
- Sematic issues shown by lint

## 0.1.0 - 2019-04-21

### Added
- First implementation
