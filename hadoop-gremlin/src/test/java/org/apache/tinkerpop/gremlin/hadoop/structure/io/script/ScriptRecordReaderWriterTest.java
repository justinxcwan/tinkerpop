/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.gremlin.hadoop.structure.io.script;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.tinkerpop.gremlin.hadoop.HadoopGraphProvider;
import org.apache.tinkerpop.gremlin.hadoop.structure.io.RecordReaderWriterTest;
import org.apache.tinkerpop.gremlin.hadoop.structure.io.VertexWritable;

import java.io.File;

/**
 * @author Daniel Kuppitz (http://gremlin.guru)
 */
public class ScriptRecordReaderWriterTest extends RecordReaderWriterTest {

    @Override
    protected Configuration configure(final File outputDirectory) {
        final Configuration configuration = super.configure(outputDirectory);
        configuration.set(ScriptRecordReader.SCRIPT_FILE, HadoopGraphProvider.PATHS.get("script-input-grateful-dead.groovy"));
        configuration.set(ScriptRecordWriter.SCRIPT_FILE, HadoopGraphProvider.PATHS.get("script-output-grateful-dead.groovy"));
        return configuration;
    }

    @Override
    protected String getInputFilename() {
        return "grateful-dead.txt";
    }

    @Override
    protected Class<? extends InputFormat<NullWritable, VertexWritable>> getInputFormat() {
        return ScriptInputFormat.class;
    }

    @Override
    protected Class<? extends OutputFormat<NullWritable, VertexWritable>> getOutputFormat() {
        return ScriptOutputFormat.class;
    }
}