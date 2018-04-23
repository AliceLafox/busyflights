package net.lafox.demo.busyflights.service;

import java.util.List;

import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponse;

public interface BusyFlightsService {

    List<BusyFlightsResponse> aggregateFlights(BusyFlightsRequest request);

}
