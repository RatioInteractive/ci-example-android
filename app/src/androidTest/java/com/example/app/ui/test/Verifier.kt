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

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.app.R
import org.hamcrest.Matchers

class Verifier {
    fun inputFieldMatches(number: String): Verifier {
        textFieldMatches(number, R.id.text_input)
        return this
    }

    fun outputFieldMatches(number: String): Verifier {
        textFieldMatches(number, R.id.text_output)
        return this
    }

    private fun textFieldMatches(number: String, @IdRes idRes: Int) {
        Espresso.onView(ViewMatchers.withId(idRes)).check(ViewAssertions.matches(ViewMatchers.withText(number)))
    }

    fun viewIsDisabled(@IdRes idRes: Int): Verifier {
        Espresso.onView(ViewMatchers.withId(idRes)).check(isDisabled())
        return this
    }

    private fun isDisabled(): ViewAssertion = ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled()))
}
