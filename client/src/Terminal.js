import React from 'react';
import Panel from 'react-bootstrap/lib/Panel';
import Button from 'react-bootstrap/lib/Button';
class Terminal extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            ws: new WebSocket('ws://' + window.location.hostname + '/ws'),
            text: "",
            frozen: false
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
            });
            this.props.addToDictionary(event.data);
            if (!this.state.frozen) {
                this.textLog.scrollTop = this.textLog.scrollHeight;
            }
        };
    }

    freezeConsole() {
        this.setState({frozen: !this.state.frozen});
    }

    render() {
        let buttonStyle = this.state.frozen ? "primary" : "default";
        return (
            <div style={{'height': '100%', 'width': '100%'}}>
            <Panel>
                <Panel.Heading>ECN-Server-Company raw FIX traffic
                    <Button style={{float: 'right'}} bsSize="small" bsStyle={buttonStyle}
                            onClick={this.freezeConsole.bind(this)}
                            ref={switchButton => this.switchButton = switchButton}>Freeze console</Button>
                </Panel.Heading>
                <textarea value={this.state.text} ref={textLog => this.textLog = textLog}
                    style={{'height': '50vh', 'width': '100%', resize: 'none'}}/>

            </Panel>

        </div>);
    }
}

export default Terminal;
