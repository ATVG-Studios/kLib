# Compatibility
This file contains a list of kLib versions that are compatible with each other.

Versions in between the `Version` range (`-` is a range symbol) are compatible.  
Breaking versions must be in a new row!

|  1st  |  lst  |
|-------|-------|
| 0.1.0 | 0.1.1 |
| 0.1.2 | 0.1.4 |
| 0.1.5 ||
| 0.1.6 ||
| 0.2.0 | 1.4.0 |
| 2.0.0 | 2.1.1 |
| 3.0.0 | 3.2.0 |
| 4.0.0 | 4.1.0 |
| 5.0.0 | 5.2.0 |

This means: `3.0.0` **IS upwards** compatible with `3.2.0` but **NOT downwards** compatible with `2.0.0`. (Semantic Versioning)

To see why these versions are incompatible, checkout the **Breaking Changes** section below.

## What does Compatible mean?

This means that you can upgrade without the need to make changes.  
As long as you **DONT** downgrade, you will not need to make changes.

## Breaking Changes

Table created from APIs removed/changed.

| Version | Change | Reason |
|---------|--------|--------|
|  0.1.2  | UniqueID was moved from `types.uuid` to `objects.uuid` | UniqueID is a Object not a Class |
|  0.1.5  | Removal of deprecated API `Json` (`objects.json.Json`) | The used kotlinx.serialization has a easy to use API, so this is considered duplicate Code |
|  0.1.6  | Removal of `toObject(String, Any): Any` function in Json Interface (`interfaces.Json`)| Has been replaced with `toObject(String, Type): Any?` to support nullability and any Type|
|  0.1.6  | Removal of deprecated API `Base58` (`objects.base.Base58`) | Was replaced with `Base58e` which bases on code from Google (Supports encode+decode) |
|  0.2.0  | Rename package from `com.atvgstudios.klib.*` to `klib.*` | Making the use of kLib simpler and pulling it of from ATVG-Studios |
|  2.0.0  | Removal of `exceptions.KonfParseException` | Replaced with `KonfigParseException` for ease |
|  3.0.0  | Removal of `kLibInf.version` | Replaced with `kLibInf.semver` using `types.SemVer` |
|  3.0.0  | Removal of `kLibInf.versionId` | Replaced with `kLibInf.semver` using `types.SemVer` |
|  3.0.0  | Removal of `kLibRequire` | Replaced with `kLibRequire` using `types.SemVer` |
|  3.0.0  | Removal of `kLibRequire` (min,max) | Replaced with `kLibRequire` (min,max) using `types.SemVer` |
|  4.0.0  | Major renaming of packages | Following the suggestion from #1 |
|  4.1.0  | Renamed Queue.enqueue parameter `x` to `func` | Parameter names that make sense |
|  5.0.0  | Removed kSock (`klib.net.socket.kSock`) API | Was replaced with KSocket (`klib.net.socket.KSocket`) |
|  5.0.0  | Removal of Directory (`klib.files.Directory`) API | Was replaced with Directory2 (`klib.files.Directory2`) |
|  5.1.0  | Alias Directory2 (`klib.files.Directory2`) as Directory (`klib.files.Directory`) | The new Directory2 API will be renamed as the original Directory API was removed. This is considered a Breaking change as pre-5.0 applications would not compile when moving to 5.1.0

## Upcoming Breaking Changes

| Planed Since | Expecting Change in | Change | Reason |
|--------------|---------------------|--------|--------|
| 5.1.0 | 6.0.0 | Removal of Directory2 (`klib.files.Directory2`) | Now named Directory (`klib.files.Directory`) |
| 5.2.0 | 6.0.0 | Removal of AustrianBill | Renamed to RksvBill |

## Experimental APIs

Table created from APIs marked as Experimental. These may change or be removed at any time!

| Since | Change |
|-------|--------|
| 4.1.0 | New Rewrite Directory2 (`klib.files.Directory2`) |
