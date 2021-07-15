# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* The repository contains the framework that is used to automate mobile applications for testing both on Android and iOS

### How do I get set up? ###

--Things to be taken care of before we can actually use the framework--

*Appium setup on Mac for Android*

1. Install homebrew (package manager for macOS and is used to install software packages)
============================================================
Link: https://brew.sh/
Command: /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"


2. Install node and npm (Appium dependencies)
===========================================
Commands to check if node and npm are installed:
node -v
npm -v
Command to install node: brew install node (This will install npm as well)
Command to check node installation path: where node


3. Install Appium server using NPM (Appium CLI)
==============================================
Command to install Appium: npm install -g Appium
Command to check Appium version: appium -v
Command to check Appium installation path: where appium

OR

3. Install Appium server using Appium Desktop client
=================================================
Download link: https://appium.io


4. Install JAVA JDK (not the JRE!)
===========================================================
- Command to check if JAVA is already installed: java -version
- JAVA JDK download link: https://www.oracle.com/technetwork/java/javase/downloads/index.html


5. Install Android Studio
=================================================================
- Android Sutdio download link: https://developer.android.com/studio


6. Set JAVA_HOME and ANDROID_HOME environment variables
=======================================================
Option1 (zprofile - MacOS Catalina default shell is zsh): 
--------------------------------------------------------
-> Navigate to home directory: cd ~/
-> Open zprofile file: open -e .zprofile
-> Create zprofile file: touch .zprofile
-> Add below entries:
export JAVA_HOME=$(/usr/libexec/java_home)
export ANDROID_HOME=${HOME}/Library/Android/sdk
export PATH="${JAVA_HOME}/bin:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${PATH}"
-> source .zprofile

Option2 (zprofile and bashprofile):
----------------------------------
-> Navigate to home directory: cd ~/
-> Open bash profile file: open -e .bash_profile
-> Create bash profile: touch .bash_profile
-> Add below entries:
export JAVA_HOME=$(/usr/libexec/java_home)
export ANDROID_HOME=${HOME}/Library/Android/sdk
export PATH="${JAVA_HOME}/bin:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${PATH}"
-> Open zprofile file: open -e .zprofile
-> Create zprofile file: touch .zprofile
-> add this line: source .bash_profile
echo $JAVA_HOME
echo $ANDROID_HOME
echo $PATH

7. Verify installation using appium-doctor
==========================================
- Command to install appium-doctor: npm install -g appium-doctor
- Command to get appium-doctor help: appium-doctor --help
- Command to check Android setup: appium-doctor --android 


8. Emulator Setup: Create AVD and start it
==========================================
Open Android Studio
Click Configure option
Click "AVD Manager" option
Click "Create Virtual Device" button
Select the phone model
Download the Image for desired OS version if not already downloaded
Start AVD

9. Emulator Setup: Create driver session with the AVD using Appium Inspector
============================================================================
Download link for dummy app:
https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk

Note: If using Appium desktop, might get error with adb tool because Appium Desktop 
cannot read ANDROID_HOME and JAVA_HOME path from the zsh/bash profile. 
To resolve, set ANDROID_HOME to SDK path and JAVA_HOME to Java home path using "Edit Configurations" option 
while launching the Appium Desktop.

10. Real Device Setup: Enable USB debugging on Android mobile
============================================================
On your phone,
Go to Settings
Click System option
Click "About Phone" option
Click on "Build Number" 7 to 8 times
Go back to Settings
Open Developer Options
Enable "USB Debugging"

11. Real Device Setup: Create driver session using Appium Inspector
===================================================================
Download link for dummy app:
https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk

Note: If using Appium desktop, might get error with adb tool because Appium Desktop 
cannot read ANDROID_HOME path from the zsh/bash profile. 
To resolve, set ANDROID_HOME to SDK path using "Edit Configurations" option 
while launching the Appium Desktop.

*Appium setup on Mac for Android*


