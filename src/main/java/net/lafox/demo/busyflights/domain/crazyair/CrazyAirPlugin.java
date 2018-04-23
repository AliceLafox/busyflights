package net.lafox.demo.busyflights.domain.crazyair;

import java.util.List;
import java.util.stream.Collectors;

import net.lafox.demo.busyflights.Plugin;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrazyAirPlugin implements Plugin {
    public static final String SUPPLIER_NAME = "CrazyAir";

    @Autowired
    private CrazyAirNetwork network;

    @Override
    public List<BusyFlightsResponse> request(BusyFlightsRequest request) {
        return network.get(convertRequest(request))
                .stream()
                .map(this::convertResponse)
                .collect(Collectors.toList());
    }

    private CrazyAirRequest convertRequest(BusyFlightsRequest busyFlightsRequest) {
        CrazyAirRequest request = new CrazyAirRequest();
        request.setOrigin(busyFlightsRequest.getOrigin());
        //todo: convert others
        return request;
    }


    private BusyFlightsResponse convertResponse(CrazyAirResponse crazyAirResponse) {
        BusyFlightsResponse response = new BusyFlightsResponse();
        response.setFare(crazyAirResponse.getPrice());
        response.setSupplier(SUPPLIER_NAME);
        //todo: convert others
        return response;
    }

}
