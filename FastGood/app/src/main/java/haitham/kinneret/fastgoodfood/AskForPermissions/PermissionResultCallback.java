package haitham.kinneret.fastgoodfood.AskForPermissions;

import java.util.ArrayList;

/**
 * Created by Haitham + Fares on 2/6/2018.
 */

public interface PermissionResultCallback {

    void PermissionGranted(int request_code);
    void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions);
    void PermissionDenied(int request_code);
    void NeverAskAgain(int request_code);
}
