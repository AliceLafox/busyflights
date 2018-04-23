package net.lafox.demo.busyflights;

import java.util.List;

public interface Network<REQUEST, RESPONSE> {
    List<RESPONSE> get(REQUEST request);
}
