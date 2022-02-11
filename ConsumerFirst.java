package nsqbroadcasttotwoconsumer;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.exceptions.NSQException;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

import java.util.concurrent.TimeoutException;

/**
 * Created by smit on 11/2/22.
 */
public class ConsumerFirst {

    public static void main(String[] args) throws NSQException, TimeoutException {

        Producer obj = new Producer();
        obj.method();
        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress("localhost", 4161);
        NSQConsumer nsqConsumer = new NSQConsumer(lookup, "TestTopic", "dustin", (message)->{

            System.out.println("received: "+new String(message.getMessage()));
            message.finished();
        });

        nsqConsumer.start();
    }
}
