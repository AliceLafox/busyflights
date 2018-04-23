package net.lafox.demo.busyflights.domain.crazyair;

import java.util.List;

import net.lafox.demo.busyflights.Network;
import org.springframework.stereotype.Component;

@Component
public class CrazyAirNetwork implements Network<CrazyAirRequest, CrazyAirResponse> {

    @Override
    public List<CrazyAirResponse> get(CrazyAirRequest request) {
//        todo http|https|corba|rmi|soap query to external URL (for retrieve JSON|XML string)
//        https://hc.apache.org/httpcomponents-client-ga/httpclient/examples/org/apache/http/examples/client/ClientWithResponseHandler.java
//        todo parse JSON|XML String to Java Object
//        http://www.baeldung.com/jackson-object-mapper-tutorial
        return null;
    }


}
