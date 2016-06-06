const webpack = require('webpack');
const sharedConfig = require('./webpack.shared.config');

const prodConfig = {
  entry: [
    './src/main'
  ],
  output: {
    publicPath: '/',
    path: 'dist',
    filename: 'main.js'
  },
  plugins: [
    new webpack.DefinePlugin({
      'process.env':{
        'NODE_ENV': "'production'"
      }
    })
  ]
};

module.exports = Object.assign({},
  sharedConfig,
  prodConfig
);
