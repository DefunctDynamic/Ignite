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

package org.apache.ignite.internal.processors.query.calcite.metadata;

import org.apache.ignite.internal.processors.query.calcite.prepare.Edge;

/**
 *
 */
public class OptimisticPlanningException extends RuntimeException{
    /** */
    private final Edge edge;

    /**
     *
     * @param message Message.
     * @param edge Edge of query plan, where the exception was thrown.
     * @param cause Cause.
     */
    public OptimisticPlanningException(String message, Edge edge, Throwable cause) {
        super(message, cause);
        this.edge = edge;
    }

    /**
     *
     * @param message Message.
     * @param edge Edge of query plan, where the exception was thrown.
     */
    public OptimisticPlanningException(String message, Edge edge) {
        super(message);
        this.edge = edge;
    }

    /**
     * @return Edge of query plan, where the exception was thrown.
     */
    public Edge edge() {
        return edge;
    }
}