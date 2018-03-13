package aes.gorio.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import aes.gorio.com.myapplication.view.MyView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    boolean isChange = true;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.Button01)
    Button button01;
    @BindView(R.id.Button02)
    Button button02;
    @BindView(R.id.testWidget)
    LinearLayout testWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MyView te = new MyView(this, "自定义组件", R.drawable.ic_launcher_background);
        te.setOnExtClickListener(text -> Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show());

        LinearLayout ly = findViewById(R.id.testWidget);
        ly.addView(te);
        Button btn = (Button) findViewById(R.id.Button01);
        Button btn2 = (Button) findViewById(R.id.Button02);
        btn.setOnClickListener(v -> {
            if (isChange) {
                te.setImage(android.R.drawable.btn_dialog);
            } else {
                te.setDrawable(getResources().getDrawable(R.drawable.icon));
            }
            isChange = !isChange;
        });
        btn2.setOnClickListener(v -> te.setText("只可以改变一次喔"));
    }

//        // Example of a call to a native method
//        TextView tv =  findViewById(R.id.textView);
//        TextView tv1 = findViewById(R.id.textView1);
//        TextView tv2 = findViewById(R.id.textView2);
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(o->{
//            tv.setText(stringFromJNI());
////            tv1.setText(JniTest.helloworld());
//            tv2.setText(new StringBuilder().append(addTwoNum(1,1)));
//        });
//    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    public native int addTwoNum(int a, int b);

    @OnClick({R.id.Button01, R.id.Button02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Button01:
                break;
            case R.id.Button02:

                break;
        }
    }
}
