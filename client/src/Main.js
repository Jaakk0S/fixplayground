import React from 'react';
import InitiatorPanel from './InitiatorPanel';
import Terminal from './Terminal';
import Dictionary from './Dictionary';
import PageHeader from 'react-bootstrap/lib/PageHeader';
class Main extends React.Component {

    render() {
        return (
            <div>
                <PageHeader style={{'textAlign': 'center'}}>
                    FIX demo
                </PageHeader>
                <div>
                    <div style={{'display': 'inline-block'}}>
                        <InitiatorPanel instanceId='0'/>
                    </div>
                    <div style={{'display': 'inline-block'}}>
                        <InitiatorPanel instanceId='1'/>
                    </div>
                </div>
                <div>
                    <div style={{'float': 'left', 'width': '70%'}}><Terminal/></div>
                    <div style={{'float': 'right', 'width': '30%'}}><Dictionary/></div>
                </div>
            </div>
        );
    }
}

export default Main;
