package th.co.mpol.broadcast.mpolbroadcast.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.co.mpol.broadcast.mpolbroadcast.R;
/**
 * Created by perapong_s on 1/27/2018.
 */

public class HomeFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            if (view == null) {
                view = inflater.inflate(R.layout.fragment_home, container, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return view;
        }
    }
}
