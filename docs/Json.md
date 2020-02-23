# Json Handlers

kLib has the ability to use custom Json Handlers, these allow kLib to parse JSON into Objects and Objects into JSON.

**New**: Since 4.0.0 kLib ships with a Json Handler based on JsonKraken. The default handler is `klib.json.JsonHandler`.  
Prior versions use the `klib.dummy.JsonHandler` dummy, so a custom JsonHandler **must** be provided.

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
    **New**: With 4.0.0 we added the Source Code of JsonKraken, a fully Kotlin written Json API.
    
2. Customizable  
    By providing the option that developers create their own Handler, they can use what ever Json Library they want.