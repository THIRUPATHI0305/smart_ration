package com.example.smart_ration_shop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        Object[] smsOBj = (Object[]) bundle.get("pdus");
        for(Object obj : smsOBj){
            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);

            String mobNo = message.getDisplayOriginatingAddress();
            String msg = message.getDisplayMessageBody();

            Log.d("MsgDetails","MobNo : " + mobNo+",Msg: "+msg);

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+917904033763",null,"hello",null,null);
        }

    }
}
