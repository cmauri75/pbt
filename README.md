# pbt
Property-Based Testing - test containers mock - lombok&Ereditance - System.Logger - ehcache4Search

![Test types](img/tests.png?raw=true "Test types")

Property based idea is to test "properties" (a funtion that returns a boolean) of code instead of examples


ex:

***Commutativity***: the parameter order does not matter
```
for all (int x, int y)
such that (add(x, y) equals add(y, x)) is satisfied
```
Documentation of library: [jqwik](https://jqwik.net/docs/current/user-guide.html#how-to-use)

Documentaition for test containers: [Sprint test containers](https://www.testcontainers.org/)
## Prerequisites:
Docker should be installed for test containers

## Code
* RedisBackedCacheIntTest.java contains a test against a redis server, loaded by docker at test-time
* Logger: example usage of System.LOGGER, can be used as is, if falls over found log system (like slf4j) or create your own logger, like in this example. Just add META-INF/services/ file indicating finder implementation
* ehcache: example usage of ehcache as fast-inmemory full text replacement
## Usage
just run ```./mvnw test```
