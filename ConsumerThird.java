package nsqbroadcasttotwoconsumer;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.exceptions.NSQException;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.util.concurrent.TimeoutException;

/**
 * Created by smit on 11/2/22.
 */
public class ConsumerThird {
    public static void main(String[] args) throws NSQException, TimeoutException {

        Producer producer = new Producer();
        producer.method();
        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress("localhost", 4161);
        NSQConsumer nsqConsumer = new NSQConsumer(lookup, "TestTopic", "nsq", (message)->{

            System.out.println("received :  "+new String(message.getMessage()));
            message.finished();
        });

        nsqConsumer.start();
    }
}
