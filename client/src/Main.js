import React from 'react';
import InitiatorPanel from './InitiatorPanel';
import Terminal from './Terminal';
import Dictionary from './Dictionary';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Button from 'react-bootstrap/lib/Button';
import Modal from 'react-bootstrap/lib/Modal';

class Main extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            showExplain: false
        }
    }

    showExplain() {
      this.setState({ showExplain: true });
    }

    hideExplain() {
      this.setState({ showExplain: false });
    }


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
                    <div style={{'display': 'inline-block'}}>
                        <i>Sry, only TestReq so far...</i>
                    </div>
                    <div style={{textAlign: 'right', float: 'right'}}>
                        <Button bsSize="large" bsStyle="info" onClick={this.showExplain.bind(this)}>
                            Explain dis</Button><br/>
                        <a target="_blank" href="https://github.com/Jaakk0S/fixplayground">Github</a>
                    </div>
                    <Modal show={this.state.showExplain} onHide={this.hideExplain.bind(this)}
                        dialogClassName="explanation">
                        <Modal.Header closeButton>
                            <Modal.Title>This is what you are looking at</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <img class="expl-image" src='./explanation.jpg'/>
                        </Modal.Body>
                    </Modal>
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
