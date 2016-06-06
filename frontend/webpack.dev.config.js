const webpack = require('webpack');
const path = require('path');
const sharedConfig = require('./webpack.shared.config');

const devConfig = {
  entry: [
    './src/main',
    'webpack-dev-server/client?http://localhost:3000',
    'webpack/hot/only-dev-server'
  ],
  output: {
    publicPath: '/',
    path: '../backend/src/main/resources/assets',
    filename: 'main.js'
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin()
  ],
  devtool: 'source-map',
  debug: true,
  devServer: {
    contentBase: './',
    port: 3000
  }
};

module.exports = Object.assign({},
  sharedConfig,
  devConfig
);
