package demo.versionupdate.com.versionupdatedemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import java.io.File;

import androidkun.com.versionupdatelibrary.entity.VersionUpdateConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
//     File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/app-release.apk");
File fileUri = new File(Environment.getExternalStorageDirectory().getPath());
  String savePath= String.valueOf(fileUri);
    private void initView() {
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VersionUpdateConfig.getInstance()
                //获取配置实例
                 .setContext(MainActivity.this)
                //设置上下文
                 .setDownLoadURL("http://kgj.ockeji.com/Appapk/app-release.apk")
//                设置文件下载链接
                 .setNewVersion("6.0.1")
                //设置即将下载的APK的版本号,避免重复下载
                 .setFileSavePath(savePath)
                //设置文件保存路径（可不设置）
                 .setNotificationIconRes(R.mipmap.ic_launcher)
                //设置通知图标
                 .setNotificationSmallIconRes(R.mipmap.ic_launcher)
                //设置通知小图标
                 .setNotificationTitle("版本升级Demo")
                //设置通知标题
                 .startDownLoad();//开始下载
            }
        });
    }
}
