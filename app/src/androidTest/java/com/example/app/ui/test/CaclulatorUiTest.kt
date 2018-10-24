/*
 * Copyright 2018 Globant. All rights reserved.
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

package com.example.app.ui.test

import androidx.test.rule.ActivityTestRule
import com.example.app.R.id.*
import com.example.app.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class CalculatorUiTest {
    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private val steps = UiTestSteps()
    private val expected = Verifier()

    @Test
    fun twoPlusTwoIsFour() {
        steps
                .type(2)
                .tapPlus()
                .type(2)
                .tapEquals()

        expected
                .inputFieldMatches("2+2")
                .outputFieldMatches("4")
    }

    @Test
    fun clearFields() {
        steps
                .type(2)
                .tapPlus()
                .type(2)
                .tapEquals()
                .tapClear()

        expected
                .inputFieldMatches("")
                .outputFieldMatches("")
                .viewIsDisabled(button_clear)
                .viewIsDisabled(button_multiply)
                .viewIsDisabled(button_plus)
    }
}
