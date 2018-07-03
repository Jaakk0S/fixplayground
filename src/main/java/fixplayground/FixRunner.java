package fixplayground;

import org.springframework.context.ApplicationContext;
import quickfix.*;

public interface FixRunner {
    public Application getApplication();
    public MessageStoreFactory getMessageStoreFactory();
    public SessionSettings getSessionSettings();
    public LogFactory getLogFactory();
    public MessageFactory getMessageFactory();
    public void run(ApplicationContext ctx) throws Exception;
}
