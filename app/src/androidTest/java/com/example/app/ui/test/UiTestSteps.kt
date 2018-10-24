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

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId

import com.example.app.R.id.button_clear
import com.example.app.R.id.button_eight
import com.example.app.R.id.button_equals
import com.example.app.R.id.button_five
import com.example.app.R.id.button_four
import com.example.app.R.id.button_multiply
import com.example.app.R.id.button_nine
import com.example.app.R.id.button_one
import com.example.app.R.id.button_plus
import com.example.app.R.id.button_seven
import com.example.app.R.id.button_six
import com.example.app.R.id.button_three
import com.example.app.R.id.button_two
import com.example.app.R.id.button_zero

class UiTestSteps {

    fun tapClear(): UiTestSteps {
        onView(withId(button_clear)).perform(click())
        return this
    }

    fun tapEquals(): UiTestSteps {
        onView(withId(button_equals)).perform(click())
        return this
    }

    fun tapPlus(): UiTestSteps {
        onView(withId(button_plus)).perform(click())
        return this
    }

    fun tapTimes(): UiTestSteps {
        onView(withId(button_multiply)).perform(click())
        return this
    }

    fun type(number: Int): UiTestSteps {
        number.toString().toCharArray().forEach {
            val viewId = getViewIdForChar(it)
            onView(withId(viewId)).perform(click())
        }

        return this
    }

    private fun getViewIdForChar(char: Char): Int {
        when (char) {
            '0' -> return button_zero
            '1' -> return button_one
            '2' -> return button_two
            '3' -> return button_three
            '4' -> return button_four
            '5' -> return button_five
            '6' -> return button_six
            '7' -> return button_seven
            '8' -> return button_eight
            '9' -> return button_nine
        }

        return -1
    }
}
