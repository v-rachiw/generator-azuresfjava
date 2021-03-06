<% if (packageName) { %>package <%= packageName %>;<% } %>

import java.time.Duration;
import java.util.logging.Logger;
import java.util.logging.Level;

import microsoft.servicefabric.services.runtime.ServiceRuntime;

public class <%= serviceRunnerName %> {

    private static final Logger logger = Logger.getLogger(<%= serviceRunnerName %>.class.getName());

    public static void main(String[] args) throws Exception {
        try {
            ServiceRuntime.registerStatefulServiceAsync("<%= serviceTypeName %>", (context) -> new <%= serviceClassName %>(context), Duration.ofSeconds(10));
            logger.log(Level.INFO, "Registered stateful service of type <%= serviceTypeName %>. ");
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception occured", ex);
            throw ex;
        }
    }
}
