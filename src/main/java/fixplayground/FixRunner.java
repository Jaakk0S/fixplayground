package fixplayground;

import org.springframework.context.ApplicationContext;
import quickfix.*;

/**
 * Autowire an instance of this class to reach the services
 */
public interface FixRunner {
    public Application getApplication();
    public MessageStoreFactory getMessageStoreFactory();
    public SessionSettings getSessionSettings();
    public LogFactory getLogFactory();
    public MessageFactory getMessageFactory();
    public DataDictionary getDataDictionary();
    public void run(ApplicationContext ctx) throws Exception;
}
