package error;

import java.util.ArrayList;
import java.util.List;

public class RoomErrorManager {
    List<RoomError> errors = new ArrayList<RoomError>();

    public void addError(RoomError error) {
        errors.add(error);
    }

    public List<RoomError> getErrors() {
        return errors;
    }

    public void deleteError(String id) {
        for (int i = 0; i < errors.size(); i++) {
            if (errors.get(i).getId().equals(id)) {
                errors.remove(i);
                return;
            }
        }
    }

    public void resolveErrors(String id) {
        for (RoomError error : errors) {
            if(error.getId().equals(id)){
               error.setResolved(true);
                System.out.println("lỗi này đã được nhân viên sử lý thành công");
                return;
            }
        }
    }

    public void displayErrors() {
        for (RoomError error : errors) {
            System.out.println(error);
        }
    }

}
