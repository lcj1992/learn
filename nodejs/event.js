// 引入 events 模块
var events = require('events');
// 创建 eventEmitter 对象
var eventEmitter = new events.EventEmitter();

// 创建事件处理程序
var connectHandler = function connected() {
   console.log('连接成功。');
  
   // 触发 data_received 事件 
   eventEmitter.emit('data_received');
}
eventEmitter.on('connection', connectHandler);
 
// 使用匿名函数绑定 data_received 事件
eventEmitter.on('data_received', function(){
   console.log('数据接收成功。');
});

// 触发 connection 事件 
//eventEmitter.emit('connection');

// 1s后触发connection事件
setTimeout(function(){
    eventEmitter.emit('connection');
},1000);

// eventEmitter为someEvent 注册了两个事件监听器
eventEmitter.on('someEvent',function(arg1,arg2){
	console.log('listener1,',arg1,arg2 );
});

eventEmitter.on('someEvent',function(arg1,arg2){
	console.log('listener2,',arg1,arg2 );
});

eventEmitter.emit('someEvent','hello', 'event');
console.log("程序执行完毕。");
