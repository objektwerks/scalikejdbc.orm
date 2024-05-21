Scalikejdbc ORM
---------------
>Scalikejdbc feature test and performance benchmark against H2 using Scala 3.

Todo
----
1. Refactor to use ORM module.

Test
----
1. sbt clean test

Benchmark
---------
>See Performance class for details.
1. sbt jmh:run

Results
-------
>OpenJDK Runtime Environment Zulu22.28+91-CA (build 22+36), **Scala 3.5.0-RC1**, Apple M1
1. addTodo - 37.821
2. updateTodo - 0.0
3. listTodos - 0.0
>Total time: 0 s (0:0), 10 warmups, 10 iterations, average time in microseconds, completed **2024.5.20**