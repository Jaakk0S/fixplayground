import React from 'react';
import Panel from 'react-bootstrap/lib/Panel';
class Dictionary extends React.Component {
    constructor(props) {
        super(props);
    }

    addToDictionary(key, value) {
        if (this.state.key == null) {
            this.state.key = value;
        }
    }

    render() {
        return (<div>
            <Panel>
                <Panel.Heading>FIX Dictionary</Panel.Heading>
            </Panel>
        </div>);
    }
}

export default Dictionary;
