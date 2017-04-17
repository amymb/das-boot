package com.amy;

import com.amy.controller.ShipwreckController;
import com.amy.model.Shipwreck;
import com.amy.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pivotal on 4/17/17.
 */
public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet(){
        Shipwreck sw = new Shipwreck();

        sw.setId(1l);
        when(shipwreckRepository.findOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);
        verify(shipwreckRepository).findOne(1l);
//        assertEquals(1l, wreck.getId().longValue());
        assertThat(wreck.getId(), is (1l));
    }

    @Test
    public void testShipwreckGetAll(){
        List<Shipwreck> shipwrecks = new ArrayList<Shipwreck>();
        Shipwreck sw1 = new Shipwreck();
        Shipwreck sw2 = new Shipwreck();
        sw1.setId(1l);
        sw2.setId(2l);
        shipwrecks.add(0, sw1);
        shipwrecks.add(1, sw2);

        when(shipwreckRepository.findAll()).thenReturn(shipwrecks);

        List<Shipwreck> wrecks = sc.list();

        assertEquals(2, wrecks.size());

    }

    @Test
    public void testShipwreckCreate(){
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRepository.saveAndFlush(sw)).thenReturn(sw);
        Shipwreck wreck = sc.create(sw);

        assertEquals(1l, wreck.getId().longValue());

    }

    @Test
    public void testShipwreckUpdate(){
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);

        when(shipwreckRepository.findOne(1l)).thenReturn(sw);
        when(shipwreckRepository.saveAndFlush(sw)).thenReturn(sw);

        Shipwreck wreck = sc.update(1l, sw);

        assertEquals(1l, wreck.getId().longValue());

    }

    @Test
    public void testShipwreckDelete(){
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);

        when(shipwreckRepository.findOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.delete(1l);
        assertEquals(1l, wreck.getId().longValue());
    }
}
