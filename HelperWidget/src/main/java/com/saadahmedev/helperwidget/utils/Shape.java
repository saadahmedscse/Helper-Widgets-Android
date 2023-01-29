/*
 * Copyright 2018-2023 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedev.helperwidget.utils;

public enum Shape {
    ROUNDED_5DP(5F),
    ROUNDED_10DP(10F),
    ROUNDED_15DP(15F),
    ROUNDED_20DP(20F),
    ROUNDED_25DP(25F),
    ROUNDED_30DP(30F),
    ROUNDED_35DP(35F),
    ROUNDED_40DP(40F),
    ROUNDED_45DP(45F),
    ROUNDED_50DP(50F),
    OVAL(0F),
    RING(0F),
    NORMAL(0F);

    private final Float value;

    Shape(Float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
