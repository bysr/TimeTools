package hipad.timetools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import hipad.dateutils.DateListener;
import hipad.dateutils.TimeConfig;
import hipad.dateutils.TimeSelectorDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeSelectorDialog dialog = new TimeSelectorDialog(MainActivity.this);
                //设置标题
                dialog.setTimeTitle("选择时间:");
                //显示类型
                dialog.setIsShowtype(TimeConfig.YEAR_MONTH);
                //默认时间
                dialog.setCurrentDate("2017-01-11　14:50");
                //隐藏清除按钮
                dialog.setEmptyIsShow(false);
                //设置起始时间
                dialog.setStartYear(1888);
                dialog.setDateListener(new DateListener() {
                    @Override
                    public void onReturnDate(String time, int year, int month, int day, int hour, int minute, int isShowType) {
                        Toast.makeText(MainActivity.this, time, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onReturnDate(String empty) {
                        Toast.makeText(MainActivity.this
                                , empty, Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();


            }
        });
    }
}
