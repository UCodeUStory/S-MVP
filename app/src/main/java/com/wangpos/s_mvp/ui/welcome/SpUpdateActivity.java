package com.mediatek.factorymode.sp;

import android.os.Bundle;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import com.weipass.server.Iscservice;
import com.mediatek.factorymode.R;
import android.os.ServiceManager;
import android.widget.ProgressBar;
import android.widget.Toast;


public class SpUpdateActivity extends Activity {

    TextView tvVersionCode;
    Iscservice om;
    byte[] data=new byte[1024];
    int []datalen= new int [1];

    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_update);
        om = Iscservice.Stub.asInterface(ServiceManager.getService("scservice"));
        findViewById(R.id.btnGetSPVersion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 获取版本号
                try{
                    int ret = om.SDK_Get_DeviceVersion(data,datalen);
                    if(ret==0)
                    {
                        byte []temp = new byte [datalen[0]];
                        System.arraycopy(data,0,temp,0,datalen[0]);
                        String readtime =new String(temp);
                        tvVersionCode.setText("版本号："+ readtime);
                    }else{
                        tvVersionCode.setText("读取版本号失败");
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        });

        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 更新SP
                if (!isUpdating){
                    isUpdating = true;
                    progressBar.setVisibility(View.VISIBLE);
                    new Thread(myable).start();

                }
            }
        });
        tvVersionCode = (TextView)findViewById(R.id.tvVersionCode);
        progressBar = (ProgressBar)findViewById(R.id.progressBarLarge);

    }

    private boolean isUpdating = false;


    Runnable myable = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            byte[] data2 = new byte[1];
            int datalen2 = 1;
            try{
                int ret = om.SDK_SendData(data2,datalen2);
                if (ret == 0){
                    isUpdating = false;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"升级完成",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.INVISIBLE);
                            Intent intent2 = new Intent(Intent.ACTION_REBOOT);
                            intent2.putExtra("nowait", 1);
                            intent2.putExtra("interval", 1);
                            intent2.putExtra("window", 0);
                            sendBroadcast(intent2);
                        }
                    });
                }
            }catch(Exception e){
                isUpdating = false;
                Toast.makeText(getApplicationContext(),"升级失败",Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
                e.printStackTrace();
            }
        }
    };
    // Thread updateSpThread = new Thread(){
    //     @Override
    //     public void run() {
    //         super.run();
    //         byte[] data2 = new byte[1];
    //         int datalen2 = 1;
    //         try{
    //             int ret = om.SDK_SendData(data2,datalen2);
    //             if (ret == 0){
    //                 isUpdating = false;
    //                 runOnUiThread(new Runnable() {
    //                     @Override
    //                     public void run() {
    //                         Toast.makeText(getApplicationContext(),"升级完成",Toast.LENGTH_LONG).show();
    //                         progressBar.setVisibility(View.INVISIBLE);
    //                     }
    //                 });
    //             }
    //         }catch(Exception e){
    //             isUpdating = false;
    //             Toast.makeText(getApplicationContext(),"升级失败",Toast.LENGTH_LONG).show();
    //             progressBar.setVisibility(View.INVISIBLE);
    //             e.printStackTrace();
    //         }

    //     }
    // };

    public String InttoHexString(byte data[]) {
        String result = "";
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0x00) {
                result += "00";
            } else {
                result += Integer.toHexString(data[i] & 0xff);
            }
        }
        return result;
    }
}
