package fixplayground.initiator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("initiator")
public class FixInitiatorController {

    @Autowired
    private MessageSender messageSender;


    @RequestMapping("/{instanceid}")
    public String command(@RequestParam(name="command") String command,
                          @PathVariable("instanceid") long instanceid) throws Exception {
        switch (command) {
            case "test": return this.messageSender.sendTest() ? "success" : "fail";
        }
        return "Unknown command";
    }
}
