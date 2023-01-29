[![Maven Central](https://img.shields.io/maven-central/v/com.saadahmedev.helper-widget/helper-widget.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.saadahmedev.helper-widget%22%20AND%20a:%22helper-widget%22)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
<a href="https://android-arsenal.com/api?level=16"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
<a href="https://github.com/saadahmedscse/shortintent"><img alt="API" src="https://badges.frapsoft.com/os/v1/open-source.png?v=103"/></a>
<a href="https://github.com/saadahmedscse/shortintent/graphs/traffic"><img alt="Total Clones" src="https://img.shields.io/badge/Clones-156-orange"/></a>
<a href="[https://github.com/rrsaikat/CodeChallengeByShikho/graphs/traffic](https://github.com/saadahmedscse/shortintent/graphs/traffic)"><img alt="Total Views" src="https://img.shields.io/badge/Views-312-brightgreen"/></a>

# Android Helper Widgets
Getting tired by designing a lot of XML Drawable files, importing library for modification? Android Helper Widget is a lightweight and easy to use Android library that provides you a lot of attributes to create any kind of design in your root XML file. You don't have to create ab XML drawable file. You can easily design anything in XML layout file with the attributes I've provided.
* Min SDK 16 (Android Alpha 1.0)
* Written in Java
* Compatible for both Java and Kotlin

## Features
* Custom View
* Custom ImageView
* Custom TextView
* Custom EditText
* Custom LinearLayout
* Custom RelativeLayout
* Custom ConstraintLayout
* Custom RecyclerView

## Installation

Add the dependency to your module build.gradle:
```groovy
dependencies {
    ...
    implementation 'com.saadahmedev.helper-widget:helper-widget:1.0.1'
}
```

## Usage

### Attributes

| Attributes  | View               |  ImageView  |  TextView  |  EditText  |  LinearLayout  |  RelativeLayout  |  ConstraintLayout  |  RecyclerView  |
| ----------- | ------------------ | ----------- | ---------- | ---------- | -------------- | ---------------- | ------------------ | -------------- |
|fontColor| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|backgroundColor| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|rippleColor| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|strokeColor| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|shape| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|strokeWidth| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|clickable| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|fontFam| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|cornerRadius| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|topLeftCornerRadius| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|topRightCornerRadius| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|bottomRightCornerRadius| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|bottomLeftCornerRadius| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|setupLayoutManager| :x: | :x: | :x: | :x: | :x: | :x: | :x: | :white_check_mark:|
|gridCount| :x: | :x: | :x: | :x: | :x: | :x: | :x: | :white_check_mark:|

### Functions

|  Functions  | View               |  ImageView  |  TextView  |  EditText  |  LinearLayout  |  RelativeLayout  |  ConstraintLayout  |  RecyclerView  |
| ----------- | ------------------ | ----------- | ---------- | ---------- | -------------- | ---------------- | ------------------ | -------------- |
|getStringValue()| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|getTrimmedStringValue()| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|getIntValue()| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|getDoubleValue()| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|getFloatValue()| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|getShortValue()| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|getBooleanValue()| :x: | :x: | :white_check_mark: | :white_check_mark: | :x: | :x: | :x: | :x:|
|enable()| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|disable()| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|visible()| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|invisible()| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|gone()| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|onClicked()| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|onLongPressed()| :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:|
|isValidEmail()| :x: | :x: | :x: | :white_check_mark: | :x: | :x: | :x: | :x:|
