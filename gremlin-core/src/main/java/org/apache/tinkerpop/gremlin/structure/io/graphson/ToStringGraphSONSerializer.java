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
package org.apache.tinkerpop.gremlin.structure.io.graphson;

import org.apache.tinkerpop.shaded.jackson.core.JsonGenerator;
import org.apache.tinkerpop.shaded.jackson.databind.SerializerProvider;
import org.apache.tinkerpop.shaded.jackson.databind.jsontype.TypeSerializer;
import org.apache.tinkerpop.shaded.jackson.databind.ser.std.ToStringSerializer;

import java.io.IOException;

/**
 * A different implementation of the {@link ToStringSerializer} that does not serialize types by calling
 * `typeSerializer.writeTypePrefixForScalar()` for unknown objects, because it doesn't make sense when there is a
 * custom types mechanism in place.
 *
 * @author Kevin Gallardo (https://kgdo.me)
 */
public class ToStringGraphSONSerializer extends ToStringSerializer {
    @Override
    public void serializeWithType(final Object value, final JsonGenerator gen, final SerializerProvider provider,
                                  final TypeSerializer typeSer) throws IOException {
        this.serialize(value, gen, provider);
    }

}
