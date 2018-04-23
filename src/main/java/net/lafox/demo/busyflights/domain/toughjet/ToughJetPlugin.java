package net.lafox.demo.busyflights.domain.toughjet;

import java.util.List;
import java.util.stream.Collectors;

import net.lafox.demo.busyflights.Plugin;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToughJetPlugin implements Plugin {
    public static final String SUPPLIER_NAME = "ToughJet";

    @Autowired
    private ToughJetNetwork network;

    @Override
    public List<BusyFlightsResponse> request(BusyFlightsRequest request) {
        return network.get(convertRequest(request))
                .stream()
                .map(this::convertResponse)
                .collect(Collectors.toList());
    }

    private BusyFlightsResponse convertResponse(ToughJetResponse toughJetResponse) {
        BusyFlightsResponse response = new BusyFlightsResponse();
        response.setFare(calcPrice(toughJetResponse));
        response.setSupplier(SUPPLIER_NAME);
        response.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
        //todo: convert others
        return response;
    }

    public double calcPrice(ToughJetResponse toughJetResponse) {
        double discount = toughJetResponse.getBasePrice() * toughJetResponse.getDiscount() / 100;
        return toughJetResponse.getBasePrice() - discount + toughJetResponse.getTax();
    }

    private ToughJetRequest convertRequest(BusyFlightsRequest request) {
        //todo: impl
        return null;
    }
}
