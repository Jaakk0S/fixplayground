package fixplayground.initiator;

import fixplayground.AbstractFixRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.Initiator;
import quickfix.SocketInitiator;

@Component
@Profile("initiator")
public class FixInitiatorRunner extends AbstractFixRunner {

    @Override
    public void run(ApplicationContext ctx) throws Exception {
        super.initDefaults();
        Initiator initiator = new SocketInitiator(
                application, messageStoreFactory, sessionSettings, logFactory, messageFactory
        );
        initiator.start();
    }
}
