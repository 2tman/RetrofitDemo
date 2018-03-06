package iandroid.club.rxjava10module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RxUtilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_util);

        findViewById(R.id.btn_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RxUtil().test1();
            }
        });
    }
}
