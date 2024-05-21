Scalikejdbc ORM
---------------
>Scalikejdbc ORM feature test and performance benchmark against H2 using Scala 3.

Test
----
1. sbt clean test

Benchmark
---------
>See Performance class for details.
1. sbt jmh:run

Results
-------
>OpenJDK Runtime Environment Zulu22.30+13-CA (build 22.0.1+8), **Scala 3.5.0-RC1**, Apple M1
1. addTodo - 38.934
2. updateTodo - 37.679
3. listTodos - 39.257
>Total time: 603 s (10:03), 10 warmups, 10 iterations, average time in microseconds, completed **2024.5.21**