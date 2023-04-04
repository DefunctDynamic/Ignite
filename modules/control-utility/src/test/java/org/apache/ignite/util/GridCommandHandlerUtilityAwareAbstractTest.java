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

package org.apache.ignite.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import org.apache.ignite.IgniteLogger;
import org.apache.ignite.internal.commandline.CommandHandler;
import org.apache.ignite.internal.commands.api.CLICommandFrontend;
import org.apache.ignite.internal.commands.impl.CLICommandFrontendImpl;
import org.apache.ignite.testframework.junits.common.GridCommonAbstractTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Utility aware test class.
 */
@RunWith(Parameterized.class)
public class GridCommandHandlerUtilityAwareAbstractTest extends GridCommonAbstractTest {
    /** Cli factory. */
    @Parameterized.Parameter
    public Function<IgniteLogger, CLICommandFrontend> cli;

    /** */
    @Parameterized.Parameters(name = "cli={0}")
    public static Collection clis() {
        return Arrays.<Function<IgniteLogger, CLICommandFrontend>>asList(
            new Function<IgniteLogger, CLICommandFrontend>() {
                @Override public CLICommandFrontend apply(IgniteLogger igniteLogger) {
                    return new CommandHandler(igniteLogger);
                }

                @Override public String toString() {
                    return "control.sh";
                }
            },
            new Function<IgniteLogger, CLICommandFrontend>() {
                @Override public CLICommandFrontend apply(IgniteLogger igniteLogger) {
                    return new CLICommandFrontendImpl(igniteLogger);
                }

                @Override public String toString() {
                    return "ignite-cli.sh";
                }
            }
        );
    }
}
