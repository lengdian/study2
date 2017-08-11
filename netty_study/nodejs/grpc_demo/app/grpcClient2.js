//静态代码生成方式
/*
--使用下面的命令执行生成代码（失败）
grpc_tools_node_protoc --js_out=import_style=commonjs,binary:static_codegen/ --grpc_out=static_codegen --plugin=protoc-gen-grpc=C:/Users/hxy.GZGY/AppData/Roaming/npm/grpc_tools_node_protoc_plugin proto/Student.proto
--使用下面的命令执行生成代码（成功）
grpc_tools_node_protoc --js_out=import_style=commonjs,binary:static_codegen/ --grpc_out=static_codegen proto/Student.proto
 */
var service = require('../static_codegen/proto/Student_grpc_pb');
var message = require('../static_codegen/proto/Student_pb');

var grpc = require('grpc');

var client = new service.StudentServiceClient('localhost:8899', grpc.credentials.createInsecure());

var request = new message.MyRequest();
request.setUsername('hyy');

client.getRealnameByUsername(request, function (error, respData) {
    console.log(respData.getRealname());
});