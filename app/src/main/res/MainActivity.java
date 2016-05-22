package com.example.teamona.helloworld;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }
    private void initialize() {

        setContentView(R.layout.activity_main);
        // 言語の切替え
        Button langage = (Button) findViewById(R.id.language);
        langage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Locale locale = Locale.getDefault();      // アプリで使用されているロケール情報を取得
                if (locale.equals(Locale.JAPAN)) {
                    locale = Locale.US;
                }
                else {
                    locale = Locale.JAPAN;
                }
                Locale.setDefault(locale);            // 新しいロケールを設定
                Configuration config = new Configuration();
                config.locale = locale;             // Resourcesに対するロケールを設定
                Resources resources = getBaseContext().getResources();
                resources.updateConfiguration(config, null);  // Resourcesに対する新しいロケールを反映
                initialize();                   // ※ ポイント 初期化し直し再描画させます。
                }
            });
    }
}
