# JDI with Sauce test project

Before running JDI project in Sauce Lab, you need to set up Sauce Lab Credentials

#### Set Your Sauce Labs Credentials
1. Copy your Sauce Labs **username** and **accessKey** in the [User Settings](https://app.saucelabs.com/user-settings) section of the [Sauce Labs Dashboard](https://app.saucelabs.com/dashboard/builds).
2. Open a Terminal window (command prompt for Windows) and set your Sauce Labs Environment variables:   
   ###### Mac OSX:
   ```
   $ export SAUCE_USERNAME="username"
   $ export SAUCE_ACCESS_KEY="accessKey"
   ```
   ###### Windows:
   ```
   > set SAUCE_USERNAME="username"
   > set SAUCE_ACCESS_KEY="accessKey"
   ```
   > To set an environment variables permanently in Windows, you must append it to the `PATH` variable.
   
   > Go to **Control Panel > System > Windows version > Advanced System Settings > Environment Variables > System Variables > Edit > New**
   
   > Then set the "Name" and "Value" for each variable
   
9. Test the environment variables
    ###### Mac OSX:
    ```
    $ echo $SAUCE_USERNAME
    $ echo $SAUCE_ACCESS_KEY
    ```
    > ***WARNING FOR UNIX USERS!***:
    > If you have problems setting your environment variables, run the following commands in your terminal:
    ```
    $ launchctl setenv SAUCE_USERNAME $SAUCE_USERNAME
    $ launchctl setenv SAUCE_ACCESS_KEY $SAUCE_ACCESS_KEY
    ```
    ###### Windows:
    ```
    > echo %SAUCE_USERNAME%
    > echo %SAUCE_ACCESS_KEY%
    ```

<br />

#### Required Sauce Lab Capabilities

Following capabilities are required for Sauce Lab:
- username - Sauce Lab username
- accessKey - Suace Lab access key
- seleniumVersion - prefered version of Selenium
- name - test run name <br /><br />

Here some optional capabilities:
- maxDuration - how long is the whole test allowed to run
- commandTimeout - the max time allowed to wait for a Selenium command
- idleTimeout - how long can the browser wait for a new command 

More optional capabilities can be found [here](https://github.com/saucelabs-training/demo-java/blob/master/on-boarding-modules/testng/src/test/java/Module4TestNGTest.java)

#### JDI options

In order to run test with Sauce Lab you need set up remote settings in test.properties file.

> run.type=remote
> 
>driver.remote.url=http://ondemand.eu-central-1.saucelabs.com/wd/hub

Remote url should be different if you are from US.

And that it. Set Sauce Lab capabilities, set remote execution in test.properties and you can run test with Sauce Lab
