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
package com.gs.obevo.db.impl.platforms.sybaseiq;

import com.gs.obevo.api.appdata.Change;
import com.gs.obevo.db.impl.platforms.sqltranslator.PostParsedSqlTranslator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

public class IqToInMemorySqlTranslator implements PostParsedSqlTranslator {
    // Sybase allows a wide range of formats, so we parse for them
    public static final ImmutableList<String> ACCEPTED_DATE_FORMATS = Lists.immutable.with(
            "dd MMM yyyy HH:mm:ss",
            "MMM dd yyyy",
            "yyyyMMdd",
            "dd/MM/yyyy"
    );

    @Override
    public String handleAnySqlPostTranslation(String string, Change change) {
        return string.replaceAll("(?i)getdate\\(\\)", "CURRENT_DATE");
    }
}
