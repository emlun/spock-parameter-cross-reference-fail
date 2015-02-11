Spock test parameters cannot always reference other parameters
===

This repository demonstrates a few ways in which [Spock][spockframework]
parameters cannot reference each other, even though one might think they should
be able to.

[spockframework]: http://spockframework.org


Usage
---

Run the test and you should see a bunch of `MissingPropertyException`s, some of
which may be unwanted.

    $ ./gradlew test


License
---

[Unlicense][unlicense] : All files in this repository are free and unencumbered
software released into the public domain, except for the files `gradlew`,
`gradlew.bat` and those in the `gradle/` directory which are licensed however
the Gradle project has licensed them (probably Apache License).

[unlicense]: http://unlicense.org/
