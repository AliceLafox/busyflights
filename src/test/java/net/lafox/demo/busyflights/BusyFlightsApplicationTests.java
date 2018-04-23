package net.lafox.demo.busyflights;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsRequest;
import net.lafox.demo.busyflights.domain.busyflights.BusyFlightsResponse;
import net.lafox.demo.busyflights.domain.crazyair.CrazyAirNetwork;
import net.lafox.demo.busyflights.domain.crazyair.CrazyAirPlugin;
import net.lafox.demo.busyflights.domain.crazyair.CrazyAirResponse;
import net.lafox.demo.busyflights.domain.toughjet.ToughJetNetwork;
import net.lafox.demo.busyflights.domain.toughjet.ToughJetPlugin;
import net.lafox.demo.busyflights.domain.toughjet.ToughJetResponse;
import net.lafox.demo.busyflights.service.BusyFlightsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightsApplicationTests {
    private static final String DEPARTURE_DATE = DateTimeFormatter.ISO_DATE.format(LocalDate.now());
    private static final String ARRIVAL_DATE = DateTimeFormatter.ISO_DATE.format(LocalDate.now().plusDays(3));
    private static final String DEPARTURE_AIRPORT = "AMS";
    private static final String DESTINATION_AIRPORT = "LHS";

    @MockBean
    private CrazyAirNetwork crazyAirNetwork;
    @MockBean
    private ToughJetNetwork toughJetNetwork;
    @MockBean
    private PluginManager pluginManager;

    @Autowired
    private CrazyAirPlugin crazyAirPlugin;
    @Autowired
    private ToughJetPlugin toughJetPlugin;
    @Autowired
    private BusyFlightsServiceImpl busyFlightsService;

    private final BusyFlightsRequest busyFlightsRequest = createBusyFlightsRequest();
    private final CrazyAirResponse crazyAirResponse = createCrazyAirResponse();
    private final ToughJetResponse toughJetResponse = createToughJetResponse();

    @Before
    public void setUp() {
        when(crazyAirNetwork.get(Mockito.any())).thenReturn(asList(crazyAirResponse));
        when(toughJetNetwork.get(Mockito.any())).thenReturn(asList(toughJetResponse));

        when(pluginManager.getPlugins()).thenReturn(asList(crazyAirPlugin, toughJetPlugin));
    }

    @Test
    public void testAggregateFlights() {
        List<BusyFlightsResponse> actual = busyFlightsService.aggregateFlights(busyFlightsRequest);

        assertNotNull(actual);
        assertEquals(2, actual.size());

        assertEquals(crazyAirResponse.getPrice(), actual.get(0).getFare(), 0.01);
        assertEquals(toughJetPlugin.calcPrice(toughJetResponse), actual.get(1).getFare(), 0.01);

        assertEquals(CrazyAirPlugin.SUPPLIER_NAME, actual.get(0).getSupplier());
        assertEquals(ToughJetPlugin.SUPPLIER_NAME, actual.get(1).getSupplier());

        assertEquals(toughJetResponse.getDepartureAirportName(), actual.get(1).getDepartureAirportCode());
    }

    private BusyFlightsRequest createBusyFlightsRequest() {
        BusyFlightsRequest request = new BusyFlightsRequest();
        request.setDepartureDate(DEPARTURE_DATE);
        request.setReturnDate(ARRIVAL_DATE);
        request.setDestination(DEPARTURE_AIRPORT);
        request.setOrigin(DESTINATION_AIRPORT);
        request.setNumberOfPassengers(2);
        return request;
    }

    private CrazyAirResponse createCrazyAirResponse() {
        CrazyAirResponse response = new CrazyAirResponse();
        response.setArrivalDate(ARRIVAL_DATE);
        response.setDepartureDate(DEPARTURE_DATE);
        response.setDepartureAirportCode(DEPARTURE_AIRPORT);
        response.setDestinationAirportCode(DESTINATION_AIRPORT);
        response.setPrice(91.569);
        return response;
    }

    private ToughJetResponse createToughJetResponse() {
        ToughJetResponse response = new ToughJetResponse();
        response.setDepartureAirportName(DEPARTURE_AIRPORT);
        response.setBasePrice(95.00);
        response.setTax(10.00);
        response.setDiscount(10);
        return response;
    }
}
