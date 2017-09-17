package app.security.egat.easyform.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import app.security.egat.easyform.R;

/**
 * Created by Phakpoom.I on 17/9/2560.
 */

public class MyAlertDialog {
    private Context context;

    public MyAlertDialog(Context context) {
        this.context = context;
    }
    public void myDialog(String strTitle, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);  //ไม่ให้กด Undo
        builder.setIcon(R.mipmap.ic_face);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}//Main Class