Step1: Install homebrew [package manager for macOS and is used to install software packages]
======================================================================================
Link: https://brew.sh/
Command: /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

Step2: Install node and npm [Appium dependencies]
===============================================
Commands to check if node and npm are installed:
node -v
npm -v
Command to install node: brew install node [This will install npm as well]
Command to check node installation path: where node or which node

Step3: Install Appium server using NPM (Appium CLI)
===================================================
Command to install Appium: npm install –g appium
Command to check Appium version: appium -v
Command to check Appium installation path: where appium or which Appium

Step4: Install Appium server using Appium Desktop client
=======================================================
Download link: https://appium.io

Step5: Install Xcode
====================
Configure Apple ID in Account preferences
Install from App Store

Step6: Install Xcode command line tools
======================================
Command: xcode-select --install

Step7: Install xcpretty [to make Xcode output reasonable]
========================================================
Command to install xcpretty: gem install xcpretty

Step8: Install Carthage [dependency manager, required for WebDriverAgent]
==================================================================
Command to install Carthage: brew install Carthage

Step9: Install Appium-doctor and check Appium setup
===================================================
Command to install Appium doctor: npm install -g appium-doctor
Command to get help: appium-doctor --h
Command to check setup for iOS: appium-doctor --ios

Step10: Build UIKitCatalog app for simulator
===========================================
Download link: https://github.com/appium/ios-uicatalog
Command to get simulator name: xcodebuild -showsdks
Command to build app for the simulator: xcodebuild -sdk <simulator_name>
Command to build UIKitCatalog app for simulator: npm install

Step11:Start session with UIKitCatalog app using Appium Desktop/Appium CLI
=========================================================================
Command to get UDID: instruments -s devices


=================================================================
                       Real device setup
=================================================================

Getting UDID
=============
Command to install ios-deploy: npm install -g ios-deploy
Command to get UDID: ios-deploy -c
OR
Command to get UDID: instruments -s devices


1. Code signing WebDriverAgent: Basic (automatic/manual) configuration.
======================================================================

Step 1. Enroll for Developer program
- Create Apple account: https://developer.apple.com
- Enable two factor authentication: https://appleid.apple.com/account/manage
- Click Join the Apple Developer program
- Click Enroll
- Click Start Your Enrollment

Step 2. Register device UDID on the developer portal (this can be done from Xcode as well)

Step 3. Add your Apple ID (paid developer account) to XCode and download the certificate (if required, create new certificate on the developer portal)

Step 4. Generate UIKitCatalog IPA:
- Download UIKitCatalog app from https://github.com/appium/ios-uicatalog
- Launch project and code sign using Xcode managed provisioning profile
- Confirm wild card provisioning profile is created in the developer account
- (select generic iOS device) Archive app to generate IPA

Step 5. Create session with app using Appium Desktop server as well as CLI server
- Launch Appium Desktop, open inspector session, Set desired capabilities
"xcodeOrgId": "your team id"
"xcodeSigningId": "iPhone Developer"
- Launch Appium Desktop, open inspector session, point to CLI server, Set desired capabilities
"xcodeOrgId": "your team id"
"xcodeSigningId": "iPhone Developer"

2. Code signing WebDriverAgent: Full manual configuration path
==============================================================
Step 1. Add your Apple ID to XCode and download the certificate

Step 2. Find WebDriverAgent project
We will use Appium CLI version for test execution and point Appium Desktop to use CLI server for inspecting the app.
In terminal, execute command:
    $ where appium or which Appium
    /path/where/installed/bin/appium
WebDriverAgent project path:
Appium CLI:/path/where/installed/lib/node_modules/appium/node_modules/appium-webdriveragent
Appium Desktop: /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-webdriveragent

Step 3. Navigate to WebDriverAgent project path in terminal and run below command to setup the project

mkdir -p Resources/WebDriverAgent.bundle
    ./Scripts/bootstrap.sh -d

