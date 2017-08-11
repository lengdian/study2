//动态代码生成方式
var PROTO_FILE_PATH = '../proto/Student.proto';
var grpc = require('grpc');
var grpcService = grpc.load(PROTO_FILE_PATH).com.hxy.proto;

var client = new grpcService.StudentService('localhost:8899', grpc.credentials.createInsecure());

client.getRealnameByUsername({username: 'hxy'}, function (error, respData) {
    console.log(respData);
});