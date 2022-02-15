# pbt
Property-Based Testing - test containers mock - lombok&Ereditante

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

## Usage

just run ```./mvnw test```
