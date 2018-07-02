package fixtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import quickfix.Message;
import quickfix.Session;
import quickfix.fix42.TestRequest;

@Component
public class MessageSender {

    @Autowired
    private FixRunner fixRunner;

    @Value("@{sender.comp.id}")
    private String senderCompID;

    @Value("@{target.comp.id}")
    private String targetCompID;

    private void sendWithSenderAndTarget(Message msg) throws Exception {
        Session.sendToTarget(msg, senderCompID, targetCompID);
    }

    public void sendTest() throws Exception {
        Message msg = new TestRequest();
        sendWithSenderAndTarget(msg);
    }

}
