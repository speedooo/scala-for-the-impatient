# Scala for the Impatient [![Build Status](https://api.travis-ci.org/cbismuth/scala-for-the-impatient.svg?branch=master)](https://travis-ci.org/cbismuth/scala-for-the-impatient)

My pretty own playground to learn Scala the pragmatic way.

Experiments are picked up from the great book: [Scala for the Impatient](http://typesafe.com/resources/e-book/scala-for-the-impatient).

## Code style

[Scalariform](http://mdr.github.io/scalariform/) is used to format source code with [SBT](http://www.scala-sbt.org/) [triggered executions](http://www.scala-sbt.org/0.12.4/docs/Detailed-Topics/Triggered-Execution.html#running-multiple-commands).

```
~ ;scalariformFormat ;test:scalariformFormat
```

Or simply combine this with continuous testing, including Scalastyle:

```
~ ;test ;scalastyle ;test:scalastyle
```
