const path = require('path');
// const webpack = require('webpack');

module.exports = {
    entry: {bundle: './src/index.js'},
    //多entry point时为了区分输出的文件名字，使用[name]标识
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, 'dist')
        // publicPath: 'localhost:8080/'
    },
    module: {
        rules: [
            {test: /\.vue$/, use: 'vue-loader'}
        ]
    },
    // plugins: [new webpack.HotModuleReplacementPlugin()],
    resolve: {
        alias: {
            'vue': 'vue/dist/vue.js'
        }
    }
};