package fixplayground.initiator;

import fixplayground.FixApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.*;

@Component
@Profile("initiator")
public class FixInitiator implements FixApplication {

    @Override
    public String propertyFileName() {
        return "/settings-initiator.properties";
    }

    @Override
    public void onCreate(SessionID sessionID) {

    }

    @Override
    public void onLogon(SessionID sessionID) {

    }

    @Override
    public void onLogout(SessionID sessionID) {

    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {

    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {

    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

    }
}
