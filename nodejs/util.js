var util = require('util')
function Base(){
	this.name = 'base';
	this.base = 1991;
	this.sayHello = function(){
		console.log('hello ' + this.name);
	};
}

Base.prototype.showName = function(){
	console.log(this.name);
};

function Sub(){
	this.name = 'sub';
}

// 我们定义了一个基础对象和一个继承自Base的Sub，Base有三个在构造函数内定义的属性和一个原型中定义的函数，通过util.inherits实现继承
util.inherits(Sub,Base);

var objBase = new Base();
objBase.showName();
objBase.sayHello();
console.log(objBase);

var objSub = new Sub();
objSub.showName();
// Sub仅仅继承了Base在原型中定义的函数，而构造函数内部穿凿的base属性和sayHello函数没有被Sub继承
// 同时，在原型中定义的属性不会被console.log作为对象的属性输出
console.log(objSub);

function Person(){
	this.name  = 'foolchild';
	this.toString = function(){
		return this.name;
	};
}
var obj = new Person();
console.log(util.inspect(obj));
console.log(util.inspect(obj,true));

util.isArray([]);

util.isArray(new Array);

util.isArray({});


