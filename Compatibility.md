# Compatibility
This file contains a list of kLib versions that are compatible with each other.

Versions in between the `ID` or `Version` range (`-` is a range symbol) are compatible.  
Breaking versions must be in a new row!

| ID | Version |
|----|---------|
| 1 - 2 | 0.1.0 - 0.1.1 |
| 3 - 5 | 0.1.2 - 0.1.4 |
| 6     | 0.1.5 |
| 7     | 0.1.6 |

This means: `0.1.2` **IS** compatible with `0.1.3` but **NOT** compatible with `0.1.0` and `0.1.1`.

To see why these versions are incompatible, checkout the **Breaking Changes** section below.

## What does Compatible mean?

This means that you can switch versions without the need to make changes.  
As long as you dont use features of new versions and then go to a older version, you will not need to make changes.

## Breaking Changes

Table created from APIs removed.

| Version | Change | Reason |
|---------|--------|--------|
|  0.1.2  | UniqueID was moved from `types.uuid` to `objects.uuid` | UniqueID is a Object not a Class |
|  0.1.5  | Removal of deprecated API `Json` (`objects.json.Json`) | The used kotlinx.serialization has a easy to use API, so this is considered duplicate Code |
|  0.1.6  | Removal of `toObject(String, Any): Any` function in Json Interface (`interfaces.Json`)| Has been replaced with `toObject(String, Type): Any?` to support nullability and any Type|
|  0.1.6  | Removal of deprecated API `Base58` (`objects.base.Base58`) | Was replaced with `Base58e` which bases on code from Google (Supports encode+decode) |

## Upcoming Breaking Changes

Table created from APIs marked as Deprecated.

| Version | Change | Reason |
|---------|--------|--------|

## Experimental APIs

Table created from APIs marked as Experimental. These may change or be removed at any time!

| Since | Change |
|-------|--------|
| 0.1.5 | Adding in Queue Type for Functions (`types.queue.Queue`) |