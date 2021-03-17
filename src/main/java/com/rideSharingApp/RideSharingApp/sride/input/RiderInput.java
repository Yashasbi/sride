package com.rideSharingApp.RideSharingApp.sride.input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class RiderInput {
    UUID riderId;
    String name;

    @Override
    public String toString() {
        return "RiderInput{" +
                "riderId=" + riderId +
                ", name='" + name + '\'' +
                '}';
    }
}
