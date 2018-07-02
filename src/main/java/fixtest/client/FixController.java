package fixtest.client;

import fixtest.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quickfix.SessionNotFound;

@RestController
public class FixController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping("/ping")
    public String command() throws Exception {
        return "ping";
    }

    @RequestMapping("/")
    public String command(@RequestParam(name="command") String command) throws Exception {
        switch (command) {
            case "test": this.messageSender.sendTest();
        }
        return this.help();
    }

    @ExceptionHandler({SessionNotFound.class})
    public String sessionNotFound() {
        return "Session not found!";
    }

    @ExceptionHandler
    public String help() {
        return "Supported commands:\n"+
                "- test: forces a heartbeat";
    }
}
