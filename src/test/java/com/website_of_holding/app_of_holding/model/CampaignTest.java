package com.website_of_holding.app_of_holding.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CampaignTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Campaign#Campaign(String, LocalDate, boolean)}
     *   <li>{@link Campaign#toString()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("Campaign{id=null, title='Dr', startDate=1970-01-02, completed=true}",
                (new Campaign("Dr", LocalDate.ofEpochDay(1L), true)).toString());
    }
}

