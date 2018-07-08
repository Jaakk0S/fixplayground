package fixplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quickfix.SessionNotFound;

@RestController
public class FixController {

    @Autowired
    private FixRunner runner;

    @RequestMapping("/{instanceid}/ping")
    public String command(@PathVariable("instanceid") long instanceid) throws Exception {
        return "ping";
    }

    @RequestMapping("/{instanceid}/fieldname")
    public String fieldName(@RequestParam(name="code") int code,
                            @PathVariable("instanceid") long instanceid) {
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
