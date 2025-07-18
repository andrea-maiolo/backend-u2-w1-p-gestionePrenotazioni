package andreamaiolo.GestionPrenotazioni.entities;

import andreamaiolo.GestionPrenotazioni.enums.WorkstationType;

public class WorkStation {
    private long id;
    // private UUID id;
    private String description;
    private int maxOccupancy;
    private Building building;
    private WorkstationType type;

    public WorkStation() {
    }

    public WorkStation(String description, int maxOccupancy, Building building, WorkstationType type) {
        this.description = description;
        this.maxOccupancy = maxOccupancy;
        this.building = building;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public WorkstationType getType() {
        return type;
    }

    public void setType(WorkstationType type) {
        this.type = type;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "WorkStation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", maxOccupancy=" + maxOccupancy +
                ", building=" + building.getName() +
                ", type=" + type +
                '}';
    }
}
