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

package com.example.app.model

class Calculator {

    fun calculate(input: CharSequence): Int {
        if (input.isEmpty()) {
            return 0
        }

        var result = 0

        val plus = input.split("+").toTypedArray()

        for (item in plus) {
            val times = item.split("x").toTypedArray()

            if (times.size > 1) {
                var product = 1

                for (num in times) {
                    product *= Integer.parseInt(num)
                }

                result += product
            } else {
                result += Integer.parseInt(times[0])
            }
        }

        return result
    }
}