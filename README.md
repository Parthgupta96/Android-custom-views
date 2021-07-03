# Android-custom-views
playing around with custom View and Viewgroups in android

## Observations
1. OnMeasure called
   - 4 times when child is placed in ConstraintLayout(if view has any dimention as 0dp) or relativeLayout or LinearLayout(when any dim 0 and weight is given) 
   - 2 timwes in LinearLayout and Frame Layout
   - In LL when either one dimen is 0dp onMeasure is called with UNSPECIFIED mode and size is parent max size on first pass and with EXACTLY in second pass
   - RL same as LL on first pass height mode is AT_MOST and EXACTLY in second
   
2. 
