/*
 * Copyright 1999-2017 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.p3c.idea.util

import com.intellij.codeHighlighting.HighlightDisplayLevel

/**
 *
 *
 * @author caikang
 * @date 2017/02/04
 */
object HighlightDisplayLevels {
    val BLOCKER = HighlightDisplayLevel(HighlightSeverities.BLOCKER, HighlightDisplayLevel.ERROR.icon)
    val CRITICAL = HighlightDisplayLevel(HighlightSeverities.CRITICAL, HighlightDisplayLevel.WARNING.icon)
    val MAJOR = HighlightDisplayLevel(HighlightSeverities.MAJOR, HighlightDisplayLevel.WEAK_WARNING.icon)
    val WARNING = HighlightDisplayLevel(HighlightSeverities.WARNING, HighlightDisplayLevel.WEAK_WARNING.icon)
    val WEAK_WARNING = HighlightDisplayLevel(HighlightSeverities.WEAK_WARNING, HighlightDisplayLevel.WEAK_WARNING.icon)
}
