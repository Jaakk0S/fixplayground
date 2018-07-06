package fixplayground;

import fixplayground.acceptor.FixAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import quickfix.*;

import java.io.*;

public abstract class AbstractFixRunner implements FixRunner {

    private static final Logger logger = LoggerFactory.getLogger(FixRunner.class);

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

    @Value("#{environment.ACCEPTOR_IP}")
    private String acceptorIp;

    protected void initDefaults() throws Exception {
        this.application = new FixAcceptor();
        InputStream in = getClass().getResourceAsStream(settingsFilename);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        String settings = new String(bytes, "UTF-8");
        if (this.acceptorIp != null) {
            logger.info("Setting SocketConnectHost from environment: " + this.acceptorIp);
            settings = settings.replaceFirst("SocketConnectHost.*=.*",
                    "SocketConnectHost="+this.acceptorIp);
        }
        this.sessionSettings = new SessionSettings(new ByteArrayInputStream(settings.getBytes()));
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
