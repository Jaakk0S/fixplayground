package fixtest.client;

import fixtest.AbstractFixRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.Initiator;
import quickfix.SocketInitiator;

@Component
@Profile("client")
public class FixClientRunner extends AbstractFixRunner {

    @Override
    public void run(ApplicationContext ctx) throws Exception {
        super.run(ctx);
        Initiator initiator = new SocketInitiator(
                fixApplication, storeFactory, sessionSettings, logFactory, messageFactory
        );
        initiator.start();
    }
}
