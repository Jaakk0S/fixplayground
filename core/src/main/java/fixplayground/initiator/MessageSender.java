package fixplayground.initiator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.Message;
import quickfix.Session;
import quickfix.field.TestReqID;
import quickfix.fix42.TestRequest;

@Component
@Profile("initiator")
public class MessageSender {

    @Autowired
    private FixInitiatorRunner runner;

    private boolean sendWithSenderAndTarget(Message msg) throws Exception {
        String senderCompID = this.runner.getSessionSettings().getString("SenderCompID");
        String targetCompID = this.runner.getSessionSettings().getString("TargetCompID");
        return Session.sendToTarget(msg, senderCompID, targetCompID);
    }

    public boolean sendTest() throws Exception {
        Message msg = new TestRequest(new TestReqID("12345"));
        return sendWithSenderAndTarget(msg);
    }

}
