package fixplayground;

import fixplayground.acceptor.FixAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import quickfix.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFixRunner implements FixRunner {

    protected static final Logger LOGGER = LoggerFactory.getLogger(FixRunner.class);

    private static final String SESSION_VAR_PREFIX = "FIXSESSION";
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

    /**
     * Session settings override with environment variables:
     * All env vars with name <SESSION_VAR_PREFIX>.X will override session settings with name X
     * XXX: This is stupid to implement with string-replace but couldn't find another way to get it work
     */
    private void createSessionSettings() throws Exception {
        InputStream in = getClass().getResourceAsStream(settingsFilename);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        String settings = new String(bytes, "UTF-8");
        Map<String, String> env = System.getenv();
        Map<String, String> overriddenSettings = new HashMap<>();
        for (String key : env.keySet()) {
            if (key.startsWith(SESSION_VAR_PREFIX)) {
                String[] settingStr = key.split("\\.");
                String setting = settingStr[settingStr.length-1];
                String value = env.get(key);
                LOGGER.info("Setting "+setting+" from environment: " + value);
                settings = settings.replaceFirst(setting + ".*=.*",
                        setting + "=" + value);
                overriddenSettings.put(setting, value);
            }
        }
        LOGGER.info("Session settings after environment overrides:\n");
        LOGGER.info(settings);
        this.sessionSettings = new SessionSettings(new ByteArrayInputStream(settings.getBytes()));
        // we also need to manually insert these settings because they are not stored otherwise
        for (String key: overriddenSettings.keySet()) {
            this.sessionSettings.setString(key, overriddenSettings.get(key));
        }
    }

    protected void initDefaults() throws Exception {
        this.application = new FixAcceptor();
        this.createSessionSettings();
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
    public DataDictionary getDataDictionary() {
        return dataDictionary;
    }
}
