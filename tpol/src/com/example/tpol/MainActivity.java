package com.example.tpol;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView cdmaRssi = (TextView) findViewById(R.id.textView3);
        cdmaRssi.setText("6");
        
        PhoneStateListener signalListener = new PhoneStateListener(){
        	@Override
        	public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                TextView cdmaRssi = (TextView) findViewById(R.id.textView3);
        		cdmaRssi.setText("" + signalStrength.getCdmaDbm());
                TextView cdmaEcio = (TextView) findViewById(R.id.textView6);
        		cdmaEcio.setText("" + signalStrength.getCdmaEcio());
                TextView evdoDbm = (TextView) findViewById(R.id.textView9);
        		evdoDbm.setText("" + signalStrength.getEvdoDbm());
                TextView evdoEcio = (TextView) findViewById(R.id.textView12);
        		evdoEcio.setText("" + signalStrength.getEvdoEcio());
                TextView evdoSnr = (TextView) findViewById(R.id.textView15);
        		evdoSnr.setText("" + signalStrength.getEvdoSnr());
                TextView isGsm = (TextView) findViewById(R.id.textView24);
                isGsm.setText("" + signalStrength.isGsm());
                
                TextView gsmBitErrorRate = (TextView) findViewById(R.id.textView18);
                gsmBitErrorRate.setText("" + signalStrength.getGsmBitErrorRate());
                TextView gsmSignalStrength = (TextView) findViewById(R.id.textView21);
                gsmSignalStrength.setText("" + signalStrength.getGsmSignalStrength());        		
        	}
        };
        
        TelephonyManager telMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        telMgr.listen(signalListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
