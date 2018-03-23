# pstl-spark-sql-maven-plugin

Provides necessary build infrastructure for a PSTL job directory so jobs (eg. SQL) can be treated as though it were a build. Treating a job directory like a build allows you to use standard source control semantics to version changes to job definitions as well as other assets required by the job definition such as avro schemas, etc. Similarly, treating a job directory like a build enables you to leverage existing continuous integration infrastructure to test changes to your SQL, etc.

## Usage

To use `pstl-spark-sql-maven-plugin` with your job directory, simply add a pom.xml to your job directory and add `pstl-spark-sql-maven-plugin` as a build plugin:

~~~xml
<build>
  <plugins>
    <plugin>
      <groupId>com.microfocus.pstl</groupId>
      <artifactId>pstl-spark-sql-maven-plugin</artifactId>
      <version>1.0.0-SNAPSHOT</version>
      <executions>
        <execution>
          <phase>validate</phase>
          <goals>
            <goal>validate-job</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
~~~

To specify a specific sql file to test, rather than the default `job.sql`, modify the execution's configuration:

~~~xml
<build>
  <plugins>
    <plugin>
      <groupId>com.microfocus.pstl</groupId>
      <artifactId>pstl-spark-sql-maven-plugin</artifactId>
      <version>1.0.0-SNAPSHOT</version>
      <executions>
        <execution>
          <phase>validate</phase>
          <goals>
            <goal>validate-job</goal>
          </goals>
          <configuration>
            <job>foo.sql</job>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
~~~

To specify multiple sql files to test, add multiple executions to the build plugin.

To modify the spark environment under which your job is tested, simply provide specific spark settings for the appropriate spark configuration keys. At this time we only support testing the job definition in standalone local mode, so YARN and MESOS specific configuration(s) are not going to do much for you here. This may be improved at a later date:

~~~xml
<build>
  <plugins>
    <plugin>
      <groupId>com.microfocus.pstl</groupId>
      <artifactId>pstl-spark-sql-maven-plugin</artifactId>
      <version>1.0.0-SNAPSHOT</version>
      <executions>
        <execution>
          <phase>validate</phase>
          <goals>
            <goal>validate-job</goal>
          </goals>
          <configuration>
            <sparkProperties>
              <property>
                <name>spark.app.name</name>
                <value>my-special-app-name</value>
              </property>
            <sparkProperties>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
~~~

In the future we will provide a parent pom which will generally result in much less configuration, as sane defaults, necessary dependency hits on plugins, etc. will all be provided out of the box.
