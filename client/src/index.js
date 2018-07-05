import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Terminal from './Terminal';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<Terminal />, document.getElementById('root'));
registerServiceWorker();
