package net.lafox.demo.busyflights.presenter;

import static java.util.stream.Collectors.toList;

import java.util.List;

import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponsePresenter;
import net.lafox.demo.busyflights.service.BusyFlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusyFlightsPresenterImpl implements BusyFlightsPresenter {
    @Autowired
    private BusyFlightsService busyFlightsService;
    @Override
    public List<BusyFlightsResponsePresenter> present(BusyFlightsRequest busyFlightsRequest) {
        return busyFlightsService.aggregateFlights(busyFlightsRequest)
                .stream()
                .map(r -> BusyFlightsResponsePresenter.newBuilder(r).build())
                .collect(toList());
    }
}
