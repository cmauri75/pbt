# PBT: exPerimental Big ideas for Java code developmenT

## Topics covered
* Property-Based Testing (Thanks to GG and Tinvention)
* Test containers mock (Thanks the Web) 
* Lombok&Ereditance (Original idea to solve UC style problem) 
* System.Logger (Thanks to Baeldung)
* ehcache4Search (Original idea to solve UC crypt performance problem)
* Mutation testing aka PIT testing (Thanks to Decathlon IT)

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

## Code
* RedisBackedCacheIntTest.java contains a test against a redis server, loaded by docker at test-time
* Logger: example usage of System.LOGGER, can be used as is, if falls over found log system (like slf4j) or create your own logger, like in this example. Just add META-INF/services/ file indicating finder implementation
* ehcache: example usage of ehcache as fast-inmemory full text replacement
* MathCalculatorTest: two cases, one is complete so PIT shows 100% coverage, second one only 50% as it effectively is
## Usage
```./mvnw test``` for all test
```./mvnw test-compile org.pitest:pitest-maven:mutationCoverage``` for PIT testing analisys 

## Exceptions
![Exception hierarchy ](img/exceptions.png?raw=true "Test types")

* Propagator: Unchecked exceptions are forwarded in calling chain and checked exceptions are not forwarded in calling chain (use throws to do it)
* Finally: always executed except if program exits
