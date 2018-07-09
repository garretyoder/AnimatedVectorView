# AnimatedVectorView
![Preivew Gif](https://raw.githubusercontent.com/garretyoder/AnimatedVectorView/master/bounce.gif)
# Building
Add jitpack to your maven sources
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
Add the library as a dependency to your `build.gradle`
```groovy
dependencies {
    implementation 'com.github.garretyoder:'
}
```
# Usage
## XML
```xml
<io.multimoon.animatedvectorview.AnimatedVectorView
    android:layout_width="100dp"
    android:layout_height="wrap_content"
    android:adjustViewBounds="true"
    app:vectorSrc="@drawable/bounce"
    android:tint="#fff"/>
```
As demonstrated in the example, the view behaves just like a image view, it is tintable and adjustable. use the `vectorSrc` attribute to set the animated vector drawable.
## Code
Use `AnimatedVectorView).setVectorSrc(drawableRes: Int)` to set the AnimatedVector drawable
