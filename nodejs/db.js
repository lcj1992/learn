var mysql = require('mysql');

var connection = mysql.createConnection({
		host : '127.0.0.1',
		user: 'root',
		password: 'root',
		port: '3306',
});

connection.connect(function(err){
	if(err){
		console.log('[query] -: ' + err);
		return;
	}
	console.log('[connection connect] success');
});

connection.query('select * from test.class',function(err,rows,fields){
	if(err){
		console.log('[query]- ' + err);
		return;
	}
	console.log('the cls_name is:',rows[0].cls_name);
});

connection.end(function(err){
	if(err){
		return;
	}
	console.log('[conncetcion end] success!');
});
