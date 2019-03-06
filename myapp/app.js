const http = require('http');
const os = require('os');

console.log('my server starting...');

var handler = function(req, res) {
  console.log('received request from ' + req.connection.remoteAddress);
  res.writeHead(200);
  res.end("version 1: You've hit " + os.hostname() + '\n');
};

var www = http.createServer(handler);
www.listen(8080);
