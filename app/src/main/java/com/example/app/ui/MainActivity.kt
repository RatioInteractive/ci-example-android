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

package com.example.app.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.model.Calculator

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val calculator = Calculator()

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.layoutContent.viewHandler = this
        setSupportActionBar(toolbar)
    }

    fun onButtonPress(view: View) {
        when (view.id) {
            R.id.button_one, R.id.button_two, R.id.button_three, R.id.button_four, R.id.button_five,
            R.id.button_six, R.id.button_seven, R.id.button_eight, R.id.button_nine, R.id.button_zero -> {
                text_input.append((view as TextView).text)
                button_clear.isEnabled = true
                button_equals.isEnabled = true
                button_plus.isEnabled = true
                button_multiply.isEnabled = true
            }
            R.id.button_plus, R.id.button_multiply -> {
                text_input.append((view as TextView).text)
                button_clear.isEnabled = true
                button_equals.isEnabled = false
                button_plus.isEnabled = false
                button_multiply.isEnabled = false
            }
            R.id.button_equals -> {
                text_output.text = calculator.calculate(text_input.text).toString()
            }
            R.id.button_clear -> {
                text_input.text = ""
                text_output.text = ""
                button_clear.isEnabled = false
                button_equals.isEnabled = false
                button_plus.isEnabled = false
                button_multiply.isEnabled = false
            }
        }
    }
}
