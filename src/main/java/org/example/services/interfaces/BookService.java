package org.example.services.interfaces;

import org.example.dto.request.CheckAvailabilityRequest;
import org.example.dto.request.ReturnBookRequest;
import org.example.dto.request.UpdateAvailabilityRequest;
import org.example.dto.response.CheckAVailabilityResponse;
import org.example.dto.response.ReturnBookResponse;
import org.example.dto.response.UpdateAvailabilityResponse;

public interface BookService {
    public CheckAVailabilityResponse checkAVailability(CheckAvailabilityRequest checkAvailabilityRequest);

    public UpdateAvailabilityResponse updateAvailability(UpdateAvailabilityRequest updateAvailabilityRequest);

}
