// 有时候我们只是想把一个对象封装到模块中
function Hello(){
	var name;
	this.setName = function(thyName){
		name = thyName;
	};
	this.sayHello = function(){
		console.log('hello ' + name);
	};
};
// 可以通过module.exports
// 与hello_1.js不同的是
// 模块接口的唯一变化是使用
// module.exports = Hello代替了exports.world = function(){}
module.exports = Hello;
