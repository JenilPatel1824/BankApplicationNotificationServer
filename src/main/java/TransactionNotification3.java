import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class TransactionNotification3
{
    private static final Logger logger = LoggerFactory.getLogger(TransactionNotification3.class);

    public static void main(String[] args)
    {

        ZContext context = new ZContext();

        ZMQ.Socket pullSocket = context.createSocket(SocketType.PULL);

        pullSocket.connect("tcp://localhost:5556");

        logger.info("notification 3 ready   ");

        while (true)
        {
            String message = pullSocket.recvStr();

            logger.info(message);
        }
    }
}
