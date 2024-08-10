package org.example.dto.request;

import lombok.Data;
import org.example.data.model.Category;

@Data
public class UpdateAvailabilityRequest {
    private String id;
    private String title;
}
