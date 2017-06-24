package top.ftas.rxbus.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.ftas.rxbus.RxBus;
import top.ftas.rxbus.sample.R;
import top.ftas.rxbus.sample.event.SimpleMessageEvent;

/**
 * Created by ybf326 on 17/6/24.
 */

public class TestFragment extends Fragment implements View.OnClickListener {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_test,container,false);
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initView(view,savedInstanceState);
	}

	private void initView(View view, Bundle savedInstanceState) {
		view.findViewById(R.id.send_simple_message_btn).setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.send_simple_message_btn:
				sendSimpleMessage();
				break;
		}
	}

	/**
	 * 发送简单信息到MainActivity
	 */
	private void sendSimpleMessage() {
		SimpleMessageEvent event = new SimpleMessageEvent();
		event.setMessage("郭靖爱上了黄蓉");
		RxBus.getDefault().post(event);
	}
}
