import React from 'react';
class Terminal extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            ws: new WebSocket('ws://localhost:12345/'),
            text: ""
        };
        this.state.ws.onopen = () => {
            this.setState((prevState, props) => {
                return {text: 'WEBSOCKET CONNECT\n'};
            })
        };
        this.state.ws.onclose = () => {
            this.setState((prevState, props) => {
                return {text: 'WEBSOCKET DISCONNECT\n'};
            })
        };
        this.state.ws.onmessage = (event) => {
            this.setState((prevState, props) => {
                return {text: this.state.text + event.data + '\n'};
            })
        };
    }

    render() {
        return (<pre>
            {this.state.text}
        </pre>);
    }
}

export default Terminal;