Step 4. Open WebDriverAgent.xcodeproj in Xcode. For both the WebDriverAgentLib and WebDriverAgentRunner targets, select "Automatically manage signing" in the "General" tab, and then select your Development Team. This should also auto select Signing Certificate. 

Step 5. Manually change the bundle id for the target by going into the "Build Settings" tab, and changing the "Product Bundle Identifier" from com.facebook.WebDriverAgentRunner to 
something that Xcode will accept (something really unique!)

Step 6. Command to build the project:
xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=<udid>' test -allowProvisioningUpdates

Step 7. Create session with app using Appium Inspector pointing to CLI server

*Appium setup on Windows for Android*

Emulator and real device
Important notes: 
- Always use latest versions of node, npm, with Appium!
- Be admin on your Windows!


Step 1: Install Appium using NPM (Appium CLI)
============================================
-> Commands to check if node and NPM are installed:
node -v
npm -v
-> Install node.js (NPM is included) from link - https://nodejs.org/en/download/
-> Command to install Appium using npm: npm install -g appium
-> Command to start Appium: appium
-> Command to uninstall Appium: npm uninstall -g appium


Step 2: Install Appium using Appium Desktop
===========================================
-> Download and install Appium Desktop from https://appium.io


Step 3: Install JAVA JDK and configure environment variables
===========================================================
Note: Install JDK and not JRE!
-> Command to check if JAVA is already installed: java -version
-> JAVA JDK download link: https://www.oracle.com/technetwork/java/javase/downloads/index.html
Note: x86 or x64? Go to "Control Panel\System and Security\System" or execute "set pro" in CMD prompt
-> Create JAVA_HOME system environment variable and set it to JDK path (without bin folder). 
Edit PATH system environment variable and add %JAVA_HOME%\bin
Note: Usually JDK path is "C:\Program Files\Java\<your_jdk_version>"
-> JAVA 8 Installation instructions on Windows:
https://docs.oracle.com/javase/8/docs/technotes/guides/install/windows_jdk_install.html#CHDEBCCJ


Step 4: Install Android Studio and configure environment variables
=================================================================
-> Android Sutdio download link: https://developer.android.com/studio
-> Create ANDROID_HOME system environment variable and set it to SDK path. 
Edit PATH system environment variable and add below,
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\tools
%ANDROID_HOME%\tools\bin


Step 5: Verify installation using appium-doctor
===============================================
Command to install appium-doctor: npm install -g appium-doctor
Command to get appium-doctor help: appium-doctor --help
Command to check Android setup: appium-doctor --android 


Step 6: Emulator Setup: Create AVD and start it 
================================================
Open Android Studio -> Configure -> AVD Manager -> Create Virtual Device -> 
Select Model -> Download Image for desired OS version if not already downloaded 
-> Start AVD


Step 7: Emulator Setup: Create Driver Session using Appium Desktop
==================================================================
Download link for dummy app:
https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk


Step 8: Real Device Setup: Enable USB debugging on Android mobile
==================================================================
Note: Steps can differ based on the phone manufacturer!
-> Settings -> System -> About Phone -> Click Build Number 7-8 times
-> Settings -> Developer Options -> Enable USB Debugging
-> Permission pop-up: Check the box and press Allow to recognize the computer
-> run "adb devices" in CMD prompt to check if device is recognized
-> USB drivers:
Google: https://developer.android.com/studio/run/win-usb
OEMs: https://developer.android.com/studio/run/oem-usb


Step 9: Real Device Setup: Create Driver Session using Appium Desktop
====================================================================
Download link for dummy app:
https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk

### Contribution guidelines ###

* Writing tests -- Will be updated in the near future
* Code review -- Will be updated in the near future

### Who do I talk to? ###

* Abhinav Dharmapuri(abhinav.dharmapuri@americam-technology.net)
* Uman Niyaz(uman.niyaz@american-technology.net)