/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.commands.snapshot;

import lombok.Data;
import org.apache.ignite.internal.commands.api.BaseCommand;
import org.apache.ignite.internal.commands.api.OneOf;
import org.apache.ignite.internal.commands.api.Parameter;

/**
 *
 */
@Data
@OneOf({"id", "name"})
public class SnapshotCancelCommand extends BaseCommand {
    /** */
    @Parameter(description = "Snapshot operation request ID")
    private String id;

    /** */
    @Parameter(description = "Snapshot name (deprecated)")
    private String name;

    /** {@inheritDoc} */
    @Override public String description() {
        return "Cancel running snapshot operation";
    }
}
