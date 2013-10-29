# Tasty #

## Build & Run ##

```sh
$ cd server/
$ ./sbt
> container:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Deployment

`sbt package`

`heroku deploy:war --war target/scala-2.10/tasty_2.10-0.1.0-SNAPSHOT.war --app HEROKU-APP-NAME`

## SQL

Run the following in sbt console:

```
import com.panuleppaniemi.tasty.models._
(Tags.ddl++Taggings.ddl++Tastes.ddl).createStatements.mkString(";\n") + ";"
```

