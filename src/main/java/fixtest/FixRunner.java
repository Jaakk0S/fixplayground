package fixtest;

import org.springframework.context.ApplicationContext;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SessionSettings;

public interface FixRunner {
    public void run(ApplicationContext ctx) throws Exception;
    public SessionSettings getSessionSettings();
    public MessageStoreFactory getStoreFactory();
    public LogFactory getLogFactory();
    public MessageFactory getMessageFactory();
}
