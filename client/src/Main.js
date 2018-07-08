import React from 'react';
import InitiatorPanel from './InitiatorPanel';
import Terminal from './Terminal';
import Dictionary from './Dictionary';
import PageHeader from 'react-bootstrap/lib/PageHeader';
class Main extends React.Component {

    render() {
        return (
            <div style={{'height': '85vh', 'width': '90vw'}}>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossOrigin="anonymous"/>
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
                <div style={{'height': '70%'}}>
                    <div style={{'float': 'left', 'width': '70%'}}>
                        <Terminal addToDictionary={(entry) => this.refs.dictionary.addToDictionary(entry)}/>
                    </div>
                    <div style={{'float': 'right', 'width': '30%'}}><Dictionary ref="dictionary"/></div>
                </div>
            </div>
        );
    }
}

export default Main;
