package fixplayground.initiator;

import fixplayground.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("initiator")
public class FixInitiatorController {

    @Autowired
    private MessageSender messageSender;


    @RequestMapping("/")
    public String command(@RequestParam(name="command") String command) throws Exception {
        switch (command) {
            case "test": this.messageSender.sendTest();
        }
        return "Unknown command";
    }
}
