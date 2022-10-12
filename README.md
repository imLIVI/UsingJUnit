## Using JUnit
### Description
Write unit tests that automatically check the functionality of the program

### Realisation
I used:
1. <a href="https://github.com/imLIVI/Abstract-classes"> Project "Bank accounts"</a>
2. JUnit - framework

```xml
<dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.9.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```
3. Maven

```xml
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
            </plugin>
        </plugins>
    </build>
```
