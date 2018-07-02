package fixplayground;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickfix.SessionNotFound;

@RestController
public class FixController {


    @RequestMapping("/ping")
    public String command() throws Exception {
        return "ping";
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
