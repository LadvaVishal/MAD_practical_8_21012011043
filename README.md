# MAD_practical_8_21012011043

AIM:What is BroadcastReceiver? Difference between Service and BroadcastReceiver. Create an Alarm application by using service & BroadcastReceiver by following below instructions.

Create MainActivity according to below UI design.

Create AlarmBroadcastReceiver class

Create AlarmService Class

Add android.permission.SCHEDULE_EXACT_ALARM Permission in Manifest file

**ANS:**
->Broadcast Receivers allow us to register for the system and application events, and when that event happens, then the register receivers get notified.

Different:
-> Service can continue running in the background, whereas a Broadcast Receiver should finish quickly (e.g. if it is running for more than 5 seconds it may be 
   killed by the OS). The Broadcast Receiver can still run in the background (when app is closed) under certain circumstances.

Output:

![image](https://github.com/LadvaVishal/MAD_practical_8_21012011043/assets/113240232/646c8627-3dc6-4cd8-ba9b-cf2e5f753072)

![image](https://github.com/LadvaVishal/MAD_practical_8_21012011043/assets/113240232/54008c50-e088-4c17-9f7f-d7c2313c3628)

