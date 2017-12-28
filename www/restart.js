var exec = require('cordova/exec');

exports.restartApp = function (time, success, error) {
    exec(success, error, 'restart', 'restartApp', [time]);
};
