import React from 'react';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import * as NETWORK from './networkconfig';
class InitiatorPanel extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            initiatorId: props.instanceId
        };
    }

    testRequest() {
        fetch("http://" + NETWORK.INITIATORS[this.state.initiatorId] + "/?command=test");
    }

    dictionaryQuery(msg) {
        fetch("http://" + NETWORK.INITIATORS[this.state.initiatorId] + "/?command=test");
    }


    render() {
        return (
            <div>
                <Panel>
                    <Panel.Heading>Initiator {Number(this.state.initiatorId) + 1}</Panel.Heading>
                </Panel>
                <Button onClick={this.testRequest()}>
                    Send TestReq</Button>
            </div>
        );
    }
}

export default InitiatorPanel;
