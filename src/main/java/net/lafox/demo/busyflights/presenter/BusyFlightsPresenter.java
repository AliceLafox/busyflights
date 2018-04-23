package net.lafox.demo.busyflights.presenter;

import java.util.List;

import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponsePresenter;

public interface BusyFlightsPresenter {
    List<BusyFlightsResponsePresenter> present (BusyFlightsRequest busyFlightsRequest);
}
