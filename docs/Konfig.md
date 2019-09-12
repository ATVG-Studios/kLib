# Konfig file format

The Konfig File Format is a custom and simple Configuration file.

# Extensions

+ knf
+ konf
+ konfig
+ kon
+ kff

# Format

Konfig has one of the simplest configuration formats.

This is the basics:

+ Lines starting with `#` are comments
+ Every non-comment line **MUST** have a `=`
+ Every line **CAN** have spaces, underscores, dashes and dots as keys (left side of `=`)
+ Every line **CAN** have any type of data (right side of `=`)
+ Every line holding a list **MUST** use `[]` around `,` separated data

```
# comment
key=value
another_key=Another Value
another-key=Yet another value!!!1!
another.key=Jup some more data
one=1
list=["this","is","a","list"]
```

# Data Types

+ Int: key=1
+ String: key="hello"
+ List: key=[1,2,3,"hello"]