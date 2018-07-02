package fixplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import quickfix.*;

public abstract class AbstractFixRunner implements FixRunner {

    @Autowired
    protected FixApplication fixApplication;

    protected SessionSettings sessionSettings;

    protected MessageStoreFactory storeFactory;

    protected LogFactory logFactory;

    protected MessageFactory messageFactory;

    @Override
    public void run(ApplicationContext ctx) throws Exception {
        this.sessionSettings = new SessionSettings(getClass().
                getResourceAsStream(fixApplication.propertyFileName()));
        this.storeFactory = new FileStoreFactory(sessionSettings);
        this.logFactory = new FileLogFactory(sessionSettings);
        this.messageFactory = new DefaultMessageFactory();
    }


    public SessionSettings getSessionSettings() {
        return sessionSettings;
    }

    public MessageStoreFactory getStoreFactory() {
        return storeFactory;
    }

    public LogFactory getLogFactory() {
        return logFactory;
    }

    public MessageFactory getMessageFactory() {
        return messageFactory;
    }
}
