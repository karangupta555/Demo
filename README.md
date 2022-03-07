# Getting Started

## Install Homebrew

-   Package manager for macOS and is used to install software packages
-   Install it from [here](https://brew.sh/)
-   or through **Command**:

    ```sh
    /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
    ```

## Install Node.js and npm

-   Install Node.js from [here](https://nodejs.org/en/)

-   Then Open terminal

    ```sh
    # install
    npm install -g npm

    # verify
    node -v
    npm -v
    ```

    Or

-   Install through HomeBrew

    ```sh
    # install
    brew install node

    # verify
    node -v

    # path
    where node
    ```

## Install Appium server using NPM (Appium CLI)

    ```sh
    # install
    npm install -g appium

    # verify
    appium -v

    # path
    where appium
    ```

## Install Appium Desktop/Inspector

-   Install Appium Inspector from [Here](https://github.com/appium/appium-inspector/releases)
-   Appium Desktop is not mandatory, as it used to start a server that we can do from terminal(already installed in above step).(If you want you can install)

## Install JAVA JDK

-   Any JDK version will work, If don't have any follow steps from [here](https://www.guru99.com/install-java.html)

## Install Android Studio

  <!-- Helpful to launch Android Emulator -->

-   Android Studio download from [here](https://developer.android.com/studio)

## Set environment variables

-   If there is already `.zshrc` file created in your system, the skip this step, else create it:

    ```sh
    # create
    touch ~/.zshrc
    ```

-   Open `.zshrc` file to include environment variables, open terminal and run below command

    ```sh
    # open file
    nano ~/.zshrc
    ```

-   And now, Add this below lines to the editor.

    ```sh
    # adding environment variables
    export ANDROID_HOME=/YOUR_PATH_TO/android-sdk
    export PATH=$PATH:$ANDROID_HOME/platform-tools
    export PATH=$PATH:$ANDROID_HOME/tools
    export PATH=$PATH:$ANDROID_HOME/tools/bin
    export PATH=$PATH:$ANDROID_HOME/emulator
    ```

-   Save it and close the editor/file. Now, Reopen terminal and check if it worked:

    ```sh
    # verify
    source ~/.zshrc
    echo $ANDROID_HOME
    ```

**Note**: _You can follow similar pattern for adding environment variables for any other setup._

**Note:** _If you have to add this environment variables to different files like `zprofile` or `.bash_profile`, It will be a similar pattern, but follow any blog or stackoverflow._

## Verify installation using appium-doctor

find more about [Appium Doctor](https://github.com/appium/appium-doctor)

    ```sh
    # install
    npm install -g appium-doctor

    # verify
    appium-doctor -h
    ```

## Emulator Setup

#### Android

-   Create a Virtual Device for Android from [here](https://www.geeksforgeeks.org/how-to-install-android-virtual-deviceavd/)

#### iOS

<!-- To Launch iOS Simulator/Emulator -->

-   Launch Xcode > Open Developer Tool > Simulator.

## Appium Inspector

-   Open Appium Inspector or Appium Desktop and start a server and inspect the application.

### Not Required

Install xcpretty [to make Xcode output reasonable]

-   install xcpretty: gem install xcpretty

Install Carthage [dependency manager, required for WebDriverAgent]

-   Command to install Carthage: brew install Carthage

## Commands

```sh
# list of available emulators
emulator -list-avds

# Know the UDID of Connected emulators/devices
adb devices

# uninstall driver on device
adb uninstall io.appium.uiautomator2.server
adb uninstall io.appium.uiautomator2.server.test
adb uninstall io.appium.unlock
adb uninstall io.appium.settings
```
