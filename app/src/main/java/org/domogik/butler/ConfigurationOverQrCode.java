package org.domogik.butler;

/**
 * Created by fritz on 02/01/17.
 */


import android.app.Activity;
        import android.content.ActivityNotFoundException;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.net.Uri;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;

        import org.json.JSONException;
        import org.json.JSONObject;

/*
public class ConfigurationOverQrCode extends AppCompatActivity {
    private static String contents;
    private final String mytag = this.getClass().getName();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");//for Qr code, its "QR_CODE_MODE" instead of "PRODUCT_MODE"
            intent.putExtra("SAVE_HISTORY", false);//this stops saving ur barcode in barcode scanner app's history
            startActivityForResult(intent, 0);

        } catch (ActivityNotFoundException anfe) {
            //on catch, show the download dialog
            showDialog(config_with_qrcode.this, getString(R.string.no_qrcode_scanner), getString(R.string.no_qrcode_question), getString(R.string.reloadOK), getString(R.string.reloadNO)).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                contents = data.getStringExtra("SCAN_RESULT"); //this is the result
                showDialog(config_with_qrcode.this, getString(R.string.qr_code_is_valid), contents, getString(R.string.reloadOK), getString(R.string.reloadNO)).show();
            } else if (resultCode == RESULT_CANCELED) {
                //showDialog(config_with_qrcode.this, "Qrcode results", "No results from qrcode scanner", "Yes", "No").show();
            }
        }
    }

    private AlertDialog showDialog(final Activity act, final CharSequence title, CharSequence message, CharSequence buttonYes, final CharSequence buttonNo) {
        final AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (title.equals(getString(R.string.no_qrcode_scanner))) {
                    Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        act.startActivity(intent);
                    } catch (ActivityNotFoundException anfe) {
                        Log.e(mytag, "No market apps installed on this device: " + anfe.toString());
                        showDialog(config_with_qrcode.this, getString(R.string.no_market_apps), contents, getString(R.string.reloadOK), getString(R.string.reloadNO)).show();
                    }
                } else if (title.equals(getString(R.string.qr_code_is_valid))) {
                    Log.d("preference", "We got a result from qrcode scanner:" + contents);
                    try {
                        JSONObject jsonresult = null;
                        jsonresult = new JSONObject(contents);
                        SharedPreferences params = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor prefEditor;
                        String mq_port_sub = "40412";
                        try {
                            mq_port_sub = jsonresult.getString("mq_port_pub");
                        } catch (JSONException exec) {
                            try {
                                Log.e(mytag, "mq_port_pub not present in this qrcode");
                                mq_port_sub = jsonresult.getString("mq_port_pubsub");
                            } catch (JSONException exec2) {
                                Log.e(mytag, "mq_port_pubsub not present in this qrcode");
                            }
                        }String mq_port_pub = "40411";
                        try {
                            mq_port_pub = jsonresult.getString("mq_port_pub");
                        } catch (ArrayIndexOutOfBoundsException exec) {
                            Log.e(mytag, "mq_port_pub not present in this qrcode");
                        }
                        String mq_ip = jsonresult.getString("mq_ip");
                        String butler_name = jsonresult.getString("butler_name");

                        prefEditor = params.edit();
                        prefEditor.putString("dmg_ip", mq_ip);
                        prefEditor.putString("dmg_sub_port", mq_port_sub);
                        prefEditor.putString("dmg_pub_port", mq_port_pub);

                        prefEditor.commit();

                        config_with_qrcode.this.finish();

                    } catch (JSONException e) {
                        Log.e(mytag, "Error parsing answer of qrcode to json: " + e.toString());
                    }
                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }


}
*/