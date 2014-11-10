/**
 * JavaScript App Lancher:
 * 1. Load modularization system module (CommonJS/RequireJS)
 * 2. Load app start module (by using modularization system)
 * 3. Execute app start module/object
 */

// 1.
// phantom.page.injectJs('./common.js');
// var APP = phantom.injectJs('./common.js');

// 2.
var APP = require('./app.js');

// 3.
APP.main();

//Exit
if(typeof phantom != "undefined")
	phantom.exit();