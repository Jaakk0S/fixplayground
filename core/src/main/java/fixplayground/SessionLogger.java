package fixplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quickfix.Log;
import quickfix.SessionID;

import java.util.HashMap;

@Component
public class SessionLogger {

    @Autowired
    private FixRunner runner;

    private HashMap<SessionID, Log> logs = new HashMap<>();

    public Log getLog(SessionID id) {
        return logs.get(id);
    }

    public void createLog(SessionID id) {
        Log log = this.runner.getLogFactory().create(id);
        this.logs.put(id, log);
    }

}
