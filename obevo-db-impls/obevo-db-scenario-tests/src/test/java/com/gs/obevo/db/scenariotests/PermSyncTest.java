/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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
package com.gs.obevo.db.scenariotests;

import com.gs.obevo.db.api.factory.DbEnvironmentFactory;
import com.gs.obevo.db.api.platform.DbDeployerAppContext;
import org.junit.Test;

public class PermSyncTest {
    @Test
    public void testThatDeploySucceedsWithWarningsIfGrantsFail() {
        DbDeployerAppContext dbDeployerAppContext = DbEnvironmentFactory.getInstance()
                .readOneFromSourcePath("scenariotests/permsynctest/step1")
                .buildAppContext()
                .setupEnvInfra().cleanEnvironment();

        dbDeployerAppContext.deploy();

        // TODO add validations around the grants
    }
}
