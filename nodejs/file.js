var fs = require("fs");

var data = fs.readFileSync('input.txt');

console.log(data.toString());
console.log("阻塞方式：执行结束!");


fs.readFile('input.txt',function(err,data){
	if(err) 
		   return console.error(err);
	console.log(data.toString());
});

console.log("非阻塞方式：执行结束！");

//打开文件
fs.open('input.txt','r+',function(err,fd){
	if(err){
		return console.error(err);
	}
	console.log('open file success');
});

// 获取文件统计信息
fs.stat('/Users/fool/work/learn/nodejs/readme.md',function(err,stats){
	console.log(stats.isFile());
})

// 写入文件
fs.writeFile('input.txt','我是你爸爸',function(err){
	if(err){
		return console.error(err);
	}
	console.log("数据写入成功");
	console.log("--------------");
	console.log("读取写入的数据");
	fs.readFile('input.txt',function(err,data){
		if(err){
			return console.error(err)
		}
		console.log("异步读取文件数据:" + data.toString());
	});
});
