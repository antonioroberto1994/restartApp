# restartApp plugin #
This Cordova plugin will reboot automatically your __Android__ app or service.

## Supported Platforms ##
- __Android__

## Usage ##

#### Enable the automatic startup of your app after the boot ####
```typecript
declare let restart: any;
...
restart.restartApp(<time_in_ms>, () => { /*Success callback*/}, (err) => { /*Error callback*/ });
```
## Installation ##
The plugin can be installed from git repository as follows:
```bash
cordova plugin add https://github.com/antonioroberto1994/restartApp.git
```
```bash

