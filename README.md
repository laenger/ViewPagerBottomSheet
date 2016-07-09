# ViewPagerBottomSheet

Use ViewPagers in Bottom Sheets!

## Example

This repository features an example app that demonstrates nested ViewPagers inside a bottom sheet:

![Example App](assets/viewpager.gif)

## Use for your project

Add the maven repo url to your `build.gradle`:

```groovy
repositories {
    maven { url "https://raw.github.com/laenger/maven-releases/master/snapshots" }
}
```

Add the library to the dependencies:

```groovy
dependencies {
    compile "biz.laenger.android:vpbs:0.0.1-SNAPSHOT"
}
```

Use `ViewPagerBottomSheetBehavior` for your bottom sheet view:
```
app:layout_behavior="@string/view_pager_bottom_sheet_behavior"
```

Setup any nested `ViewPager` inside the bottom sheet:
```
BottomSheetUtils.setupViewPager(bottomSheetViewPager)
```
(This also works when the ViewPager _is_ the bottom sheet view and for further nested ViewPagers)
