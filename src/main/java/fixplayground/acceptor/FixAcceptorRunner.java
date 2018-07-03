package fixplayground.acceptor;

import fixplayground.AbstractFixRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.*;

@Component("fixRunner")
@Profile("acceptor")
public class FixAcceptorRunner extends AbstractFixRunner {

    @Override
    public void run(ApplicationContext ctx) throws Exception {
        super.initDefaults();
        Acceptor acceptor = new SocketAcceptor(
                application, messageStoreFactory, sessionSettings, logFactory, messageFactory
        );
        acceptor.start();
    }


}
