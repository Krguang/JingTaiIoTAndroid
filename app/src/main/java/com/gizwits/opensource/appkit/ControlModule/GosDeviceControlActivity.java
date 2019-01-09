package com.gizwits.opensource.appkit.ControlModule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import java.util.concurrent.ConcurrentHashMap;

import com.gizwits.gizwifisdk.api.GizWifiDevice;
import com.gizwits.gizwifisdk.enumration.GizWifiDeviceNetStatus;
import com.gizwits.gizwifisdk.enumration.GizWifiErrorCode;
import com.gizwits.opensource.appkit.CommonModule.GosDeploy;
import com.gizwits.opensource.appkit.R;
import com.gizwits.opensource.appkit.utils.HexStrUtils;
import com.gizwits.opensource.appkit.view.HexWatcher;

public class GosDeviceControlActivity extends GosControlModuleBaseActivity
		implements OnClickListener, OnEditorActionListener, OnSeekBarChangeListener {

	/** 设备列表传入的设备变量 */
	private GizWifiDevice mDevice;

	private Switch sw_bool_JK_1_fengJiYiQiDong;
	private Switch sw_bool_JK_1_zhiBanStatus;
	private Switch sw_bool_JK_1_dianJiaRe1;
	private Switch sw_bool_JK_1_dianJiaRe2;
	private Switch sw_bool_JK_1_dianJiaRe3;
	private Switch sw_bool_JK_1_fengJiStatus;
	private Switch sw_bool_JK_1_shouZiDong;
	private Switch sw_bool_JK_1_dongXiaJi;
	private Switch sw_bool_JK_1_zhongXiaoBaoJing;
	private Switch sw_bool_JK_1_dianJiaReGaoWen;
	private Switch sw_bool_JK_1_fengJiQueFeng;
	private Switch sw_bool_JK_1_paiFengJiYiQiDong;
	private Switch sw_bool_JK_1_diWenPanGuan;
	private Switch sw_bool_JK_1_mieJunYunXing;
	private Switch sw_bool_JK_2_fengJiYiQiDong;
	private Switch sw_bool_JK_2_zhiBanStatus;
	private Switch sw_bool_JK_2_dianJiaRe1;
	private Switch sw_bool_JK_2_dianJiaRe2;
	private Switch sw_bool_JK_2_dianJiaRe3;
	private Switch sw_bool_JK_2_fengJiStatus;
	private Switch sw_bool_JK_2_shouZiDong;
	private Switch sw_bool_JK_2_dongXiaJi;
	private Switch sw_bool_JK_2_zhongXiaoBaoJing;
	private Switch sw_bool_JK_2_dianJiaReGaoWen;
	private Switch sw_bool_JK_2_fengJiQueFeng;
	private Switch sw_bool_JK_2_paiFengJiYiQiDong;
	private Switch sw_bool_JK_2_diWenPanGuan;
	private Switch sw_bool_JK_2_mieJunYunXing;
	private Switch sw_bool_JK_3_fengJiYiQiDong;
	private Switch sw_bool_JK_3_zhiBanStatus;
	private Switch sw_bool_JK_3_dianJiaRe1;
	private Switch sw_bool_JK_3_dianJiaRe2;
	private Switch sw_bool_JK_3_dianJiaRe3;
	private Switch sw_bool_JK_3_fengJiStatus;
	private Switch sw_bool_JK_3_shouZiDong;
	private Switch sw_bool_JK_3_dongXiaJi;
	private Switch sw_bool_JK_3_zhongXiaoBaoJing;
	private Switch sw_bool_JK_3_dianJiaReGaoWen;
	private Switch sw_bool_JK_3_fengJiQueFeng;
	private Switch sw_bool_JK_3_paiFengJiYiQiDong;
	private Switch sw_bool_JK_3_diWenPanGuan;
	private Switch sw_bool_JK_3_mieJunYunXing;
	private Switch sw_bool_JK_XF_fengJiYiQiDong;
	private Switch sw_bool_JK_XF_zhiBanStatus;
	private Switch sw_bool_JK_XF_dianJiaRe1;
	private Switch sw_bool_JK_XF_dianJiaRe2;
	private Switch sw_bool_JK_XF_dianJiaRe3;
	private Switch sw_bool_JK_XF_fengJiStatus;
	private Switch sw_bool_JK_XF_shouZiDong;
	private Switch sw_bool_JK_XF_dongXiaJi;
	private Switch sw_bool_JK_XF_zhongXiaoBaoJing;
	private Switch sw_bool_JK_XF_dianJiaReGaoWen;
	private Switch sw_bool_JK_XF_fengJiQueFeng;
	private Switch sw_bool_JK_XF_paiFengJiYiQiDong;
	private Switch sw_bool_JK_XF_diWenPanGuan;
	private Switch sw_bool_JK_XF_mieJunYunXing;
	private TextView tv_data_JK_1_mianBanTongXunZhuangTai1;
	private TextView tv_data_JK_1_mianBanTongXunZhuangTai2;
	private TextView tv_data_JK_1_mianBanTongXunZhuangTai3;
	private TextView tv_data_JK_2_mianBanTongXunZhuangTai1;
	private TextView tv_data_JK_2_mianBanTongXunZhuangTai2;
	private TextView tv_data_JK_2_mianBanTongXunZhuangTai3;
	private TextView tv_data_JK_3_mianBanTongXunZhuangTai1;
	private TextView tv_data_JK_3_mianBanTongXunZhuangTai2;
	private TextView tv_data_JK_3_mianBanTongXunZhuangTai3;
	private TextView tv_data_JK_XF_mianBanTongXunZhuangTai1;
	private TextView tv_data_JK_XF_mianBanTongXunZhuangTai2;
	private TextView tv_data_JK_XF_mianBanTongXunZhuangTai3;
	private TextView tv_data_JK_1_tempReal;
	private TextView tv_data_JK_1_humiReal;
	private TextView tv_data_JK_1_tempSet;
	private TextView tv_data_JK_1_humiSet;
	private TextView tv_data_JK_1_lengShuiFaKaiDu;
	private TextView tv_data_JK_1_reShuiFaKaiDu;
	private TextView tv_data_JK_1_xinFengWenDU;
	private TextView tv_data_JK_1_jiaShiQIKaiDu;
	private TextView tv_data_JK_1_beiYong;
	private TextView tv_data_JK_2_tempReal;
	private TextView tv_data_JK_2_humiReal;
	private TextView tv_data_JK_2_tempSet;
	private TextView tv_data_JK_2_humiSet;
	private TextView tv_data_JK_2_lengShuiFaKaiDu;
	private TextView tv_data_JK_2_reShuiFaKaiDu;
	private TextView tv_data_JK_2_xinFengWenDU;
	private TextView tv_data_JK_2_jiaShiQIKaiDu;
	private TextView tv_data_JK_2_beiYong;
	private TextView tv_data_JK_3_tempReal;
	private TextView tv_data_JK_3_humiReal;
	private TextView tv_data_JK_3_tempSet;
	private TextView tv_data_JK_3_humiSet;
	private TextView tv_data_JK_3_lengShuiFaKaiDu;
	private TextView tv_data_JK_3_reShuiFaKaiDu;
	private TextView tv_data_JK_3_xinFengWenDU;
	private TextView tv_data_JK_3_jiaShiQIKaiDu;
	private TextView tv_data_JK_3_beiYong;
	private TextView tv_data_JK_XF_tempReal;
	private TextView tv_data_JK_XF_humiReal;
	private TextView tv_data_JK_XF_tempSet;
	private TextView tv_data_JK_XF_humiSet;
	private TextView tv_data_JK_XF_lengShuiFaKaiDu;
	private TextView tv_data_JK_XF_reShuiFaKaiDu;
	private TextView tv_data_JK_XF_xinFengWenDU;
	private TextView tv_data_JK_XF_jiaShiQIKaiDu;
	private TextView tv_data_JK_XF_beiYong;

	private enum handler_key {

		/** 更新界面 */
		UPDATE_UI,

		DISCONNECT,
	}

	private Runnable mRunnable = new Runnable() {
		public void run() {
			if (isDeviceCanBeControlled()) {
				progressDialog.cancel();
			} else {
				toastDeviceNoReadyAndExit();
			}
		}

	};

	/** The handler. */
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			handler_key key = handler_key.values()[msg.what];
			switch (key) {
			case UPDATE_UI:
				updateUI();
				break;
			case DISCONNECT:
				toastDeviceDisconnectAndExit();
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gos_device_control);
		initDevice();
		setToolBar(true, getDeviceName());
		final Drawable add = getResources().getDrawable(R.drawable.common_setting_more);
		int color = GosDeploy.appConfig_Contrast();
		add.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
		mToolbar.setOverflowIcon(add);
		initView();
		initEvent();
	}

	private void initView() {
		
		sw_bool_JK_1_fengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_1_fengJiYiQiDong);
		sw_bool_JK_1_zhiBanStatus = (Switch) findViewById(R.id.sw_bool_JK_1_zhiBanStatus);
		sw_bool_JK_1_dianJiaRe1 = (Switch) findViewById(R.id.sw_bool_JK_1_dianJiaRe1);
		sw_bool_JK_1_dianJiaRe2 = (Switch) findViewById(R.id.sw_bool_JK_1_dianJiaRe2);
		sw_bool_JK_1_dianJiaRe3 = (Switch) findViewById(R.id.sw_bool_JK_1_dianJiaRe3);
		sw_bool_JK_1_fengJiStatus = (Switch) findViewById(R.id.sw_bool_JK_1_fengJiStatus);
		sw_bool_JK_1_shouZiDong = (Switch) findViewById(R.id.sw_bool_JK_1_shouZiDong);
		sw_bool_JK_1_dongXiaJi = (Switch) findViewById(R.id.sw_bool_JK_1_dongXiaJi);
		sw_bool_JK_1_zhongXiaoBaoJing = (Switch) findViewById(R.id.sw_bool_JK_1_zhongXiaoBaoJing);
		sw_bool_JK_1_dianJiaReGaoWen = (Switch) findViewById(R.id.sw_bool_JK_1_dianJiaReGaoWen);
		sw_bool_JK_1_fengJiQueFeng = (Switch) findViewById(R.id.sw_bool_JK_1_fengJiQueFeng);
		sw_bool_JK_1_paiFengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_1_paiFengJiYiQiDong);
		sw_bool_JK_1_diWenPanGuan = (Switch) findViewById(R.id.sw_bool_JK_1_diWenPanGuan);
		sw_bool_JK_1_mieJunYunXing = (Switch) findViewById(R.id.sw_bool_JK_1_mieJunYunXing);
		sw_bool_JK_2_fengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_2_fengJiYiQiDong);
		sw_bool_JK_2_zhiBanStatus = (Switch) findViewById(R.id.sw_bool_JK_2_zhiBanStatus);
		sw_bool_JK_2_dianJiaRe1 = (Switch) findViewById(R.id.sw_bool_JK_2_dianJiaRe1);
		sw_bool_JK_2_dianJiaRe2 = (Switch) findViewById(R.id.sw_bool_JK_2_dianJiaRe2);
		sw_bool_JK_2_dianJiaRe3 = (Switch) findViewById(R.id.sw_bool_JK_2_dianJiaRe3);
		sw_bool_JK_2_fengJiStatus = (Switch) findViewById(R.id.sw_bool_JK_2_fengJiStatus);
		sw_bool_JK_2_shouZiDong = (Switch) findViewById(R.id.sw_bool_JK_2_shouZiDong);
		sw_bool_JK_2_dongXiaJi = (Switch) findViewById(R.id.sw_bool_JK_2_dongXiaJi);
		sw_bool_JK_2_zhongXiaoBaoJing = (Switch) findViewById(R.id.sw_bool_JK_2_zhongXiaoBaoJing);
		sw_bool_JK_2_dianJiaReGaoWen = (Switch) findViewById(R.id.sw_bool_JK_2_dianJiaReGaoWen);
		sw_bool_JK_2_fengJiQueFeng = (Switch) findViewById(R.id.sw_bool_JK_2_fengJiQueFeng);
		sw_bool_JK_2_paiFengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_2_paiFengJiYiQiDong);
		sw_bool_JK_2_diWenPanGuan = (Switch) findViewById(R.id.sw_bool_JK_2_diWenPanGuan);
		sw_bool_JK_2_mieJunYunXing = (Switch) findViewById(R.id.sw_bool_JK_2_mieJunYunXing);
		sw_bool_JK_3_fengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_3_fengJiYiQiDong);
		sw_bool_JK_3_zhiBanStatus = (Switch) findViewById(R.id.sw_bool_JK_3_zhiBanStatus);
		sw_bool_JK_3_dianJiaRe1 = (Switch) findViewById(R.id.sw_bool_JK_3_dianJiaRe1);
		sw_bool_JK_3_dianJiaRe2 = (Switch) findViewById(R.id.sw_bool_JK_3_dianJiaRe2);
		sw_bool_JK_3_dianJiaRe3 = (Switch) findViewById(R.id.sw_bool_JK_3_dianJiaRe3);
		sw_bool_JK_3_fengJiStatus = (Switch) findViewById(R.id.sw_bool_JK_3_fengJiStatus);
		sw_bool_JK_3_shouZiDong = (Switch) findViewById(R.id.sw_bool_JK_3_shouZiDong);
		sw_bool_JK_3_dongXiaJi = (Switch) findViewById(R.id.sw_bool_JK_3_dongXiaJi);
		sw_bool_JK_3_zhongXiaoBaoJing = (Switch) findViewById(R.id.sw_bool_JK_3_zhongXiaoBaoJing);
		sw_bool_JK_3_dianJiaReGaoWen = (Switch) findViewById(R.id.sw_bool_JK_3_dianJiaReGaoWen);
		sw_bool_JK_3_fengJiQueFeng = (Switch) findViewById(R.id.sw_bool_JK_3_fengJiQueFeng);
		sw_bool_JK_3_paiFengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_3_paiFengJiYiQiDong);
		sw_bool_JK_3_diWenPanGuan = (Switch) findViewById(R.id.sw_bool_JK_3_diWenPanGuan);
		sw_bool_JK_3_mieJunYunXing = (Switch) findViewById(R.id.sw_bool_JK_3_mieJunYunXing);
		sw_bool_JK_XF_fengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_XF_fengJiYiQiDong);
		sw_bool_JK_XF_zhiBanStatus = (Switch) findViewById(R.id.sw_bool_JK_XF_zhiBanStatus);
		sw_bool_JK_XF_dianJiaRe1 = (Switch) findViewById(R.id.sw_bool_JK_XF_dianJiaRe1);
		sw_bool_JK_XF_dianJiaRe2 = (Switch) findViewById(R.id.sw_bool_JK_XF_dianJiaRe2);
		sw_bool_JK_XF_dianJiaRe3 = (Switch) findViewById(R.id.sw_bool_JK_XF_dianJiaRe3);
		sw_bool_JK_XF_fengJiStatus = (Switch) findViewById(R.id.sw_bool_JK_XF_fengJiStatus);
		sw_bool_JK_XF_shouZiDong = (Switch) findViewById(R.id.sw_bool_JK_XF_shouZiDong);
		sw_bool_JK_XF_dongXiaJi = (Switch) findViewById(R.id.sw_bool_JK_XF_dongXiaJi);
		sw_bool_JK_XF_zhongXiaoBaoJing = (Switch) findViewById(R.id.sw_bool_JK_XF_zhongXiaoBaoJing);
		sw_bool_JK_XF_dianJiaReGaoWen = (Switch) findViewById(R.id.sw_bool_JK_XF_dianJiaReGaoWen);
		sw_bool_JK_XF_fengJiQueFeng = (Switch) findViewById(R.id.sw_bool_JK_XF_fengJiQueFeng);
		sw_bool_JK_XF_paiFengJiYiQiDong = (Switch) findViewById(R.id.sw_bool_JK_XF_paiFengJiYiQiDong);
		sw_bool_JK_XF_diWenPanGuan = (Switch) findViewById(R.id.sw_bool_JK_XF_diWenPanGuan);
		sw_bool_JK_XF_mieJunYunXing = (Switch) findViewById(R.id.sw_bool_JK_XF_mieJunYunXing);
		tv_data_JK_1_mianBanTongXunZhuangTai1 = (TextView) findViewById(R.id.tv_data_JK_1_mianBanTongXunZhuangTai1);
		tv_data_JK_1_mianBanTongXunZhuangTai2 = (TextView) findViewById(R.id.tv_data_JK_1_mianBanTongXunZhuangTai2);
		tv_data_JK_1_mianBanTongXunZhuangTai3 = (TextView) findViewById(R.id.tv_data_JK_1_mianBanTongXunZhuangTai3);
		tv_data_JK_2_mianBanTongXunZhuangTai1 = (TextView) findViewById(R.id.tv_data_JK_2_mianBanTongXunZhuangTai1);
		tv_data_JK_2_mianBanTongXunZhuangTai2 = (TextView) findViewById(R.id.tv_data_JK_2_mianBanTongXunZhuangTai2);
		tv_data_JK_2_mianBanTongXunZhuangTai3 = (TextView) findViewById(R.id.tv_data_JK_2_mianBanTongXunZhuangTai3);
		tv_data_JK_3_mianBanTongXunZhuangTai1 = (TextView) findViewById(R.id.tv_data_JK_3_mianBanTongXunZhuangTai1);
		tv_data_JK_3_mianBanTongXunZhuangTai2 = (TextView) findViewById(R.id.tv_data_JK_3_mianBanTongXunZhuangTai2);
		tv_data_JK_3_mianBanTongXunZhuangTai3 = (TextView) findViewById(R.id.tv_data_JK_3_mianBanTongXunZhuangTai3);
		tv_data_JK_XF_mianBanTongXunZhuangTai1 = (TextView) findViewById(R.id.tv_data_JK_XF_mianBanTongXunZhuangTai1);
		tv_data_JK_XF_mianBanTongXunZhuangTai2 = (TextView) findViewById(R.id.tv_data_JK_XF_mianBanTongXunZhuangTai2);
		tv_data_JK_XF_mianBanTongXunZhuangTai3 = (TextView) findViewById(R.id.tv_data_JK_XF_mianBanTongXunZhuangTai3);
		tv_data_JK_1_tempReal = (TextView) findViewById(R.id.tv_data_JK_1_tempReal);
		tv_data_JK_1_humiReal = (TextView) findViewById(R.id.tv_data_JK_1_humiReal);
		tv_data_JK_1_tempSet = (TextView) findViewById(R.id.tv_data_JK_1_tempSet);
		tv_data_JK_1_humiSet = (TextView) findViewById(R.id.tv_data_JK_1_humiSet);
		tv_data_JK_1_lengShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_1_lengShuiFaKaiDu);
		tv_data_JK_1_reShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_1_reShuiFaKaiDu);
		tv_data_JK_1_xinFengWenDU = (TextView) findViewById(R.id.tv_data_JK_1_xinFengWenDU);
		tv_data_JK_1_jiaShiQIKaiDu = (TextView) findViewById(R.id.tv_data_JK_1_jiaShiQIKaiDu);
		tv_data_JK_1_beiYong = (TextView) findViewById(R.id.tv_data_JK_1_beiYong);
		tv_data_JK_2_tempReal = (TextView) findViewById(R.id.tv_data_JK_2_tempReal);
		tv_data_JK_2_humiReal = (TextView) findViewById(R.id.tv_data_JK_2_humiReal);
		tv_data_JK_2_tempSet = (TextView) findViewById(R.id.tv_data_JK_2_tempSet);
		tv_data_JK_2_humiSet = (TextView) findViewById(R.id.tv_data_JK_2_humiSet);
		tv_data_JK_2_lengShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_2_lengShuiFaKaiDu);
		tv_data_JK_2_reShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_2_reShuiFaKaiDu);
		tv_data_JK_2_xinFengWenDU = (TextView) findViewById(R.id.tv_data_JK_2_xinFengWenDU);
		tv_data_JK_2_jiaShiQIKaiDu = (TextView) findViewById(R.id.tv_data_JK_2_jiaShiQIKaiDu);
		tv_data_JK_2_beiYong = (TextView) findViewById(R.id.tv_data_JK_2_beiYong);
		tv_data_JK_3_tempReal = (TextView) findViewById(R.id.tv_data_JK_3_tempReal);
		tv_data_JK_3_humiReal = (TextView) findViewById(R.id.tv_data_JK_3_humiReal);
		tv_data_JK_3_tempSet = (TextView) findViewById(R.id.tv_data_JK_3_tempSet);
		tv_data_JK_3_humiSet = (TextView) findViewById(R.id.tv_data_JK_3_humiSet);
		tv_data_JK_3_lengShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_3_lengShuiFaKaiDu);
		tv_data_JK_3_reShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_3_reShuiFaKaiDu);
		tv_data_JK_3_xinFengWenDU = (TextView) findViewById(R.id.tv_data_JK_3_xinFengWenDU);
		tv_data_JK_3_jiaShiQIKaiDu = (TextView) findViewById(R.id.tv_data_JK_3_jiaShiQIKaiDu);
		tv_data_JK_3_beiYong = (TextView) findViewById(R.id.tv_data_JK_3_beiYong);
		tv_data_JK_XF_tempReal = (TextView) findViewById(R.id.tv_data_JK_XF_tempReal);
		tv_data_JK_XF_humiReal = (TextView) findViewById(R.id.tv_data_JK_XF_humiReal);
		tv_data_JK_XF_tempSet = (TextView) findViewById(R.id.tv_data_JK_XF_tempSet);
		tv_data_JK_XF_humiSet = (TextView) findViewById(R.id.tv_data_JK_XF_humiSet);
		tv_data_JK_XF_lengShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_XF_lengShuiFaKaiDu);
		tv_data_JK_XF_reShuiFaKaiDu = (TextView) findViewById(R.id.tv_data_JK_XF_reShuiFaKaiDu);
		tv_data_JK_XF_xinFengWenDU = (TextView) findViewById(R.id.tv_data_JK_XF_xinFengWenDU);
		tv_data_JK_XF_jiaShiQIKaiDu = (TextView) findViewById(R.id.tv_data_JK_XF_jiaShiQIKaiDu);
		tv_data_JK_XF_beiYong = (TextView) findViewById(R.id.tv_data_JK_XF_beiYong);
	}

	private void initEvent() {

		sw_bool_JK_1_fengJiYiQiDong.setEnabled(false);
		sw_bool_JK_1_zhiBanStatus.setEnabled(false);
		sw_bool_JK_1_dianJiaRe1.setEnabled(false);
		sw_bool_JK_1_dianJiaRe2.setEnabled(false);
		sw_bool_JK_1_dianJiaRe3.setEnabled(false);
		sw_bool_JK_1_fengJiStatus.setEnabled(false);
		sw_bool_JK_1_shouZiDong.setEnabled(false);
		sw_bool_JK_1_dongXiaJi.setEnabled(false);
		sw_bool_JK_1_zhongXiaoBaoJing.setEnabled(false);
		sw_bool_JK_1_dianJiaReGaoWen.setEnabled(false);
		sw_bool_JK_1_fengJiQueFeng.setEnabled(false);
		sw_bool_JK_1_paiFengJiYiQiDong.setEnabled(false);
		sw_bool_JK_1_diWenPanGuan.setEnabled(false);
		sw_bool_JK_1_mieJunYunXing.setEnabled(false);
		sw_bool_JK_2_fengJiYiQiDong.setEnabled(false);
		sw_bool_JK_2_zhiBanStatus.setEnabled(false);
		sw_bool_JK_2_dianJiaRe1.setEnabled(false);
		sw_bool_JK_2_dianJiaRe2.setEnabled(false);
		sw_bool_JK_2_dianJiaRe3.setEnabled(false);
		sw_bool_JK_2_fengJiStatus.setEnabled(false);
		sw_bool_JK_2_shouZiDong.setEnabled(false);
		sw_bool_JK_2_dongXiaJi.setEnabled(false);
		sw_bool_JK_2_zhongXiaoBaoJing.setEnabled(false);
		sw_bool_JK_2_dianJiaReGaoWen.setEnabled(false);
		sw_bool_JK_2_fengJiQueFeng.setEnabled(false);
		sw_bool_JK_2_paiFengJiYiQiDong.setEnabled(false);
		sw_bool_JK_2_diWenPanGuan.setEnabled(false);
		sw_bool_JK_2_mieJunYunXing.setEnabled(false);
		sw_bool_JK_3_fengJiYiQiDong.setEnabled(false);
		sw_bool_JK_3_zhiBanStatus.setEnabled(false);
		sw_bool_JK_3_dianJiaRe1.setEnabled(false);
		sw_bool_JK_3_dianJiaRe2.setEnabled(false);
		sw_bool_JK_3_dianJiaRe3.setEnabled(false);
		sw_bool_JK_3_fengJiStatus.setEnabled(false);
		sw_bool_JK_3_shouZiDong.setEnabled(false);
		sw_bool_JK_3_dongXiaJi.setEnabled(false);
		sw_bool_JK_3_zhongXiaoBaoJing.setEnabled(false);
		sw_bool_JK_3_dianJiaReGaoWen.setEnabled(false);
		sw_bool_JK_3_fengJiQueFeng.setEnabled(false);
		sw_bool_JK_3_paiFengJiYiQiDong.setEnabled(false);
		sw_bool_JK_3_diWenPanGuan.setEnabled(false);
		sw_bool_JK_3_mieJunYunXing.setEnabled(false);
		sw_bool_JK_XF_fengJiYiQiDong.setEnabled(false);
		sw_bool_JK_XF_zhiBanStatus.setEnabled(false);
		sw_bool_JK_XF_dianJiaRe1.setEnabled(false);
		sw_bool_JK_XF_dianJiaRe2.setEnabled(false);
		sw_bool_JK_XF_dianJiaRe3.setEnabled(false);
		sw_bool_JK_XF_fengJiStatus.setEnabled(false);
		sw_bool_JK_XF_shouZiDong.setEnabled(false);
		sw_bool_JK_XF_dongXiaJi.setEnabled(false);
		sw_bool_JK_XF_zhongXiaoBaoJing.setEnabled(false);
		sw_bool_JK_XF_dianJiaReGaoWen.setEnabled(false);
		sw_bool_JK_XF_fengJiQueFeng.setEnabled(false);
		sw_bool_JK_XF_paiFengJiYiQiDong.setEnabled(false);
		sw_bool_JK_XF_diWenPanGuan.setEnabled(false);
		sw_bool_JK_XF_mieJunYunXing.setEnabled(false);
	
	}

	private void initDevice() {
		Intent intent = getIntent();
		mDevice = (GizWifiDevice) intent.getParcelableExtra("GizWifiDevice");
		mDevice.setListener(gizWifiDeviceListener);
		Log.i("Apptest", mDevice.getDid());
	}

	private String getDeviceName() {
		if (TextUtils.isEmpty(mDevice.getAlias())) {
			return mDevice.getProductName();
		}
		return mDevice.getAlias();
	}

	@Override
	protected void onResume() {
		super.onResume();
		getStatusOfDevice();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mHandler.removeCallbacks(mRunnable);
		// 退出页面，取消设备订阅
		mDevice.setSubscribe(false);
		mDevice.setListener(null);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		default:
			break;
		}
	}

	/*
	 * ========================================================================
	 * EditText 点击键盘“完成”按钮方法
	 * ========================================================================
	 */
	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

		switch (v.getId()) {
		default:
			break;
		}
		hideKeyBoard();
		return false;

	}
	
	/*
	 * ========================================================================
	 * seekbar 回调方法重写
	 * ========================================================================
	 */
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		
		switch (seekBar.getId()) {
		default:
			break;
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		switch (seekBar.getId()) {
		default:
			break;
		}
	}

	/*
	 * ========================================================================
	 * 菜单栏
	 * ========================================================================
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.device_more, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_setDeviceInfo:
			setDeviceInfo();
			break;

		case R.id.action_getHardwareInfo:
			if (mDevice.isLAN()) {
				mDevice.getHardwareInfo();
			} else {
				myToast("只允许在局域网下获取设备硬件信息！");
			}
			break;

		case R.id.action_getStatu:
			mDevice.getDeviceStatus();
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * Description:根据保存的的数据点的值来更新UI
	 */
	protected void updateUI() {
		
		sw_bool_JK_1_fengJiYiQiDong.setChecked(data_JK_1_fengJiYiQiDong);
		sw_bool_JK_1_zhiBanStatus.setChecked(data_JK_1_zhiBanStatus);
		sw_bool_JK_1_dianJiaRe1.setChecked(data_JK_1_dianJiaRe1);
		sw_bool_JK_1_dianJiaRe2.setChecked(data_JK_1_dianJiaRe2);
		sw_bool_JK_1_dianJiaRe3.setChecked(data_JK_1_dianJiaRe3);
		sw_bool_JK_1_fengJiStatus.setChecked(data_JK_1_fengJiStatus);
		sw_bool_JK_1_shouZiDong.setChecked(data_JK_1_shouZiDong);
		sw_bool_JK_1_dongXiaJi.setChecked(data_JK_1_dongXiaJi);
		sw_bool_JK_1_zhongXiaoBaoJing.setChecked(data_JK_1_zhongXiaoBaoJing);
		sw_bool_JK_1_dianJiaReGaoWen.setChecked(data_JK_1_dianJiaReGaoWen);
		sw_bool_JK_1_fengJiQueFeng.setChecked(data_JK_1_fengJiQueFeng);
		sw_bool_JK_1_paiFengJiYiQiDong.setChecked(data_JK_1_paiFengJiYiQiDong);
		sw_bool_JK_1_diWenPanGuan.setChecked(data_JK_1_diWenPanGuan);
		sw_bool_JK_1_mieJunYunXing.setChecked(data_JK_1_mieJunYunXing);
		sw_bool_JK_2_fengJiYiQiDong.setChecked(data_JK_2_fengJiYiQiDong);
		sw_bool_JK_2_zhiBanStatus.setChecked(data_JK_2_zhiBanStatus);
		sw_bool_JK_2_dianJiaRe1.setChecked(data_JK_2_dianJiaRe1);
		sw_bool_JK_2_dianJiaRe2.setChecked(data_JK_2_dianJiaRe2);
		sw_bool_JK_2_dianJiaRe3.setChecked(data_JK_2_dianJiaRe3);
		sw_bool_JK_2_fengJiStatus.setChecked(data_JK_2_fengJiStatus);
		sw_bool_JK_2_shouZiDong.setChecked(data_JK_2_shouZiDong);
		sw_bool_JK_2_dongXiaJi.setChecked(data_JK_2_dongXiaJi);
		sw_bool_JK_2_zhongXiaoBaoJing.setChecked(data_JK_2_zhongXiaoBaoJing);
		sw_bool_JK_2_dianJiaReGaoWen.setChecked(data_JK_2_dianJiaReGaoWen);
		sw_bool_JK_2_fengJiQueFeng.setChecked(data_JK_2_fengJiQueFeng);
		sw_bool_JK_2_paiFengJiYiQiDong.setChecked(data_JK_2_paiFengJiYiQiDong);
		sw_bool_JK_2_diWenPanGuan.setChecked(data_JK_2_diWenPanGuan);
		sw_bool_JK_2_mieJunYunXing.setChecked(data_JK_2_mieJunYunXing);
		sw_bool_JK_3_fengJiYiQiDong.setChecked(data_JK_3_fengJiYiQiDong);
		sw_bool_JK_3_zhiBanStatus.setChecked(data_JK_3_zhiBanStatus);
		sw_bool_JK_3_dianJiaRe1.setChecked(data_JK_3_dianJiaRe1);
		sw_bool_JK_3_dianJiaRe2.setChecked(data_JK_3_dianJiaRe2);
		sw_bool_JK_3_dianJiaRe3.setChecked(data_JK_3_dianJiaRe3);
		sw_bool_JK_3_fengJiStatus.setChecked(data_JK_3_fengJiStatus);
		sw_bool_JK_3_shouZiDong.setChecked(data_JK_3_shouZiDong);
		sw_bool_JK_3_dongXiaJi.setChecked(data_JK_3_dongXiaJi);
		sw_bool_JK_3_zhongXiaoBaoJing.setChecked(data_JK_3_zhongXiaoBaoJing);
		sw_bool_JK_3_dianJiaReGaoWen.setChecked(data_JK_3_dianJiaReGaoWen);
		sw_bool_JK_3_fengJiQueFeng.setChecked(data_JK_3_fengJiQueFeng);
		sw_bool_JK_3_paiFengJiYiQiDong.setChecked(data_JK_3_paiFengJiYiQiDong);
		sw_bool_JK_3_diWenPanGuan.setChecked(data_JK_3_diWenPanGuan);
		sw_bool_JK_3_mieJunYunXing.setChecked(data_JK_3_mieJunYunXing);
		sw_bool_JK_XF_fengJiYiQiDong.setChecked(data_JK_XF_fengJiYiQiDong);
		sw_bool_JK_XF_zhiBanStatus.setChecked(data_JK_XF_zhiBanStatus);
		sw_bool_JK_XF_dianJiaRe1.setChecked(data_JK_XF_dianJiaRe1);
		sw_bool_JK_XF_dianJiaRe2.setChecked(data_JK_XF_dianJiaRe2);
		sw_bool_JK_XF_dianJiaRe3.setChecked(data_JK_XF_dianJiaRe3);
		sw_bool_JK_XF_fengJiStatus.setChecked(data_JK_XF_fengJiStatus);
		sw_bool_JK_XF_shouZiDong.setChecked(data_JK_XF_shouZiDong);
		sw_bool_JK_XF_dongXiaJi.setChecked(data_JK_XF_dongXiaJi);
		sw_bool_JK_XF_zhongXiaoBaoJing.setChecked(data_JK_XF_zhongXiaoBaoJing);
		sw_bool_JK_XF_dianJiaReGaoWen.setChecked(data_JK_XF_dianJiaReGaoWen);
		sw_bool_JK_XF_fengJiQueFeng.setChecked(data_JK_XF_fengJiQueFeng);
		sw_bool_JK_XF_paiFengJiYiQiDong.setChecked(data_JK_XF_paiFengJiYiQiDong);
		sw_bool_JK_XF_diWenPanGuan.setChecked(data_JK_XF_diWenPanGuan);
		sw_bool_JK_XF_mieJunYunXing.setChecked(data_JK_XF_mieJunYunXing);
		tv_data_JK_1_mianBanTongXunZhuangTai1.setText(data_JK_1_mianBanTongXunZhuangTai1+"");
		tv_data_JK_1_mianBanTongXunZhuangTai2.setText(data_JK_1_mianBanTongXunZhuangTai2+"");
		tv_data_JK_1_mianBanTongXunZhuangTai3.setText(data_JK_1_mianBanTongXunZhuangTai3+"");
		tv_data_JK_2_mianBanTongXunZhuangTai1.setText(data_JK_2_mianBanTongXunZhuangTai1+"");
		tv_data_JK_2_mianBanTongXunZhuangTai2.setText(data_JK_2_mianBanTongXunZhuangTai2+"");
		tv_data_JK_2_mianBanTongXunZhuangTai3.setText(data_JK_2_mianBanTongXunZhuangTai3+"");
		tv_data_JK_3_mianBanTongXunZhuangTai1.setText(data_JK_3_mianBanTongXunZhuangTai1+"");
		tv_data_JK_3_mianBanTongXunZhuangTai2.setText(data_JK_3_mianBanTongXunZhuangTai2+"");
		tv_data_JK_3_mianBanTongXunZhuangTai3.setText(data_JK_3_mianBanTongXunZhuangTai3+"");
		tv_data_JK_XF_mianBanTongXunZhuangTai1.setText(data_JK_XF_mianBanTongXunZhuangTai1+"");
		tv_data_JK_XF_mianBanTongXunZhuangTai2.setText(data_JK_XF_mianBanTongXunZhuangTai2+"");
		tv_data_JK_XF_mianBanTongXunZhuangTai3.setText(data_JK_XF_mianBanTongXunZhuangTai3+"");
		tv_data_JK_1_tempReal.setText(data_JK_1_tempReal+"");
		tv_data_JK_1_humiReal.setText(data_JK_1_humiReal+"");
		tv_data_JK_1_tempSet.setText(data_JK_1_tempSet+"");
		tv_data_JK_1_humiSet.setText(data_JK_1_humiSet+"");
		tv_data_JK_1_lengShuiFaKaiDu.setText(data_JK_1_lengShuiFaKaiDu+"");
		tv_data_JK_1_reShuiFaKaiDu.setText(data_JK_1_reShuiFaKaiDu+"");
		tv_data_JK_1_xinFengWenDU.setText(data_JK_1_xinFengWenDU+"");
		tv_data_JK_1_jiaShiQIKaiDu.setText(data_JK_1_jiaShiQIKaiDu+"");
		tv_data_JK_1_beiYong.setText(data_JK_1_beiYong+"");
		tv_data_JK_2_tempReal.setText(data_JK_2_tempReal+"");
		tv_data_JK_2_humiReal.setText(data_JK_2_humiReal+"");
		tv_data_JK_2_tempSet.setText(data_JK_2_tempSet+"");
		tv_data_JK_2_humiSet.setText(data_JK_2_humiSet+"");
		tv_data_JK_2_lengShuiFaKaiDu.setText(data_JK_2_lengShuiFaKaiDu+"");
		tv_data_JK_2_reShuiFaKaiDu.setText(data_JK_2_reShuiFaKaiDu+"");
		tv_data_JK_2_xinFengWenDU.setText(data_JK_2_xinFengWenDU+"");
		tv_data_JK_2_jiaShiQIKaiDu.setText(data_JK_2_jiaShiQIKaiDu+"");
		tv_data_JK_2_beiYong.setText(data_JK_2_beiYong+"");
		tv_data_JK_3_tempReal.setText(data_JK_3_tempReal+"");
		tv_data_JK_3_humiReal.setText(data_JK_3_humiReal+"");
		tv_data_JK_3_tempSet.setText(data_JK_3_tempSet+"");
		tv_data_JK_3_humiSet.setText(data_JK_3_humiSet+"");
		tv_data_JK_3_lengShuiFaKaiDu.setText(data_JK_3_lengShuiFaKaiDu+"");
		tv_data_JK_3_reShuiFaKaiDu.setText(data_JK_3_reShuiFaKaiDu+"");
		tv_data_JK_3_xinFengWenDU.setText(data_JK_3_xinFengWenDU+"");
		tv_data_JK_3_jiaShiQIKaiDu.setText(data_JK_3_jiaShiQIKaiDu+"");
		tv_data_JK_3_beiYong.setText(data_JK_3_beiYong+"");
		tv_data_JK_XF_tempReal.setText(data_JK_XF_tempReal+"");
		tv_data_JK_XF_humiReal.setText(data_JK_XF_humiReal+"");
		tv_data_JK_XF_tempSet.setText(data_JK_XF_tempSet+"");
		tv_data_JK_XF_humiSet.setText(data_JK_XF_humiSet+"");
		tv_data_JK_XF_lengShuiFaKaiDu.setText(data_JK_XF_lengShuiFaKaiDu+"");
		tv_data_JK_XF_reShuiFaKaiDu.setText(data_JK_XF_reShuiFaKaiDu+"");
		tv_data_JK_XF_xinFengWenDU.setText(data_JK_XF_xinFengWenDU+"");
		tv_data_JK_XF_jiaShiQIKaiDu.setText(data_JK_XF_jiaShiQIKaiDu+"");
		tv_data_JK_XF_beiYong.setText(data_JK_XF_beiYong+"");
	
	}

	private void setEditText(EditText et, Object value) {
		et.setText(value.toString());
		et.setSelection(value.toString().length());
		et.clearFocus();
	}

	/**
	 * Description:页面加载后弹出等待框，等待设备可被控制状态回调，如果一直不可被控，等待一段时间后自动退出界面
	 */
	private void getStatusOfDevice() {
		// 设备是否可控
		if (isDeviceCanBeControlled()) {
			// 可控则查询当前设备状态
			mDevice.getDeviceStatus();
		} else {
			// 显示等待栏
			progressDialog.show();
			if (mDevice.isLAN()) {
				// 小循环10s未连接上设备自动退出
				mHandler.postDelayed(mRunnable, 10000);
			} else {
				// 大循环20s未连接上设备自动退出
				mHandler.postDelayed(mRunnable, 20000);
			}
		}
	}

	/**
	 * 发送指令,下发单个数据点的命令可以用这个方法
	 * 
	 * <h3>注意</h3>
	 * <p>
	 * 下发多个数据点命令不能用这个方法多次调用，一次性多次调用这个方法会导致模组无法正确接收消息，参考方法内注释。
	 * </p>
	 * 
	 * @param key
	 *            数据点对应的标识名
	 * @param value
	 *            需要改变的值
	 */
	private void sendCommand(String key, Object value) {
		if (value == null) {
			return;
		}
		int sn = 5;
		ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<String, Object>();
		hashMap.put(key, value);
		// 同时下发多个数据点需要一次性在map中放置全部需要控制的key，value值
		// hashMap.put(key2, value2);
		// hashMap.put(key3, value3);
		mDevice.write(hashMap, sn);
		Log.i("liang", "下发命令：" + hashMap.toString());
	}

	private boolean isDeviceCanBeControlled() {
		return mDevice.getNetStatus() == GizWifiDeviceNetStatus.GizDeviceControlled;
	}

	private void toastDeviceNoReadyAndExit() {
		Toast.makeText(this, "设备无响应，请检查设备是否正常工作", Toast.LENGTH_SHORT).show();
		finish();
	}

	private void toastDeviceDisconnectAndExit() {
		Toast.makeText(GosDeviceControlActivity.this, "连接已断开", Toast.LENGTH_SHORT).show();
		finish();
	}

	/**
	 * 展示设备硬件信息
	 * 
	 * @param hardwareInfo
	 */
	private void showHardwareInfo(String hardwareInfo) {
		String hardwareInfoTitle = "设备硬件信息";
		new AlertDialog.Builder(this).setTitle(hardwareInfoTitle).setMessage(hardwareInfo)
				.setPositiveButton(R.string.besure, null).show();
	}

	/**
	 * Description:设置设备别名与备注
	 */
	private void setDeviceInfo() {

		final Dialog mDialog = new AlertDialog.Builder(this,R.style.edit_dialog_style).setView(new EditText(this)).create();
		mDialog.show();

		Window window = mDialog.getWindow();
		window.setContentView(R.layout.alert_gos_set_device_info);
		WindowManager.LayoutParams layoutParams = window.getAttributes();
		layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
		window.setAttributes(layoutParams);
		final EditText etAlias;
		final EditText etRemark;
		etAlias = (EditText) window.findViewById(R.id.etAlias);
		etRemark = (EditText) window.findViewById(R.id.etRemark);

		LinearLayout llNo, llSure;
		llNo = (LinearLayout) window.findViewById(R.id.llNo);
		llSure = (LinearLayout) window.findViewById(R.id.llSure);

		if (!TextUtils.isEmpty(mDevice.getAlias())) {
			setEditText(etAlias, mDevice.getAlias());
		}
		if (!TextUtils.isEmpty(mDevice.getRemark())) {
			setEditText(etRemark, mDevice.getRemark());
		}

		llNo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mDialog.dismiss();
			}
		});

		llSure.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (TextUtils.isEmpty(etRemark.getText().toString())
						&& TextUtils.isEmpty(etAlias.getText().toString())) {
					myToast("请输入设备别名或备注！");
					return;
				}
				mDevice.setCustomInfo(etRemark.getText().toString(), etAlias.getText().toString());
				mDialog.dismiss();
				String loadingText = (String) getText(R.string.loadingtext);
				progressDialog.setMessage(loadingText);
				progressDialog.show();
			}
		});

		mDialog.setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface dialog) {
				hideKeyBoard();
			}
		});
	}
	
	/*
	 * 获取设备硬件信息回调
	 */
	@Override
	protected void didGetHardwareInfo(GizWifiErrorCode result, GizWifiDevice device,
			ConcurrentHashMap<String, String> hardwareInfo) {
		super.didGetHardwareInfo(result, device, hardwareInfo);
		StringBuffer sb = new StringBuffer();
		if (GizWifiErrorCode.GIZ_SDK_SUCCESS != result) {
			myToast("获取设备硬件信息失败：" + result.name());
		} else {
			sb.append("Wifi Hardware Version:" + hardwareInfo.get(WIFI_HARDVER_KEY) + "\r\n");
			sb.append("Wifi Software Version:" + hardwareInfo.get(WIFI_SOFTVER_KEY) + "\r\n");
			sb.append("MCU Hardware Version:" + hardwareInfo.get(MCU_HARDVER_KEY) + "\r\n");
			sb.append("MCU Software Version:" + hardwareInfo.get(MCU_SOFTVER_KEY) + "\r\n");
			sb.append("Wifi Firmware Id:" + hardwareInfo.get(WIFI_FIRMWAREID_KEY) + "\r\n");
			sb.append("Wifi Firmware Version:" + hardwareInfo.get(WIFI_FIRMWAREVER_KEY) + "\r\n");
			sb.append("Product Key:" + "\r\n" + hardwareInfo.get(PRODUCT_KEY) + "\r\n");

			// 设备属性
			sb.append("Device ID:" + "\r\n" + mDevice.getDid() + "\r\n");
			sb.append("Device IP:" + mDevice.getIPAddress() + "\r\n");
			sb.append("Device MAC:" + mDevice.getMacAddress() + "\r\n");
		}
		showHardwareInfo(sb.toString());
	}
	
	/*
	 * 设置设备别名和备注回调
	 */
	@Override
	protected void didSetCustomInfo(GizWifiErrorCode result, GizWifiDevice device) {
		super.didSetCustomInfo(result, device);
		if (GizWifiErrorCode.GIZ_SDK_SUCCESS == result) {
			myToast("设置成功");
			progressDialog.cancel();
			finish();
		} else {
			myToast("设置失败：" + result.name());
		}
	}

	/*
	 * 设备状态改变回调，只有设备状态为可控才可以下发控制命令
	 */
	@Override
	protected void didUpdateNetStatus(GizWifiDevice device, GizWifiDeviceNetStatus netStatus) {
		super.didUpdateNetStatus(device, netStatus);
		if (netStatus == GizWifiDeviceNetStatus.GizDeviceControlled) {
			mHandler.removeCallbacks(mRunnable);
			progressDialog.cancel();
		} else {
			mHandler.sendEmptyMessage(handler_key.DISCONNECT.ordinal());
		}
	}
	
	/*
	 * 设备上报数据回调，此回调包括设备主动上报数据、下发控制命令成功后设备返回ACK
	 */
	@Override
	protected void didReceiveData(GizWifiErrorCode result, GizWifiDevice device,
			ConcurrentHashMap<String, Object> dataMap, int sn) {
		super.didReceiveData(result, device, dataMap, sn);
		Log.i("liang", "接收到数据");
		if (result == GizWifiErrorCode.GIZ_SDK_SUCCESS && dataMap.get("data") != null) {
			getDataFromReceiveDataMap(dataMap);
			mHandler.sendEmptyMessage(handler_key.UPDATE_UI.ordinal());
		}
	}

}