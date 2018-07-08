package fixplayground.initiator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.Message;
import quickfix.Session;
import quickfix.field.TestReqID;
import quickfix.fix42.TestRequest;

import java.util.UUID;

@Component
@Profile("initiator")
public class MessageSender {

    @Autowired
    private FixInitiatorRunner runner;
    
    public boolean sendTest() throws Exception {
        Message msg = new TestRequest(new TestReqID(UUID.randomUUID().toString()));
        return Session.sendToTarget(msg, this.runner.initiator.getSessions().get(0));
    }

}
