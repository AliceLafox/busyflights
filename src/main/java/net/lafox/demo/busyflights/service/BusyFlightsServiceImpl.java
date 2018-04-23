package net.lafox.demo.busyflights.service;

import static java.util.Comparator.comparingDouble;

import java.util.ArrayList;
import java.util.List;

import net.lafox.demo.busyflights.Plugin;
import net.lafox.demo.busyflights.PluginManager;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

    @Autowired
    private PluginManager pluginManager;

    @Override
    public List<BusyFlightsResponse> aggregateFlights(BusyFlightsRequest request) {
        List<BusyFlightsResponse> result = new ArrayList<>();

        for (Plugin plugin : pluginManager.getPlugins()) {
            result.addAll(plugin.request(request));
        }

        result.sort(comparingDouble(BusyFlightsResponse::getFare));

        return result;
    }
}
