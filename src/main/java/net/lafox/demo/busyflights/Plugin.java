package net.lafox.demo.busyflights;

import java.util.List;

import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponse;

public interface Plugin {
   List<BusyFlightsResponse> request(BusyFlightsRequest request);
}
