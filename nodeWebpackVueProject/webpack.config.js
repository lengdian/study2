const path = require('path');

module.exports = {
    entry: {
        login: './src/login.js',
        main: './src/main.js'
    },
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, './dist')
    }
};