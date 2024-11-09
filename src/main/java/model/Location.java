package model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Automatically generate UUID
    @Column(name = "locationId", columnDefinition = "CHAR(36)", nullable = false)
    private UUID locationId;

    @Column(name = "LocationCode", nullable = false)
    private String locationCode;

    @Column(name = "LocationName", nullable = false)
    private String locationName;

    @Enumerated(EnumType.STRING)
    @Column(name = "locationType", nullable = false)
    private LocationType locationType;

    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "locationId")  // Make sure this column references locationId
    private Location parentLocation;

    // Default constructor
    public Location() {}

    // Convenience constructor
    public Location(String locationCode, String locationName, LocationType locationType, Location parentLocation) {
        this.locationId = UUID.randomUUID();  // Set UUID if not using database generation
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.locationType = locationType;
        this.parentLocation = parentLocation;
    }

    // Getters and Setters
    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Location getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }
}
