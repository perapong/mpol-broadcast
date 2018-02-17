package th.co.mpol.broadcast.mpolbroadcast.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import th.co.mpol.broadcast.mpolbroadcast.R;
import th.co.mpol.broadcast.mpolbroadcast.activity.MainActivity;

/**
 * Created by perapong_s on 1/27/2018.
 */

public class NingNongFragment extends Fragment {
    private MainActivity mainActivity;
    private View view;
    EditText etReceivedBroadcast, etReferer;
    Button btnSendBroadcast;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mainActivity = (MainActivity) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement MainActivity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mainActivity = MainActivity.getInstance();
        try {
            if (view == null) {
                view = inflater.inflate(R.layout.fragment_ningnong, container, false);

                etReferer = (EditText) view.findViewById(R.id.etReferer);
                btnSendBroadcast = (Button) view.findViewById(R.id.btnSendBroadcast);
                btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String broadcastPackage = "th.co.mistine.ningnong.INSTALL_REFERRER";
                        String broadcastIndex = "referrer";
                        String broadcastData = "" + etReferer.getText();
                        mainActivity.onSendBroadcast(broadcastPackage, broadcastIndex, broadcastData);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return view;
        }
    }
//
//    @Override
//    public void onClick(View view) {
//
////        Intent intnet = new Intent("th.co.mistine.mistinecatalog.INSTALL_REFERRER");
////        Intent intnet = new Intent("th.co.mistine.ningnong.INSTALL_REFERRER");
//        Intent intnet = new Intent("com.android.vending.INSTALL_REFERRER");
//        String mslInfo = "msl>" + etMslCode.getText();
//        String userInfo = ">" + etStudentId.getText() + ">" + etStudentName.getText() + ">" + etStudentMobile.getText();
//        String referrer = mslInfo + userInfo;
////        String referrer = "param=" + etMslCode.getText();
//        intnet.putExtra("referrer", referrer);
//        mainActivity.onSendBroadcast("","",referrer);
//    }
}
