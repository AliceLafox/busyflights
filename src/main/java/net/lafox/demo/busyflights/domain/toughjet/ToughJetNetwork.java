package net.lafox.demo.busyflights.domain.toughjet;

import java.util.List;

import net.lafox.demo.busyflights.Network;
import org.springframework.stereotype.Component;

@Component
public class ToughJetNetwork implements Network<ToughJetRequest, ToughJetResponse> {
    @Override
    public List<ToughJetResponse> get(ToughJetRequest toughJetRequest) {
        //todo: impl
        return null;
    }
}
