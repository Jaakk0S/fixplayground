package fixplayground.initiator;

import fixplayground.AbstractFixRunner;
import fixplayground.FixRunner;
import fixplayground.SessionLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.Dictionary;
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
        LOGGER.info("Starting initiator");
        initiator.start();
    }
}
