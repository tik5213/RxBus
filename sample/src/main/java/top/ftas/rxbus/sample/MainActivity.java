package top.ftas.rxbus.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.ftas.rxbus.RxBus;
import top.ftas.rxbus.Subscribe;
import top.ftas.rxbus.TestUtil;
import top.ftas.rxbus.ThreadMode;
import top.ftas.rxbus.sample.event.SimpleMessageEvent;
import top.ftas.rxbus.sample.fragment.TestFragment;
import top.ftas.rxbus.sample.util.PrintUtil;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RxBus.getDefault().register(this);
		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
		if (fragment == null){
			fragmentManager
					.beginTransaction()
					.add(R.id.fragmentContainer,new TestFragment())
					.commit();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		RxBus.getDefault().unRegister(this);
	}

	@Subscribe(threadMode = ThreadMode.IO)
	public void onSimpleMessage(SimpleMessageEvent event){
		PrintUtil.print(event.getMessage());
	}


}
