package fixplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quickfix.SessionNotFound;

@RestController
public class FixController {

    @Autowired
    private FixRunner runner;

    @RequestMapping("/ping")
    public String command() throws Exception {
        return "ping";
    }

    @RequestMapping("/fieldname")
    public String fieldName(@RequestParam(name="code") int code) {
        return this.runner.getDataDictionary().getFieldName(code);
    }

    @ExceptionHandler(SessionNotFound.class)
    public String sessionNotFound() {
        return "Session not found!";
    }

    @ExceptionHandler(Exception.class)
    public String help() {
        return "Supported commands:\n"+
                "- test: forces a heartbeat";
    }
}
