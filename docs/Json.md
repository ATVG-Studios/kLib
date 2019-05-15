# Json Handlers

kLib has the ability to use custom Json Handlers, these allow kLib to parse JSON into Objects and Objects into JSON.

kLib does **NOT** ship with a Json Handler. The default handler is `klib.dummy.JsonHandler` which has no real implementation.

### How to create a Handler?

The easiest way is to write this code at the beginning of your application:

```kotlin
kLibInf.jsonHandler = object: Json {
    override fun fromObject(data: Any): String {
        return Gson().toJson(data)
    }

    override fun toObject(data: String, type: Type): Any? {
        return Gson().fromJson(data, type)
    }
}
```

This is a Json Handler using Gson.

You can create your own Handler with any Json Library!

Only extend `klib.interfaces.Json` and set `klib.kLibInf.jsonHandler` to a instance of your Handler.

### Why Handlers?

1. Minimal  
    We want kLib to be as small as possible with only one dependency: Kotlin STD.
    
2. Customizable  
    By providing the option that developers create their own Handler, they can use what ever Json Library they want.