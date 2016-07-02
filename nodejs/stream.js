var fs = require("fs");
var zlib = require('zlib');
var data = '';

// 读
var readerStream = fs.createReadStream('input.txt');

readerStream.setEncoding('UTF-8');

readerStream.on('data',function(chunk){
		data += chunk;
});

readerStream.on('end',function(){
	console.log(data);
});


readerStream.on('error',function(err){
	console.log(err.stack);
});


// 写
var writerStream =  fs.createWriteStream('output.txt');
data = 'fuck you!';
writerStream.write(data,'UTF8');
writerStream.end();

writerStream.on('finish',function(){
	console.log('写入完毕');
});

writerStream.on('error',function(err){
	console.log('err.stack');
});

// 读 & 写
readerStream = fs.createReadStream('input.txt');
writerStream =  fs.createWriteStream('output.txt');
readerStream.pipe(writerStream);

// pipe
fs.createReadStream('input.txt').pipe(zlib.createGzip()).pipe(fs.createWriteStream('input.txt.gz'));
console.log('done');
