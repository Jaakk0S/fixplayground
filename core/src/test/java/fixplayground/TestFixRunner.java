package fixplayground;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestFixRunner extends AbstractFixRunner {

    @Override
    public void run(ApplicationContext ctx) throws Exception {
        super.initDefaults();
    }

}
