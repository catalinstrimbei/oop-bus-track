/**
 * Web JavaScript App on NodeJS
 * Launch http://localhost:8080/ in browser!
 * 
 */
var http = require('http');

var server = http.createServer(function(req, res) {
  res.writeHead(200);
  res.end('Hello JavaScript Web App!');
});
server.listen(8080);
console.log("Web JavaScript App available on http://localhost:8080/ !");
