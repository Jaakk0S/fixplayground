package fixplayground.acceptor;

import fixplayground.AbstractFixRunner;
import fixplayground.FixRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.*;

@Component("fixRunner")
@Profile("acceptor")
public class FixAcceptorRunner extends AbstractFixRunner {

    private static final Logger logger = LoggerFactory.getLogger(FixRunner.class);

    @Override
    public void run(ApplicationContext ctx) throws Exception {
        super.initDefaults();
        Acceptor acceptor = new SocketAcceptor(
                application, messageStoreFactory, sessionSettings, logFactory, messageFactory
        );
        logger.info("Starting acceptor");
        acceptor.start();
    }

}
