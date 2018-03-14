# PSTL

One of the main hurdles has been the inability to ingest and transform large amounts of data from multiple sources
in real time. While most organizations employ data analysts and scientists, the reality is that they spend most of their
time—up to 80%, according to some generally accepted estimates—in data
preparation: collecting data sets and cleaning and organizing data.

Parallel Streaming Transformation Loader (PSTL) from Vertica Professional Services is a Big Data solution that dramatically reduces both the time and latency involved in real time data collection, loading, and transformation. 

To know more about PSTL click [here](http://files.asset.microfocus.com/3484/en/3484.pdf)

# Features

* A Spark application with out-of-thebox integration from Kafka to Vertica and Hadoop; integration to other data systems via no-code configurations
* No-ETL, no-ELT, no-code required SQL streaming solution
* Single set of semantics for multiple sinks (Vertica, Kafka, Hive Tables, Opentsdb, or Spark Datasets)
* Out-of-the-box support for Confluent Kafka Sources
* Processes semi-structured JSON, Avro, Protobuf, Delimited, and CSV data into optimized data at rest
* Advanced job management of Spark Streaming Jobs
* A no-code approach for Change Data Capture, Slowly Changing Dimensions, Streaming Table Mappings, from external JDBC connectors
* A simple extensibility model for data validation and transformations 

# Contributing

If you are interested in fixing issues and contributing directly to the code base, please see the document [How to Contribute](https://github.com/vertica/PSTL/wiki/How-To-Contribute). 

# Building

## Prerequisites

To build PSTL, you will need to make sure the following components are available in your build environment:

* Java 8
* Maven 3
* RPM Build tools

If you use `brew`, this is generally as simple as:

~~~bash
brew update
brew tap caskroom/versions
brew cask install java8
brew install maven
brew install rpm
~~~

## Tarball(s)

To build PSTL and generate a tarball distribution, simply run the following:

~~~bash
mvn -DskipTests clean install -Passembly
~~~

The generated tarball will be located under `pstl-assembly/target`. Similarly, an unpacked tarball will be present in `pstl-assembly/target` without the `.tar.gz` suffix which you can use locally. Generally the only work required on your part to run the full distribution locally is to provide `SPARK_HOME` in `conf/pstl-env.sh`.

## RPM(s)

To build PSTL and generate a RPM distribution, simply run the following:

~~~bash
mvn -DskipTests clean install -Passembly-rpm
~~~

The generated RPM will be located under  `pstl-assembly-rpm/target/rpm/pstl-assembly-rpm_2.11/RPMS/noarch/`. Installing the RPM is as simple as `rpm -ivh /path/to/rpm`. Uninstalling the RPM is as simple as `rpm -e pstl-assembly_2.11`. By default the RPM will install to `/usr/share/pstl`.

## Documentation
Please read the documentation [here](https://github.com/vertica/PSTL/wiki/Home) .

## Contact

To contact us please e-mail to [this](mailto:bigdatainfo@microfocus.com) address.

