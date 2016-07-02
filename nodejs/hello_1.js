// hello_1.js 通过exports对象把world作为模块的访问接口，
// 在module_1.js中通过require('./hello_1')加载这个模块
// 然后就可以直接访问hello_1.js中exports对象的成员函数了
exports.world = function(){
	console.log('hello world');
}
