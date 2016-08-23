# ViewPagerBottomSheet

Use ViewPagers in Bottom Sheets!

## Example

This repository features an example app that demonstrates nested ViewPagers inside a bottom sheet:

![Example App](assets/viewpager.gif)

## Use for your project

Add the maven repo url to your `build.gradle`:

```groovy
repositories {
    maven { url "https://raw.github.com/laenger/maven-releases/master/releases" }
}
```

Add the library to the dependencies:

```groovy
dependencies {
    compile "biz.laenger.android:vpbs:0.0.2"
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

## How does this work?

`ViewPagerBottomSheetBehavior` is essentially identical to the original `BottomSheetBehavior` from the Design Support Library but adds important details: ViewPagers are now properly handled when finding the scrolling child, and this reference can be updated on ViewPager page changes. See the key diff in this commit: [2775715](https://github.com/laenger/ViewPagerBottomSheet/commit/277571585500b8c1ed4ed444a5bd250b981c47fc)
