const sharedConfig = require('./webpack.shared.config');

const prodConfig = {
  entry: [
    './src/main'
  ],
  output: {
    publicPath: '/',
    path: 'dist',
    filename: 'main.js'
  }
};

module.exports = Object.assign({},
  sharedConfig,
  prodConfig
);
