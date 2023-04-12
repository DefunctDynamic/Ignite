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

package org.apache.ignite.internal.management;

import java.util.Map;
import org.apache.ignite.internal.management.api.Command;
import org.apache.ignite.internal.management.api.CommandWithSubs;
import org.apache.ignite.internal.visor.metric.VisorMetricTask;

/**
 *
 */
public class MetricCommand extends CommandWithSubs implements Command<MetricCommandArg, Map<String, Object>, VisorMetricTask> {
    /** */
    public MetricCommand() {
        register(MetricConfigureHistogramCommand::new);
        register(MetricConfigureHitrateCommand::new);
    }

    /** {@inheritDoc} */
    @Override public String description() {
        return "Print metric value";
    }

    /** {@inheritDoc} */
    @Override public Class<MetricCommandArg> args() {
        return MetricCommandArg.class;
    }

    /** {@inheritDoc} */
    @Override public Class<VisorMetricTask> task() {
        return VisorMetricTask.class;
    }
}
