package fixplayground;

import fixplayground.acceptor.FixAcceptor;
import org.springframework.beans.factory.annotation.Value;
import quickfix.*;

public abstract class AbstractFixRunner implements FixRunner {

    protected Application application;
    protected MessageStoreFactory messageStoreFactory;
    protected SessionSettings sessionSettings;
    protected LogFactory logFactory;
    protected MessageFactory messageFactory;

    @Value("${settings.filename}")
    public String settingsFilename;

    protected void initDefaults() throws Exception {
        this.application = new FixAcceptor();
        this.sessionSettings = new SessionSettings(getClass().getResourceAsStream(settingsFilename));
        this.messageStoreFactory = new FileStoreFactory(this.sessionSettings);
        this.logFactory = new FileLogFactory(this.sessionSettings);
        this.messageFactory = new DefaultMessageFactory();
    }

    @Override
    public Application getApplication() {
        return application;
    }

    @Override
    public MessageStoreFactory getMessageStoreFactory() {
        return messageStoreFactory;
    }

    @Override
    public SessionSettings getSessionSettings() {
        return sessionSettings;
    }

    @Override
    public LogFactory getLogFactory() {
        return logFactory;
    }

    @Override
    public MessageFactory getMessageFactory() {
        return messageFactory;
    }
}
