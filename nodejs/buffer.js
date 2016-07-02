buf = new Buffer(256);

len = buf.write('www.facebook.com');
console.log('写入字节数：'+ len);

for(var i = 0; i < 26; i++){
	buf[i] = i + 97;
}

console.log(buf.toString('utf-8',0,10));
var bufx = new Buffer('www.facebook.com');
console.log(bufx.toJSON());

var buf1 = new Buffer('caicai');
var buf2 = new Buffer('caicai1');
var buf3 = Buffer.concat([buf1,buf2]);
console.log('buf3:' + buf3.toString());
