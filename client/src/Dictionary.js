import React from 'react';
import Panel from 'react-bootstrap/lib/Panel';
class Dictionary extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dict: {}
        }
    }

    fieldQuery(code) {
        fetch("/0/fieldname?code=" + code)
            .then(response => {
                return response.text();
            }).then((text) => {
                const newState = this.state.dict;
                newState[code] = text;
                this.setState({dict: newState});
            });
    }

    addToDictionary(entrystring) {
        entrystring.split("|").forEach((element) => {
            var val = element.trim().split("=")[0];
            if (val && !isNaN(val)) {
                this.fieldQuery(val);
            }
        });
    }

    renderDict() {
        var resp = "";
        for (var key in this.state.dict) {
            resp += (key + " = " + this.state.dict[key] + "\n");
        }
        return resp;
    }

    render() {
        return (<div>
            <Panel>
                <Panel.Heading>FIX Dictionary</Panel.Heading>
                <textarea value={this.renderDict()}
                    style={{'height': '50vh', 'width': '100%', resize: 'none'}}/>
            </Panel>
        </div>);
    }
}

export default Dictionary;
