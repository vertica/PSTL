# PSTL

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

The generated RPM will be located under `pstl-assembly-rpm/target/rpm/pstl-assembly-rpm_2.11/RPMS/noarch/`. Installing the RPM is as simple as `rpm -ivh /path/to/rpm`. Uninstalling the RPM is as simple as `rpm -e pstl-assembly_2.11`. By default the RPM will install to `/usr/share/pstl`.

## Documentation
Please read the [documentation]([Home) here.
