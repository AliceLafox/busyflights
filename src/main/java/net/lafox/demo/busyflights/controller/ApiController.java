package net.lafox.demo.busyflights.controller;

import java.util.List;

import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponsePresenter;
import net.lafox.demo.busyflights.presenter.BusyFlightsPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
public class ApiController {

    @Autowired
    private BusyFlightsPresenter flightsPresenter;

    @PostMapping(value = "/aggregateFlights",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusyFlightsResponsePresenter> aggregateFlights(@RequestBody BusyFlightsRequest busyFlightsRequest) {
        return flightsPresenter.present(busyFlightsRequest);
    }
}
