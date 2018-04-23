package net.lafox.demo.busyflights;

import static java.util.Arrays.asList;

import java.util.List;

import net.lafox.demo.busyflights.domain.crazyair.CrazyAirPlugin;
import net.lafox.demo.busyflights.domain.toughjet.ToughJetPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PluginManager {


    @Autowired
    private CrazyAirPlugin crazyAirPlugin;

    @Autowired
    private ToughJetPlugin toughJetPlugin;

    public List<Plugin> getPlugins() {
        return asList(crazyAirPlugin, toughJetPlugin);
    }
}
