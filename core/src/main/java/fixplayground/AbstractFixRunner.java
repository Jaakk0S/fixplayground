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
    protected DataDictionary dataDictionary;

    @Value("${settings.filename}")
    public String settingsFilename;

    @Value("${data.dictionary.filename}")
    public String dataDictionaryFilename;

    protected void initDefaults() throws Exception {
        this.application = new FixAcceptor();
        this.sessionSettings = new SessionSettings(getClass().getResourceAsStream(settingsFilename));
        this.messageStoreFactory = new FileStoreFactory(this.sessionSettings);
        this.logFactory = new FileLogFactory(this.sessionSettings);
        this.messageFactory = new DefaultMessageFactory();
        this.dataDictionary = new DataDictionary(getClass().getResourceAsStream(dataDictionaryFilename));
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

    @Override
    public DataDictionary getDataDictionary() { return dataDictionary; }
}
