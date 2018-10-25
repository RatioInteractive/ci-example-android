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

package com.example.app

import com.example.app.model.Calculator

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun calculator_EmptyInput() {
        assertEquals(0, calculator.calculate(""))
    }

    @Test
    fun calculator_WrongInput() {
        assertEquals(1, calculator.calculate("A+4"))
        assertEquals(5, calculator.calculate("5xB"))
    }

    @Test
    fun calculator_AdditionIsCorrect() {
        assertEquals(15, calculator.calculate("5+10"))
        assertEquals(19, calculator.calculate("5+4+10"))
    }

    @Test
    fun calculator_MultiplyIsCorrect() {
        assertEquals(20, calculator.calculate("5x4"))
        assertEquals(200, calculator.calculate("5x4x10"))
    }

    @Test
    fun calculator_MathIsCorrect() {
        assertEquals(30, calculator.calculate("5x4+10"))
        assertEquals(45, calculator.calculate("5+4x10"))
        assertEquals(97, calculator.calculate("5+4+10x6+7x3+1+2x3"))
        assertEquals(64916, calculator.calculate("51+41+12x64+72x83+14+22x32x81+90x10+100+42"))
    }
}
