%define __jar_repack 0
Name: pstl-assembly-rpm_2.11
Version: 1.0.0
Release: SNAPSHOT20180531073811
Summary: pstl-assembly-rpm
License: PROPRIETARY
Group: Application/Collectors
autoprov: yes
autoreq: yes
BuildArch: noarch
BuildRoot: /opt/mount2/solutions/pstl_source_code/PSTL-master/pstl-assembly-rpm/target/rpm/pstl-assembly-rpm_2.11/buildroot

%description

%install

if [ -d $RPM_BUILD_ROOT ];
then
  mv /opt/mount2/solutions/pstl_source_code/PSTL-master/pstl-assembly-rpm/target/rpm/pstl-assembly-rpm_2.11/tmp-buildroot/* $RPM_BUILD_ROOT
else
  mv /opt/mount2/solutions/pstl_source_code/PSTL-master/pstl-assembly-rpm/target/rpm/pstl-assembly-rpm_2.11/tmp-buildroot $RPM_BUILD_ROOT
fi

ln -s /usr/share/pstl/bin/pstl $RPM_BUILD_ROOT/usr/bin/pstl
ln -s /usr/share/pstl/conf $RPM_BUILD_ROOT/etc/pstl

%files
%defattr(-,root,root,-)
%attr(755,root,root) "/usr/share/pstl/bin"
%attr(755,root,root)  "/usr/bin/pstl"
%dir %attr(755,root,root) "/usr/share/pstl/conf"
%config(noreplace) %attr(644,root,root)  "/usr/share/pstl/conf/environment.properties"
%config(noreplace) %attr(644,root,root)  "/usr/share/pstl/conf/log4j.properties"
%config(noreplace) %attr(644,root,root)  "/usr/share/pstl/conf/pstl-env.sh"
%config(noreplace) %attr(644,root,root)  "/usr/share/pstl/conf/pstl.conf"
%config(noreplace) %attr(644,root,root)  "/usr/share/pstl/conf/spark.properties"
 "/etc/pstl"
%dir %attr(755,root,root) "/usr/share/pstl/lib"
%attr(644,root,root)  "/usr/share/pstl/lib/pstl_2.11-1.0.0-SNAPSHOT.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/pstl-spark-sql-core_2.11-1.0.0-SNAPSHOT.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/akka-actor_2.11-2.5.4.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/config-1.3.1.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/scala-java8-compat_2.11-0.7.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/akka-slf4j_2.11-2.5.4.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/simpleclient-0.0.26.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/simpleclient_dropwizard-0.0.26.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/metrics-core-3.1.2.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/simpleclient_hotspot-0.0.26.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/simpleclient_httpserver-0.0.26.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/simpleclient_common-0.0.26.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/jopt-simple-5.0.3.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/antlr4-runtime-4.5.3.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/spark-launcher_2.11-2.3.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/spark-tags_2.11-2.3.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/unused-1.0.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/slf4j-api-1.7.16.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/slf4j-log4j12-1.7.16.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/log4j-1.2.17.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/jcl-over-slf4j-1.7.16.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/jul-to-slf4j-1.7.16.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/pstl-spark-sql-avro_2.11-1.0.0-SNAPSHOT.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/avro-1.8.2.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/jackson-core-asl-1.9.13.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/jackson-mapper-asl-1.9.13.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/paranamer-2.7.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/snappy-java-1.1.1.3.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/commons-compress-1.8.1.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/xz-1.5.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/pstl-spark-sql-kafka_2.11-1.0.0-SNAPSHOT.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/kafka-clients-0.10.0.1.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/lz4-1.3.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/pstl-spark-sql-protobuf_2.11-1.0.0-SNAPSHOT.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/protobuf-java-2.5.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/pstl-spark-sql-vertica_2.11-1.0.0-SNAPSHOT.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/jinjava-2.2.10.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/guava-17.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/javassist-3.18.2-GA.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/jsoup-1.8.1.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/commons-lang3-3.4.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/annotations-3.0.0.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/HikariCP-2.7.2.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/vertica-jdbc-connector-8.1.1.7.jar"
%attr(644,root,root)  "/usr/share/pstl/lib/scala-library-2.11.8.jar"
%dir  "/usr/share/pstl/conf/spark_files"
%dir  "/usr/share/pstl/conf/spark_jars"
