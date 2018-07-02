package fixplayground.acceptor;

import fixplayground.AbstractFixRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import quickfix.*;

@Component
@Profile("acceptor")
public class FixAcceptorRunner extends AbstractFixRunner {

    @Override
    public void run(ApplicationContext ctx) throws Exception {
        super.run(ctx);
        Acceptor acceptor = new SocketAcceptor(
                fixApplication, storeFactory, sessionSettings, logFactory, messageFactory
        );
        acceptor.start();
    }
}
