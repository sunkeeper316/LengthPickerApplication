# LengthPickerApplication


* ImperialDialog
--------

![Logo](https://raw.githubusercontent.com/sunkeeper316/LengthPickerApplication/master/IMG/IMG_ImperialDialog.jpg)
* MetricDialog
--------

![Logo](https://raw.githubusercontent.com/sunkeeper316/LengthPickerApplication/master/IMG/IMG_MetricDialog.jpg)


# Gradle
--------

[![](https://jitpack.io/v/sunkeeper316/LengthPickerApplication.svg)](https://jitpack.io/#sunkeeper316/LengthPickerApplication)

Add the jitpack repo to your your project's build.gradle at the end of repositories 

/build.gradle
```groovy
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
```

Then add the dependency to your module's build.gradle:

/app/build.gradle
```groovy
implementation 'com.github.sunkeeper316:LengthPickerApplication:v1.0.1'
```

# How to use
--------
This is the basic usage of a single showcase view, you should check out the sample app for more advanced usage.

```java

	// single example MetricDialog
	new PickerMetricDialogFragment()
                        .setValue(m_value)
                        .setOnValueChangedListener( (view , i_value , m_value) -> {
                            
                        }).setOnOKClickListener((view, i_value, m_value) -> {
                             })
                        .show(getSupportFragmentManager(),PickerMetricDialogFragment.TAG);
                
                
                
                
	// sequence example  ImperialDialog    
    
    new PickerImperialDialogFragment()
                        .setValue(i_value)
                        .setOnValueChangedListener( (view , i_value , m_value) -> {
                            
                             })
                        .setOnOKClickListener((view, i_value, m_value) -> {
                            
                             })
                        .show(getSupportFragmentManager(),PickerImperialDialogFragment.TAG);
	
                
```

[3]: https://code.google.com/p/android-flowtextview/
[4]: https://img.shields.io/github/release/deano2390/MaterialShowcaseView.svg?label=JitPack