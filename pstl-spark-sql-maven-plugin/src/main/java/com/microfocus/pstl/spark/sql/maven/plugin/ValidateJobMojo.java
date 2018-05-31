/*
 *  * (c) Copyright [2018] Micro Focus or one of its affiliates.
 *   *
 *    * Licensed under the Apache License, Version 2.0 (the "License");
 *     * you may not use this file except in compliance with the License.
 *      * You may obtain a copy of the License at
 *       *
 *        * http://www.apache.org/licenses/LICENSE-2.0
 *         *
 *          * Unless required by applicable law or agreed to in writing, software
 *           * distributed under the License is distributed on an "AS IS" BASIS,
 *            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *             * See the License for the specific language governing permissions and
 *              * limitations under the License.
 *               */

package com.microfocus.pstl.spark.sql.maven.plugin;

import com.microfocus.pstl.JobDefinition;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.SparkSession;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

@Mojo(name = "validate-job", defaultPhase = LifecyclePhase.COMPILE)
public class ValidateJobMojo extends AbstractMojo {
    @Parameter(defaultValue = "job.sql", property = "job", required = true)
    private File job;

    @Parameter(property = "sparkProperties")
    private Properties sparkProperties;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if(!job.exists()) {
            throw new MojoFailureException("referenced job does not exist: " + job.toString());
        }

        SparkSession.Builder builder = SparkSession.builder();

        builder.config("spark.app.name", "pstl-spark-sql-maven-plugin");
        builder.config("spark.master", "local[2]");
        builder.config("spark.sql.extensions", "com.microfocus.pstl.spark.SparkSqlExtensions");

        sparkProperties.forEach((key, value) ->
            builder.config(String.valueOf(key), String.valueOf(value)));

        try (SparkSession spark = builder.getOrCreate()) {
            byte[] bytes = Files.readAllBytes(job.toPath());
            String sql = new String(bytes);

            getLog().info("Provided job definition: " + job.toString() + "\n" + sql);

            JobDefinition jobDefinition = new JobDefinition(sql);

            try {
                jobDefinition.parse(spark);
            } catch (AnalysisException e) {
                throw new MojoFailureException(e.getMessage(), e);
            }
        } catch (IOException e) {
            throw new MojoFailureException("unhandled", e);
        }

        try {
            getLog().info(job.getCanonicalPath());
        } catch (IOException e) {
            throw new MojoExecutionException("unhandled", e);
        }
    }
}
