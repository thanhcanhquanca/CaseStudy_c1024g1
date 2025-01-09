package error;

import java.time.LocalDate;

public class RoomError {
    private String id;
    private String idCustomer;
    private String idRoom;
    private String nameCustomer;
    private String reportedBy;
    private LocalDate timestamp;
    private boolean resolved;

    public RoomError(String id, String idCustomer, String idRoom, String nameCustomer, String reportedBy, LocalDate timestamp, boolean resolved) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idRoom = idRoom;
        this.nameCustomer = nameCustomer;
        this.reportedBy = reportedBy;
        this.timestamp = timestamp;
        this.resolved = resolved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    @Override
    public String toString() {
        return "RoomError{" +
                "id='" + id + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idRoom='" + idRoom + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", reportedBy='" + reportedBy + '\'' +
                ", timestamp=" + timestamp +
                ", resolved=" + resolved +
                '}';
    }
}
