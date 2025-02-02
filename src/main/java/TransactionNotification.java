import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class TransactionNotification
{
    private static final Logger logger = LoggerFactory.getLogger(TransactionNotification.class);

    public static void main(String[] args)
    {
        ZContext context = new ZContext(1);

        ZMQ.Socket subscriber = context.createSocket(ZMQ.SUB);

        subscriber.connect("tcp://localhost:5556");

        subscriber.subscribe("");

        logger.info("Subscribed to messages");

        while (true)
        {
            String message = subscriber.recvStr();

            logger.info(message);
        }
    }
}
