//静态代码生成方式
var service = require('../static_codegen/proto/Student_grpc_pb');
var message = require('../static_codegen/proto/Student_pb');

var grpc = require('grpc');

var server = new grpc.Server();
//静态代码方式用addService
server.addService(service.StudentServiceService, {
    getRealnameByUsername: getRealnameByUsername,
    getStudentsByAge: getStudentsByAge,
    getStudentsWrapperByAge: getStudentsWrapperByAge,
    biTalk: biTalk
});

server.bind('localhost:8899', grpc.ServerCredentials.createInsecure());
server.start();

function getRealnameByUsername(call, callback) {
    console.log('call:' + call.request.getUsername());

    var myResponse = new message.MyResponse();
    myResponse.setRealname('hhxxyy');
    callback(null, myResponse);
}

function getStudentsByAge() {
}

function getStudentsWrapperByAge() {
}

function biTalk() {
}