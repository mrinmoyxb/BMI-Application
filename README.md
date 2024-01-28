
# BMI-Application -> Work in Progress
BMI-Application, an Android application built using Kotlin and Jetpack Compose, to calculate the BMI(Body Mass Index) of a person based on age, weight and height provided by the user.
## Objective:
The Body Mass Index, or BMI, is a numerical value used to estimate the amount of body fat you have based on your weight and height. It's a simple formula to calculate, and it's widely used as a first step in assessing potential health risks related to weight.

**``Why BMI is important?``**

* **Simple and easy to use:** We only need our weight and height to calculate our BMI.

* **Estimates overall body fatness:** While not a direct measure of body fat, BMI often correlates with the total amount of fat we carry. This gives a general idea of our potential risk for certain health problems.

* **Helps identify potential health risks:** A high BMI is associated with an increased risk of various chronic conditions, including: Type 2 diabetes, Heart disease, Stroke, Some types of cancer, Musculoskeletal problems.

**Hence, the main objective of this project is to built an Android application, through which we can easily calculate our BMI.**

Therefore, while **``BMI is a valuable tool for initial assessment, it's not a definitive measure of health.``** It's crucial to consider other factors like body composition, family history, and lifestyle habits when evaluating your overall health risk.

## UI/UX

![BMI_App](https://github.com/mrinmoyxb/BMI-Application/assets/141025752/5d0b2807-0428-47f1-9114-e7c8d4fe3482)

## About Application:

**`Android`**

Android is a mobile operating system (OS) primarily designed for touchscreen mobile devices such as smartphones and tablets. It's based on a modified version of the Linux kernel and open-source software, with the most widely used version developed by Google.

**`API level requirements`**
* **minSdk** — The minimum version of the Android platform on which the app will run, specified by the platform's API level identifier. The minSdk required by the application is **minSdk 24**.
* **targetSdk** — The API level on which the app is designed to run. The targetSdk required by the application is **targetSdk 34**

## Key Concepts

**`Design Pattern`**

MVVM stands for Model-View-ViewModel, a software design pattern that helps separate the development of the graphical user interface (GUI) from the development of the business logic or back-end logic (the model). This separation of concerns can make it easier to develop and maintain complex applications.

* **Model**: The model represents the data. It is responsible for storing data, processing data, and providing data to the view. 

* **View**: The view represents the user interface of an application. It is responsible for displaying data to the user and responding to user input.

* **View Model**: The view model is a bridge between the model and the view. It is responsible for translating data from the model into a format that the view can understand. 

**`Navigation`**

Navigation refers to how users move between different screens or destinations within our app. Kotlin, being a modern and expressive language, can greatly enhance the navigation experience through its features and integration with libraries like Jetpack Navigation.
## Language and library:

**`Language: Kotlin`**

Kotlin is a modern, concise programming language that offers offers type safety, extension functions, nullable types, and other features that make code cleaner, more expressive, and less prone to errors compared to Java.

**`Toolkit for UI: Jetpack Compose`**

Jetpack Compose is a declarative UI toolkit, which means instead of writing complex XML layouts, we define our UI in Kotlin code. This declarative approach makes designing UIs more intuitive and visually appealing.
