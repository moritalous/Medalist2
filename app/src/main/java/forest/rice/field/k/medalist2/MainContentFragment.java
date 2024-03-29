package forest.rice.field.k.medalist2;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import forest.rice.field.k.medalist2.entity.MedalEntity;
import forest.rice.field.k.medalist2.recycler.MainContentAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainContentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;


    public MainContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainContentFragment newInstance(String param1, String param2) {
        MainContentFragment fragment = new MainContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_content, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        AsyncTask<String, String, String> task = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... params) {

                String result = null;

                Request request = new Request.Builder()
                        .url("http://yw.b-boys.jp/member/maruwakalist_file/medallist.txt")
                        .get()
                        .build();

                Request request1 = new Request.Builder()
                        .url("http://yw.b-boys.jp/member/maruwakalist_file/medallist2.txt")
                        .get()
                        .build();

                OkHttpClient client = new OkHttpClient();

                try {
                    Response response = client.newCall(request).execute();
                    result = response.body().string();

                    response = client.newCall(request1).execute();
                    result = result + "\r\n" + response.body().string();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return result;
            }

            @Override
            protected void onPostExecute(String s) {

                SortedList<MedalEntity> list = MedalEntity.createMedalEntityList(s);

                recyclerView.setAdapter(new MainContentAdapter(getActivity(), list));
            }
        }.execute("");

        return view;
    }

}
