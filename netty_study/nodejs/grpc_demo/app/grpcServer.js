//动态代码生成方式
var PROTO_FILE_PATH = '../proto/Student.proto';
var grpc = require('grpc');
var grpcService = grpc.load(PROTO_FILE_PATH).com.hxy.proto;

var server = new grpc.Server();

//动态代码方式用addProtoService
server.addProtoService(grpcService.StudentService.service, {
    getRealnameByUsername: getRealnameByUsername,
    getStudentsByAge:getStudentsByAge,
    getStudentsWrapperByAge:getStudentsWrapperByAge,
    biTalk:biTalk
});

server.bind('localhost:8899', grpc.ServerCredentials.createInsecure());
server.start();

function getRealnameByUsername(call, callback) {
    console.log('call:'+ call.request.username);

    callback(null, {realname: 'hhxxyy'});
}

function getStudentsByAge(){}
function getStudentsWrapperByAge(){}
function biTalk(){}