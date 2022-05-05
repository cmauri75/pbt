# PBT: exPerimental Big ideas for Java code developmenT

## Topics covered
* Property-Based Testing (Thanks to GG and Tinvention)
* Test containers mock (Thanks the Web) 
* Lombok&Ereditance (Original idea to solve UC style problem) 
* System.Logger (Thanks to Baeldung)
* ehcache4Search (Original idea to solve UC crypt performance problem)
* Mutation testing aka PIT testing (Thanks to Decathlon IT)
* MicroBenchmarking. (Thanks to [Richard](https://richardstartin.github.io/posts/5-java-mundane-performance-tricks#use-enums-instead-of-constant-strings)) 
* Visitor.

![Test types](img/tests.png?raw=true "Test types")

**Property based** idea is to test "properties" (a funtion that returns a boolean) of code instead of examples

**Mutation** idea is to modify code and check if test passes. If yes "mutation survives", this is a proxy versus test weakness. 


ex:

**Commutativity**: the parameter order does not matter
```
for all (int x, int y)
such that (add(x, y) equals add(y, x)) is satisfied
```
PBT library docs: [jqwik](https://jqwik.net/docs/current/user-guide.html#how-to-use)

Test containers docs: [Sprint test containers](https://www.testcontainers.org/)

PIT docs: [Real world mutation testing](https://pitest.org/)

## Prerequisites:
Docker should be installed for test containers

## Code explaining
* RedisBackedCacheIntTest.java contains a test against a redis server, loaded by Docker at test-time
* Logger: example usage of System.LOGGER, can be used as is, if falls over found log system (like slf4j) or create your own logger, like in this example. Just add META-INF/services/ file indicating finder implementation
* ehcache: example usage of ehcache as fast-inmemory full text replacement
* MathCalculatorTest: two cases, one is complete so PIT shows 100% coverage, second one only 50% as it effectively is
* Benchmark: let's bench hashmaps:
    * HashMapResize: always leave 0,75 load factor (rounded to upper 2 power) or resize will occur making much slower 
    * CompositeLookup: when key is composite use a wrapper (4ex using Pair) instead of concatenating string, it's 3 times faster
    * XXX: Don’t iterate over Enum.values()
    * EnumMapBenchmark: Use Enum instead of String, it's 3 times faster
    * NB: Use of @BenchmarkMode(Mode.SingleShotTime) avoid huge testing times, but real results are obtained using Average or Throughput Mode 
* BadManager: look at implementation to notify when visitor should be used

  
## Usage
```./mvnw test``` for all test
```./mvnw test-compile org.pitest:pitest-maven:mutationCoverage``` for PIT testing analisys 

## Exceptions
![Exception hierarchy ](img/exceptions.png?raw=true "Test types")

* Propagator: Unchecked exceptions are forwarded in calling chain and checked exceptions are not forwarded in calling chain (use throws to do it)
* Finally: always executed except if program exits
