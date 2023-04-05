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

package org.apache.ignite.internal.commands.api;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.ignite.internal.commands.impl.CommandUtils;
import static org.apache.ignite.internal.commands.impl.CommandUtils.CMD_WORDS_DELIM;
import static org.apache.ignite.internal.commands.impl.CommandUtils.commandName;

/**
 *
 */
public class CommandWithSubs extends BaseCommand {
    /** */
    private final Map<String, Supplier<Command>> commands = new LinkedHashMap<>();

    /** */
    public Collection<Supplier<Command>> subcommands() {
        return commands.values();
    }

    /** */
    public void register(Supplier<Command> cmd) {
        Command cmdInstance = cmd.get();
        String name = cmdInstance.getClass().getSimpleName();

        if (!name.endsWith(CommandUtils.CMD_NAME_POSTFIX))
            throw new IllegalArgumentException("Command class name must ends with 'Command'");

        commands.put(commandName(cmdInstance.getClass(), CMD_WORDS_DELIM), cmd);
    }

    /** */
    public Command command(String name) {
        return commands.get(name).get();
    }

    /** */
    public boolean positionalSubsName() {
        return true;
    }

    /** */
    public boolean canBeExecuted() {
        return false;
    }

    /** {@inheritDoc} */
    @Override public String description() {
        return null;
    }
}
