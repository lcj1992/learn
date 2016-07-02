console.log('filename: ' + __filename);
console.log('dirname: ' + __dirname);

function printHello(){
	console.log('hello world');
}

var t  = setTimeout(printHello ,2000);
clearTimeout(t);

//setInterval(printHello,1000);

console.log('hello world');
console.log('aa%d');
console.log('aa%d',1992);
console.trace()

process.on('exit',function(code){
	setTimeout(function(){
		console.log('该代码不会执行');
	},0);

	console.log('退出码为：',code);
});

// 输出到终端
process.stdout.write('hello word!\n');

// 通过参数读取
process.argv.forEach(function(val,index,array){
	console.log(index + ': ' + val);
});

// 获取执行路径
console.log(process.execPath);
// 平台信息
console.log(process.platform);

console.log("程序执行结束");

console.log("当前目录:" + process.cwd());

console.log("当前版本：" + process.version);

console.log(process.memoryUsage());
