package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RentalCartTest {

    @Test
    void getTotalPrice() {
        RentalCart cart = new RentalCart();
        RentalService service = mock(RentalService.class);
        cart.setRentalService(service);

        Movie movie1 = new Movie("MOV1","Title1","1993", 5);
        Movie movie2 = new Movie("MOV1","Title1","2001", 5);
        Movie movie3 = new Movie("MOV1","Title1","2023", 5);

        cart.setMovies(Arrays.asList(
            movie1,
            movie2,
            movie3
        ));

        //Mocking getRentalPrice
        when(service.getRentalPrice(movie1)).thenReturn(2.0);
        when(service.getRentalPrice(movie2)).thenReturn(5.0);
        when(service.getRentalPrice(movie3)).thenReturn(10.0);

        when(service.calculateLateFee(2.0, 5)).thenReturn(2.5);
        when(service.calculateLateFee(5.0, 5)).thenReturn(7.5);
        when(service.calculateLateFee(10.0, 5)).thenReturn(20.0);

        double expectedOutput = 30;
        assertEquals(expectedOutput, cart.getTotalPrice());
    }

    public static double getLateFeesAmount(double amount, int days) {
        double lateFeesAmount = amount;
        double amountPerDay = (amount * days)/100;
        for (int i = 0; i < days; i++) {
            lateFeesAmount += (amount * days)/100;
        }
        return lateFeesAmount;
    }
}