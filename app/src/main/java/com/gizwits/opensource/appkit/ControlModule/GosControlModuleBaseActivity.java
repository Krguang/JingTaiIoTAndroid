package com.gizwits.opensource.appkit.ControlModule;

import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;

import com.gizwits.gizwifisdk.api.GizWifiDevice;
import com.gizwits.gizwifisdk.enumration.GizWifiDeviceNetStatus;
import com.gizwits.gizwifisdk.enumration.GizWifiErrorCode;
import com.gizwits.gizwifisdk.listener.GizWifiDeviceListener;
import com.gizwits.opensource.appkit.CommonModule.GosBaseActivity;
import com.gizwits.opensource.appkit.utils.HexStrUtils;

import android.util.Log;
import android.content.Context;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class GosControlModuleBaseActivity extends GosBaseActivity {

	/*
	 * ===========================================================
	 * 以下key值对应开发者在云端定义的数据点标识名
	 * ===========================================================
	 */
	// 数据点"风机已启动A1"对应的标识名
	protected static final String KEY_JK_1_FENGJIYIQIDONG = "JK_1_fengJiYiQiDong";
	// 数据点"值班状态A1"对应的标识名
	protected static final String KEY_JK_1_ZHIBANSTATUS = "JK_1_zhiBanStatus";
	// 数据点"电加热1A1"对应的标识名
	protected static final String KEY_JK_1_DIANJIARE1 = "JK_1_dianJiaRe1";
	// 数据点"电加热2A1"对应的标识名
	protected static final String KEY_JK_1_DIANJIARE2 = "JK_1_dianJiaRe2";
	// 数据点"电加热3A1"对应的标识名
	protected static final String KEY_JK_1_DIANJIARE3 = "JK_1_dianJiaRe3";
	// 数据点"风机状态A1"对应的标识名
	protected static final String KEY_JK_1_FENGJISTATUS = "JK_1_fengJiStatus";
	// 数据点"手自动A1"对应的标识名
	protected static final String KEY_JK_1_SHOUZIDONG = "JK_1_shouZiDong";
	// 数据点"冬夏季A1"对应的标识名
	protected static final String KEY_JK_1_DONGXIAJI = "JK_1_dongXiaJi";
	// 数据点"中效报警A1"对应的标识名
	protected static final String KEY_JK_1_ZHONGXIAOBAOJING = "JK_1_zhongXiaoBaoJing";
	// 数据点"电加热高温A1"对应的标识名
	protected static final String KEY_JK_1_DIANJIAREGAOWEN = "JK_1_dianJiaReGaoWen";
	// 数据点"风机缺风A1"对应的标识名
	protected static final String KEY_JK_1_FENGJIQUEFENG = "JK_1_fengJiQueFeng";
	// 数据点"排风机已启动A1"对应的标识名
	protected static final String KEY_JK_1_PAIFENGJIYIQIDONG = "JK_1_paiFengJiYiQiDong";
	// 数据点"盘管低温A1"对应的标识名
	protected static final String KEY_JK_1_DIWENPANGUAN = "JK_1_diWenPanGuan";
	// 数据点"灭菌运行A1"对应的标识名
	protected static final String KEY_JK_1_MIEJUNYUNXING = "JK_1_mieJunYunXing";
	// 数据点"风机已启动A2"对应的标识名
	protected static final String KEY_JK_2_FENGJIYIQIDONG = "JK_2_fengJiYiQiDong";
	// 数据点"值班状态A2"对应的标识名
	protected static final String KEY_JK_2_ZHIBANSTATUS = "JK_2_zhiBanStatus";
	// 数据点"电加热1A2"对应的标识名
	protected static final String KEY_JK_2_DIANJIARE1 = "JK_2_dianJiaRe1";
	// 数据点"电加热2A2"对应的标识名
	protected static final String KEY_JK_2_DIANJIARE2 = "JK_2_dianJiaRe2";
	// 数据点"电加热3A2"对应的标识名
	protected static final String KEY_JK_2_DIANJIARE3 = "JK_2_dianJiaRe3";
	// 数据点"风机状态A2"对应的标识名
	protected static final String KEY_JK_2_FENGJISTATUS = "JK_2_fengJiStatus";
	// 数据点"手自动A2"对应的标识名
	protected static final String KEY_JK_2_SHOUZIDONG = "JK_2_shouZiDong";
	// 数据点"冬夏季A2"对应的标识名
	protected static final String KEY_JK_2_DONGXIAJI = "JK_2_dongXiaJi";
	// 数据点"中效报警A2"对应的标识名
	protected static final String KEY_JK_2_ZHONGXIAOBAOJING = "JK_2_zhongXiaoBaoJing";
	// 数据点"电加热高温A2"对应的标识名
	protected static final String KEY_JK_2_DIANJIAREGAOWEN = "JK_2_dianJiaReGaoWen";
	// 数据点"风机缺风A2"对应的标识名
	protected static final String KEY_JK_2_FENGJIQUEFENG = "JK_2_fengJiQueFeng";
	// 数据点"排风机已启动A2"对应的标识名
	protected static final String KEY_JK_2_PAIFENGJIYIQIDONG = "JK_2_paiFengJiYiQiDong";
	// 数据点"盘管低温A2"对应的标识名
	protected static final String KEY_JK_2_DIWENPANGUAN = "JK_2_diWenPanGuan";
	// 数据点"灭菌运行A2"对应的标识名
	protected static final String KEY_JK_2_MIEJUNYUNXING = "JK_2_mieJunYunXing";
	// 数据点"风机已启动A3"对应的标识名
	protected static final String KEY_JK_3_FENGJIYIQIDONG = "JK_3_fengJiYiQiDong";
	// 数据点"值班状态A3"对应的标识名
	protected static final String KEY_JK_3_ZHIBANSTATUS = "JK_3_zhiBanStatus";
	// 数据点"电加热1A3"对应的标识名
	protected static final String KEY_JK_3_DIANJIARE1 = "JK_3_dianJiaRe1";
	// 数据点"电加热2A3"对应的标识名
	protected static final String KEY_JK_3_DIANJIARE2 = "JK_3_dianJiaRe2";
	// 数据点"电加热3A3"对应的标识名
	protected static final String KEY_JK_3_DIANJIARE3 = "JK_3_dianJiaRe3";
	// 数据点"风机状态A3"对应的标识名
	protected static final String KEY_JK_3_FENGJISTATUS = "JK_3_fengJiStatus";
	// 数据点"手自动A3"对应的标识名
	protected static final String KEY_JK_3_SHOUZIDONG = "JK_3_shouZiDong";
	// 数据点"冬夏季A3"对应的标识名
	protected static final String KEY_JK_3_DONGXIAJI = "JK_3_dongXiaJi";
	// 数据点"中效报警A3"对应的标识名
	protected static final String KEY_JK_3_ZHONGXIAOBAOJING = "JK_3_zhongXiaoBaoJing";
	// 数据点"电加热高温A3"对应的标识名
	protected static final String KEY_JK_3_DIANJIAREGAOWEN = "JK_3_dianJiaReGaoWen";
	// 数据点"风机缺风A3"对应的标识名
	protected static final String KEY_JK_3_FENGJIQUEFENG = "JK_3_fengJiQueFeng";
	// 数据点"排风机已启动A3"对应的标识名
	protected static final String KEY_JK_3_PAIFENGJIYIQIDONG = "JK_3_paiFengJiYiQiDong";
	// 数据点"盘管低温A3"对应的标识名
	protected static final String KEY_JK_3_DIWENPANGUAN = "JK_3_diWenPanGuan";
	// 数据点"灭菌运行A3"对应的标识名
	protected static final String KEY_JK_3_MIEJUNYUNXING = "JK_3_mieJunYunXing";
	// 数据点"风机已启动A4"对应的标识名
	protected static final String KEY_JK_XF_FENGJIYIQIDONG = "JK_XF_fengJiYiQiDong";
	// 数据点"值班状态A4"对应的标识名
	protected static final String KEY_JK_XF_ZHIBANSTATUS = "JK_XF_zhiBanStatus";
	// 数据点"电加热1A4"对应的标识名
	protected static final String KEY_JK_XF_DIANJIARE1 = "JK_XF_dianJiaRe1";
	// 数据点"电加热2A4"对应的标识名
	protected static final String KEY_JK_XF_DIANJIARE2 = "JK_XF_dianJiaRe2";
	// 数据点"电加热3A4"对应的标识名
	protected static final String KEY_JK_XF_DIANJIARE3 = "JK_XF_dianJiaRe3";
	// 数据点"风机状态A4"对应的标识名
	protected static final String KEY_JK_XF_FENGJISTATUS = "JK_XF_fengJiStatus";
	// 数据点"手自动A4"对应的标识名
	protected static final String KEY_JK_XF_SHOUZIDONG = "JK_XF_shouZiDong";
	// 数据点"冬夏季A4"对应的标识名
	protected static final String KEY_JK_XF_DONGXIAJI = "JK_XF_dongXiaJi";
	// 数据点"中效报警A4"对应的标识名
	protected static final String KEY_JK_XF_ZHONGXIAOBAOJING = "JK_XF_zhongXiaoBaoJing";
	// 数据点"电加热高温A4"对应的标识名
	protected static final String KEY_JK_XF_DIANJIAREGAOWEN = "JK_XF_dianJiaReGaoWen";
	// 数据点"风机缺风A4"对应的标识名
	protected static final String KEY_JK_XF_FENGJIQUEFENG = "JK_XF_fengJiQueFeng";
	// 数据点"排风机已启动A4"对应的标识名
	protected static final String KEY_JK_XF_PAIFENGJIYIQIDONG = "JK_XF_paiFengJiYiQiDong";
	// 数据点"盘管低温A4"对应的标识名
	protected static final String KEY_JK_XF_DIWENPANGUAN = "JK_XF_diWenPanGuan";
	// 数据点"灭菌运行A4"对应的标识名
	protected static final String KEY_JK_XF_MIEJUNYUNXING = "JK_XF_mieJunYunXing";
	// 数据点"面板1通讯状态A1"对应的标识名
	protected static final String KEY_JK_1_MIANBANTONGXUNZHUANGTAI1 = "JK_1_mianBanTongXunZhuangTai1";
	// 数据点"面板2通讯状态A1"对应的标识名
	protected static final String KEY_JK_1_MIANBANTONGXUNZHUANGTAI2 = "JK_1_mianBanTongXunZhuangTai2";
	// 数据点"面板3通讯状态A1"对应的标识名
	protected static final String KEY_JK_1_MIANBANTONGXUNZHUANGTAI3 = "JK_1_mianBanTongXunZhuangTai3";
	// 数据点"面板1通讯状态A2"对应的标识名
	protected static final String KEY_JK_2_MIANBANTONGXUNZHUANGTAI1 = "JK_2_mianBanTongXunZhuangTai1";
	// 数据点"面板2通讯状态A2"对应的标识名
	protected static final String KEY_JK_2_MIANBANTONGXUNZHUANGTAI2 = "JK_2_mianBanTongXunZhuangTai2";
	// 数据点"面板3通讯状态A2"对应的标识名
	protected static final String KEY_JK_2_MIANBANTONGXUNZHUANGTAI3 = "JK_2_mianBanTongXunZhuangTai3";
	// 数据点"面板1通讯状态A3"对应的标识名
	protected static final String KEY_JK_3_MIANBANTONGXUNZHUANGTAI1 = "JK_3_mianBanTongXunZhuangTai1";
	// 数据点"面板2通讯状态A3"对应的标识名
	protected static final String KEY_JK_3_MIANBANTONGXUNZHUANGTAI2 = "JK_3_mianBanTongXunZhuangTai2";
	// 数据点"面板3通讯状态A3"对应的标识名
	protected static final String KEY_JK_3_MIANBANTONGXUNZHUANGTAI3 = "JK_3_mianBanTongXunZhuangTai3";
	// 数据点"面板1通讯状态A4"对应的标识名
	protected static final String KEY_JK_XF_MIANBANTONGXUNZHUANGTAI1 = "JK_XF_mianBanTongXunZhuangTai1";
	// 数据点"面板2通讯状态A4"对应的标识名
	protected static final String KEY_JK_XF_MIANBANTONGXUNZHUANGTAI2 = "JK_XF_mianBanTongXunZhuangTai2";
	// 数据点"面板3通讯状态A4"对应的标识名
	protected static final String KEY_JK_XF_MIANBANTONGXUNZHUANGTAI3 = "JK_XF_mianBanTongXunZhuangTai3";
	// 数据点"实时温度A1"对应的标识名
	protected static final String KEY_JK_1_TEMPREAL = "JK_1_tempReal";
	// 数据点"实时湿度A1"对应的标识名
	protected static final String KEY_JK_1_HUMIREAL = "JK_1_humiReal";
	// 数据点"温度设定值A1"对应的标识名
	protected static final String KEY_JK_1_TEMPSET = "JK_1_tempSet";
	// 数据点"湿度设定值A1"对应的标识名
	protected static final String KEY_JK_1_HUMISET = "JK_1_humiSet";
	// 数据点"冷水阀开度A1"对应的标识名
	protected static final String KEY_JK_1_LENGSHUIFAKAIDU = "JK_1_lengShuiFaKaiDu";
	// 数据点"热水阀开度A1"对应的标识名
	protected static final String KEY_JK_1_RESHUIFAKAIDU = "JK_1_reShuiFaKaiDu";
	// 数据点"新风温度A1"对应的标识名
	protected static final String KEY_JK_1_XINFENGWENDU = "JK_1_xinFengWenDU";
	// 数据点"加湿器开度A1"对应的标识名
	protected static final String KEY_JK_1_JIASHIQIKAIDU = "JK_1_jiaShiQIKaiDu";
	// 数据点"备用A1"对应的标识名
	protected static final String KEY_JK_1_BEIYONG = "JK_1_beiYong";
	// 数据点"实时温度A2"对应的标识名
	protected static final String KEY_JK_2_TEMPREAL = "JK_2_tempReal";
	// 数据点"实时湿度A2"对应的标识名
	protected static final String KEY_JK_2_HUMIREAL = "JK_2_humiReal";
	// 数据点"温度设定值A2"对应的标识名
	protected static final String KEY_JK_2_TEMPSET = "JK_2_tempSet";
	// 数据点"湿度设定值A2"对应的标识名
	protected static final String KEY_JK_2_HUMISET = "JK_2_humiSet";
	// 数据点"冷水阀开度A2"对应的标识名
	protected static final String KEY_JK_2_LENGSHUIFAKAIDU = "JK_2_lengShuiFaKaiDu";
	// 数据点"热水阀开度A2"对应的标识名
	protected static final String KEY_JK_2_RESHUIFAKAIDU = "JK_2_reShuiFaKaiDu";
	// 数据点"新风温度A2"对应的标识名
	protected static final String KEY_JK_2_XINFENGWENDU = "JK_2_xinFengWenDU";
	// 数据点"加湿器开度A2"对应的标识名
	protected static final String KEY_JK_2_JIASHIQIKAIDU = "JK_2_jiaShiQIKaiDu";
	// 数据点"备用A2"对应的标识名
	protected static final String KEY_JK_2_BEIYONG = "JK_2_beiYong";
	// 数据点"实时温度A3"对应的标识名
	protected static final String KEY_JK_3_TEMPREAL = "JK_3_tempReal";
	// 数据点"实时湿度A3"对应的标识名
	protected static final String KEY_JK_3_HUMIREAL = "JK_3_humiReal";
	// 数据点"温度设定值A3"对应的标识名
	protected static final String KEY_JK_3_TEMPSET = "JK_3_tempSet";
	// 数据点"湿度设定值A3"对应的标识名
	protected static final String KEY_JK_3_HUMISET = "JK_3_humiSet";
	// 数据点"冷水阀开度A3"对应的标识名
	protected static final String KEY_JK_3_LENGSHUIFAKAIDU = "JK_3_lengShuiFaKaiDu";
	// 数据点"热水阀开度A3"对应的标识名
	protected static final String KEY_JK_3_RESHUIFAKAIDU = "JK_3_reShuiFaKaiDu";
	// 数据点"新风温度A3"对应的标识名
	protected static final String KEY_JK_3_XINFENGWENDU = "JK_3_xinFengWenDU";
	// 数据点"加湿器开度A3"对应的标识名
	protected static final String KEY_JK_3_JIASHIQIKAIDU = "JK_3_jiaShiQIKaiDu";
	// 数据点"备用A3"对应的标识名
	protected static final String KEY_JK_3_BEIYONG = "JK_3_beiYong";
	// 数据点"实时温度A4"对应的标识名
	protected static final String KEY_JK_XF_TEMPREAL = "JK_XF_tempReal";
	// 数据点"实时湿度A4"对应的标识名
	protected static final String KEY_JK_XF_HUMIREAL = "JK_XF_humiReal";
	// 数据点"温度设定值A4"对应的标识名
	protected static final String KEY_JK_XF_TEMPSET = "JK_XF_tempSet";
	// 数据点"湿度设定值A4"对应的标识名
	protected static final String KEY_JK_XF_HUMISET = "JK_XF_humiSet";
	// 数据点"冷水阀开度A4"对应的标识名
	protected static final String KEY_JK_XF_LENGSHUIFAKAIDU = "JK_XF_lengShuiFaKaiDu";
	// 数据点"热水阀开度A4"对应的标识名
	protected static final String KEY_JK_XF_RESHUIFAKAIDU = "JK_XF_reShuiFaKaiDu";
	// 数据点"新风温度A4"对应的标识名
	protected static final String KEY_JK_XF_XINFENGWENDU = "JK_XF_xinFengWenDU";
	// 数据点"加湿器开度A4"对应的标识名
	protected static final String KEY_JK_XF_JIASHIQIKAIDU = "JK_XF_jiaShiQIKaiDu";
	// 数据点"备用A4"对应的标识名
	protected static final String KEY_JK_XF_BEIYONG = "JK_XF_beiYong";

	/*
	 * ===========================================================
	 * 以下数值对应开发者在云端定义的可写数值型数据点增量值、数据点定义的分辨率、seekbar滚动条补偿值
	 * _ADDITION:数据点增量值
	 * _RATIO:数据点定义的分辨率
	 * _OFFSET:seekbar滚动条补偿值
	 * APP与设备定义的协议公式为：y（APP接收的值）=x（设备上报的值）* RATIO（分辨率）+ADDITION（增量值）
	 * 由于安卓的原生seekbar无法设置最小值，因此代码中增加了一个补偿量OFFSET
	 * 实际上公式中的：x（设备上报的值）=seekbar的值+补偿值
	 * ===========================================================
	 */

	/*
	 * ===========================================================
	 * 以下变量对应设备上报类型为布尔、数值、扩展数据点的数据存储
	 * ===========================================================
	 */
	// 数据点"风机已启动A1"对应的存储数据
	protected static boolean data_JK_1_fengJiYiQiDong;
	// 数据点"值班状态A1"对应的存储数据
	protected static boolean data_JK_1_zhiBanStatus;
	// 数据点"电加热1A1"对应的存储数据
	protected static boolean data_JK_1_dianJiaRe1;
	// 数据点"电加热2A1"对应的存储数据
	protected static boolean data_JK_1_dianJiaRe2;
	// 数据点"电加热3A1"对应的存储数据
	protected static boolean data_JK_1_dianJiaRe3;
	// 数据点"风机状态A1"对应的存储数据
	protected static boolean data_JK_1_fengJiStatus;
	// 数据点"手自动A1"对应的存储数据
	protected static boolean data_JK_1_shouZiDong;
	// 数据点"冬夏季A1"对应的存储数据
	protected static boolean data_JK_1_dongXiaJi;
	// 数据点"中效报警A1"对应的存储数据
	protected static boolean data_JK_1_zhongXiaoBaoJing;
	// 数据点"电加热高温A1"对应的存储数据
	protected static boolean data_JK_1_dianJiaReGaoWen;
	// 数据点"风机缺风A1"对应的存储数据
	protected static boolean data_JK_1_fengJiQueFeng;
	// 数据点"排风机已启动A1"对应的存储数据
	protected static boolean data_JK_1_paiFengJiYiQiDong;
	// 数据点"盘管低温A1"对应的存储数据
	protected static boolean data_JK_1_diWenPanGuan;
	// 数据点"灭菌运行A1"对应的存储数据
	protected static boolean data_JK_1_mieJunYunXing;
	// 数据点"风机已启动A2"对应的存储数据
	protected static boolean data_JK_2_fengJiYiQiDong;
	// 数据点"值班状态A2"对应的存储数据
	protected static boolean data_JK_2_zhiBanStatus;
	// 数据点"电加热1A2"对应的存储数据
	protected static boolean data_JK_2_dianJiaRe1;
	// 数据点"电加热2A2"对应的存储数据
	protected static boolean data_JK_2_dianJiaRe2;
	// 数据点"电加热3A2"对应的存储数据
	protected static boolean data_JK_2_dianJiaRe3;
	// 数据点"风机状态A2"对应的存储数据
	protected static boolean data_JK_2_fengJiStatus;
	// 数据点"手自动A2"对应的存储数据
	protected static boolean data_JK_2_shouZiDong;
	// 数据点"冬夏季A2"对应的存储数据
	protected static boolean data_JK_2_dongXiaJi;
	// 数据点"中效报警A2"对应的存储数据
	protected static boolean data_JK_2_zhongXiaoBaoJing;
	// 数据点"电加热高温A2"对应的存储数据
	protected static boolean data_JK_2_dianJiaReGaoWen;
	// 数据点"风机缺风A2"对应的存储数据
	protected static boolean data_JK_2_fengJiQueFeng;
	// 数据点"排风机已启动A2"对应的存储数据
	protected static boolean data_JK_2_paiFengJiYiQiDong;
	// 数据点"盘管低温A2"对应的存储数据
	protected static boolean data_JK_2_diWenPanGuan;
	// 数据点"灭菌运行A2"对应的存储数据
	protected static boolean data_JK_2_mieJunYunXing;
	// 数据点"风机已启动A3"对应的存储数据
	protected static boolean data_JK_3_fengJiYiQiDong;
	// 数据点"值班状态A3"对应的存储数据
	protected static boolean data_JK_3_zhiBanStatus;
	// 数据点"电加热1A3"对应的存储数据
	protected static boolean data_JK_3_dianJiaRe1;
	// 数据点"电加热2A3"对应的存储数据
	protected static boolean data_JK_3_dianJiaRe2;
	// 数据点"电加热3A3"对应的存储数据
	protected static boolean data_JK_3_dianJiaRe3;
	// 数据点"风机状态A3"对应的存储数据
	protected static boolean data_JK_3_fengJiStatus;
	// 数据点"手自动A3"对应的存储数据
	protected static boolean data_JK_3_shouZiDong;
	// 数据点"冬夏季A3"对应的存储数据
	protected static boolean data_JK_3_dongXiaJi;
	// 数据点"中效报警A3"对应的存储数据
	protected static boolean data_JK_3_zhongXiaoBaoJing;
	// 数据点"电加热高温A3"对应的存储数据
	protected static boolean data_JK_3_dianJiaReGaoWen;
	// 数据点"风机缺风A3"对应的存储数据
	protected static boolean data_JK_3_fengJiQueFeng;
	// 数据点"排风机已启动A3"对应的存储数据
	protected static boolean data_JK_3_paiFengJiYiQiDong;
	// 数据点"盘管低温A3"对应的存储数据
	protected static boolean data_JK_3_diWenPanGuan;
	// 数据点"灭菌运行A3"对应的存储数据
	protected static boolean data_JK_3_mieJunYunXing;
	// 数据点"风机已启动A4"对应的存储数据
	protected static boolean data_JK_XF_fengJiYiQiDong;
	// 数据点"值班状态A4"对应的存储数据
	protected static boolean data_JK_XF_zhiBanStatus;
	// 数据点"电加热1A4"对应的存储数据
	protected static boolean data_JK_XF_dianJiaRe1;
	// 数据点"电加热2A4"对应的存储数据
	protected static boolean data_JK_XF_dianJiaRe2;
	// 数据点"电加热3A4"对应的存储数据
	protected static boolean data_JK_XF_dianJiaRe3;
	// 数据点"风机状态A4"对应的存储数据
	protected static boolean data_JK_XF_fengJiStatus;
	// 数据点"手自动A4"对应的存储数据
	protected static boolean data_JK_XF_shouZiDong;
	// 数据点"冬夏季A4"对应的存储数据
	protected static boolean data_JK_XF_dongXiaJi;
	// 数据点"中效报警A4"对应的存储数据
	protected static boolean data_JK_XF_zhongXiaoBaoJing;
	// 数据点"电加热高温A4"对应的存储数据
	protected static boolean data_JK_XF_dianJiaReGaoWen;
	// 数据点"风机缺风A4"对应的存储数据
	protected static boolean data_JK_XF_fengJiQueFeng;
	// 数据点"排风机已启动A4"对应的存储数据
	protected static boolean data_JK_XF_paiFengJiYiQiDong;
	// 数据点"盘管低温A4"对应的存储数据
	protected static boolean data_JK_XF_diWenPanGuan;
	// 数据点"灭菌运行A4"对应的存储数据
	protected static boolean data_JK_XF_mieJunYunXing;
	// 数据点"面板1通讯状态A1"对应的存储数据
	protected static int data_JK_1_mianBanTongXunZhuangTai1;
	// 数据点"面板2通讯状态A1"对应的存储数据
	protected static int data_JK_1_mianBanTongXunZhuangTai2;
	// 数据点"面板3通讯状态A1"对应的存储数据
	protected static int data_JK_1_mianBanTongXunZhuangTai3;
	// 数据点"面板1通讯状态A2"对应的存储数据
	protected static int data_JK_2_mianBanTongXunZhuangTai1;
	// 数据点"面板2通讯状态A2"对应的存储数据
	protected static int data_JK_2_mianBanTongXunZhuangTai2;
	// 数据点"面板3通讯状态A2"对应的存储数据
	protected static int data_JK_2_mianBanTongXunZhuangTai3;
	// 数据点"面板1通讯状态A3"对应的存储数据
	protected static int data_JK_3_mianBanTongXunZhuangTai1;
	// 数据点"面板2通讯状态A3"对应的存储数据
	protected static int data_JK_3_mianBanTongXunZhuangTai2;
	// 数据点"面板3通讯状态A3"对应的存储数据
	protected static int data_JK_3_mianBanTongXunZhuangTai3;
	// 数据点"面板1通讯状态A4"对应的存储数据
	protected static int data_JK_XF_mianBanTongXunZhuangTai1;
	// 数据点"面板2通讯状态A4"对应的存储数据
	protected static int data_JK_XF_mianBanTongXunZhuangTai2;
	// 数据点"面板3通讯状态A4"对应的存储数据
	protected static int data_JK_XF_mianBanTongXunZhuangTai3;
	// 数据点"实时温度A1"对应的存储数据
	protected static int data_JK_1_tempReal;
	// 数据点"实时湿度A1"对应的存储数据
	protected static int data_JK_1_humiReal;
	// 数据点"温度设定值A1"对应的存储数据
	protected static int data_JK_1_tempSet;
	// 数据点"湿度设定值A1"对应的存储数据
	protected static int data_JK_1_humiSet;
	// 数据点"冷水阀开度A1"对应的存储数据
	protected static int data_JK_1_lengShuiFaKaiDu;
	// 数据点"热水阀开度A1"对应的存储数据
	protected static int data_JK_1_reShuiFaKaiDu;
	// 数据点"新风温度A1"对应的存储数据
	protected static int data_JK_1_xinFengWenDU;
	// 数据点"加湿器开度A1"对应的存储数据
	protected static int data_JK_1_jiaShiQIKaiDu;
	// 数据点"备用A1"对应的存储数据
	protected static int data_JK_1_beiYong;
	// 数据点"实时温度A2"对应的存储数据
	protected static int data_JK_2_tempReal;
	// 数据点"实时湿度A2"对应的存储数据
	protected static int data_JK_2_humiReal;
	// 数据点"温度设定值A2"对应的存储数据
	protected static int data_JK_2_tempSet;
	// 数据点"湿度设定值A2"对应的存储数据
	protected static int data_JK_2_humiSet;
	// 数据点"冷水阀开度A2"对应的存储数据
	protected static int data_JK_2_lengShuiFaKaiDu;
	// 数据点"热水阀开度A2"对应的存储数据
	protected static int data_JK_2_reShuiFaKaiDu;
	// 数据点"新风温度A2"对应的存储数据
	protected static int data_JK_2_xinFengWenDU;
	// 数据点"加湿器开度A2"对应的存储数据
	protected static int data_JK_2_jiaShiQIKaiDu;
	// 数据点"备用A2"对应的存储数据
	protected static int data_JK_2_beiYong;
	// 数据点"实时温度A3"对应的存储数据
	protected static int data_JK_3_tempReal;
	// 数据点"实时湿度A3"对应的存储数据
	protected static int data_JK_3_humiReal;
	// 数据点"温度设定值A3"对应的存储数据
	protected static int data_JK_3_tempSet;
	// 数据点"湿度设定值A3"对应的存储数据
	protected static int data_JK_3_humiSet;
	// 数据点"冷水阀开度A3"对应的存储数据
	protected static int data_JK_3_lengShuiFaKaiDu;
	// 数据点"热水阀开度A3"对应的存储数据
	protected static int data_JK_3_reShuiFaKaiDu;
	// 数据点"新风温度A3"对应的存储数据
	protected static int data_JK_3_xinFengWenDU;
	// 数据点"加湿器开度A3"对应的存储数据
	protected static int data_JK_3_jiaShiQIKaiDu;
	// 数据点"备用A3"对应的存储数据
	protected static int data_JK_3_beiYong;
	// 数据点"实时温度A4"对应的存储数据
	protected static int data_JK_XF_tempReal;
	// 数据点"实时湿度A4"对应的存储数据
	protected static int data_JK_XF_humiReal;
	// 数据点"温度设定值A4"对应的存储数据
	protected static int data_JK_XF_tempSet;
	// 数据点"湿度设定值A4"对应的存储数据
	protected static int data_JK_XF_humiSet;
	// 数据点"冷水阀开度A4"对应的存储数据
	protected static int data_JK_XF_lengShuiFaKaiDu;
	// 数据点"热水阀开度A4"对应的存储数据
	protected static int data_JK_XF_reShuiFaKaiDu;
	// 数据点"新风温度A4"对应的存储数据
	protected static int data_JK_XF_xinFengWenDU;
	// 数据点"加湿器开度A4"对应的存储数据
	protected static int data_JK_XF_jiaShiQIKaiDu;
	// 数据点"备用A4"对应的存储数据
	protected static int data_JK_XF_beiYong;

	/*
	 * ===========================================================
	 * 以下key值对应设备硬件信息各明细的名称，用与回调中提取硬件信息字段。
	 * ===========================================================
	 */
	protected static final String WIFI_HARDVER_KEY = "wifiHardVersion";
	protected static final String WIFI_SOFTVER_KEY = "wifiSoftVersion";
	protected static final String MCU_HARDVER_KEY = "mcuHardVersion";
	protected static final String MCU_SOFTVER_KEY = "mcuSoftVersion";
	protected static final String WIFI_FIRMWAREID_KEY = "wifiFirmwareId";
	protected static final String WIFI_FIRMWAREVER_KEY = "wifiFirmwareVer";
	protected static final String PRODUCT_KEY = "productKey";

	private Toast mToast;
	
	@SuppressWarnings("unchecked")
	protected void getDataFromReceiveDataMap(ConcurrentHashMap<String, Object> dataMap) {
		// 已定义的设备数据点，有布尔、数值和枚举型数据

		if (dataMap.get("data") != null) {
			ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) dataMap.get("data");
			for (String dataKey : map.keySet()) {
				if (dataKey.equals(KEY_JK_1_FENGJIYIQIDONG)) {
					data_JK_1_fengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_ZHIBANSTATUS)) {
					data_JK_1_zhiBanStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_DIANJIARE1)) {
					data_JK_1_dianJiaRe1 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_DIANJIARE2)) {
					data_JK_1_dianJiaRe2 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_DIANJIARE3)) {
					data_JK_1_dianJiaRe3 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_FENGJISTATUS)) {
					data_JK_1_fengJiStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_SHOUZIDONG)) {
					data_JK_1_shouZiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_DONGXIAJI)) {
					data_JK_1_dongXiaJi = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_ZHONGXIAOBAOJING)) {
					data_JK_1_zhongXiaoBaoJing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_DIANJIAREGAOWEN)) {
					data_JK_1_dianJiaReGaoWen = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_FENGJIQUEFENG)) {
					data_JK_1_fengJiQueFeng = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_PAIFENGJIYIQIDONG)) {
					data_JK_1_paiFengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_DIWENPANGUAN)) {
					data_JK_1_diWenPanGuan = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_MIEJUNYUNXING)) {
					data_JK_1_mieJunYunXing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_FENGJIYIQIDONG)) {
					data_JK_2_fengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_ZHIBANSTATUS)) {
					data_JK_2_zhiBanStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_DIANJIARE1)) {
					data_JK_2_dianJiaRe1 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_DIANJIARE2)) {
					data_JK_2_dianJiaRe2 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_DIANJIARE3)) {
					data_JK_2_dianJiaRe3 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_FENGJISTATUS)) {
					data_JK_2_fengJiStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_SHOUZIDONG)) {
					data_JK_2_shouZiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_DONGXIAJI)) {
					data_JK_2_dongXiaJi = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_ZHONGXIAOBAOJING)) {
					data_JK_2_zhongXiaoBaoJing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_DIANJIAREGAOWEN)) {
					data_JK_2_dianJiaReGaoWen = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_FENGJIQUEFENG)) {
					data_JK_2_fengJiQueFeng = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_PAIFENGJIYIQIDONG)) {
					data_JK_2_paiFengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_DIWENPANGUAN)) {
					data_JK_2_diWenPanGuan = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_2_MIEJUNYUNXING)) {
					data_JK_2_mieJunYunXing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_FENGJIYIQIDONG)) {
					data_JK_3_fengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_ZHIBANSTATUS)) {
					data_JK_3_zhiBanStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_DIANJIARE1)) {
					data_JK_3_dianJiaRe1 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_DIANJIARE2)) {
					data_JK_3_dianJiaRe2 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_DIANJIARE3)) {
					data_JK_3_dianJiaRe3 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_FENGJISTATUS)) {
					data_JK_3_fengJiStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_SHOUZIDONG)) {
					data_JK_3_shouZiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_DONGXIAJI)) {
					data_JK_3_dongXiaJi = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_ZHONGXIAOBAOJING)) {
					data_JK_3_zhongXiaoBaoJing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_DIANJIAREGAOWEN)) {
					data_JK_3_dianJiaReGaoWen = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_FENGJIQUEFENG)) {
					data_JK_3_fengJiQueFeng = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_PAIFENGJIYIQIDONG)) {
					data_JK_3_paiFengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_DIWENPANGUAN)) {
					data_JK_3_diWenPanGuan = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_3_MIEJUNYUNXING)) {
					data_JK_3_mieJunYunXing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_FENGJIYIQIDONG)) {
					data_JK_XF_fengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_ZHIBANSTATUS)) {
					data_JK_XF_zhiBanStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_DIANJIARE1)) {
					data_JK_XF_dianJiaRe1 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_DIANJIARE2)) {
					data_JK_XF_dianJiaRe2 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_DIANJIARE3)) {
					data_JK_XF_dianJiaRe3 = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_FENGJISTATUS)) {
					data_JK_XF_fengJiStatus = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_SHOUZIDONG)) {
					data_JK_XF_shouZiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_DONGXIAJI)) {
					data_JK_XF_dongXiaJi = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_ZHONGXIAOBAOJING)) {
					data_JK_XF_zhongXiaoBaoJing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_DIANJIAREGAOWEN)) {
					data_JK_XF_dianJiaReGaoWen = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_FENGJIQUEFENG)) {
					data_JK_XF_fengJiQueFeng = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_PAIFENGJIYIQIDONG)) {
					data_JK_XF_paiFengJiYiQiDong = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_DIWENPANGUAN)) {
					data_JK_XF_diWenPanGuan = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_XF_MIEJUNYUNXING)) {
					data_JK_XF_mieJunYunXing = (Boolean) map.get(dataKey);			
				}
				if (dataKey.equals(KEY_JK_1_MIANBANTONGXUNZHUANGTAI1)) {
			
					data_JK_1_mianBanTongXunZhuangTai1 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_MIANBANTONGXUNZHUANGTAI2)) {
			
					data_JK_1_mianBanTongXunZhuangTai2 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_MIANBANTONGXUNZHUANGTAI3)) {
			
					data_JK_1_mianBanTongXunZhuangTai3 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_MIANBANTONGXUNZHUANGTAI1)) {
			
					data_JK_2_mianBanTongXunZhuangTai1 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_MIANBANTONGXUNZHUANGTAI2)) {
			
					data_JK_2_mianBanTongXunZhuangTai2 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_MIANBANTONGXUNZHUANGTAI3)) {
			
					data_JK_2_mianBanTongXunZhuangTai3 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_MIANBANTONGXUNZHUANGTAI1)) {
			
					data_JK_3_mianBanTongXunZhuangTai1 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_MIANBANTONGXUNZHUANGTAI2)) {
			
					data_JK_3_mianBanTongXunZhuangTai2 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_MIANBANTONGXUNZHUANGTAI3)) {
			
					data_JK_3_mianBanTongXunZhuangTai3 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_MIANBANTONGXUNZHUANGTAI1)) {
			
					data_JK_XF_mianBanTongXunZhuangTai1 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_MIANBANTONGXUNZHUANGTAI2)) {
			
					data_JK_XF_mianBanTongXunZhuangTai2 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_MIANBANTONGXUNZHUANGTAI3)) {
			
					data_JK_XF_mianBanTongXunZhuangTai3 = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_TEMPREAL)) {
			
					data_JK_1_tempReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_HUMIREAL)) {
			
					data_JK_1_humiReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_TEMPSET)) {
			
					data_JK_1_tempSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_HUMISET)) {
			
					data_JK_1_humiSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_LENGSHUIFAKAIDU)) {
			
					data_JK_1_lengShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_RESHUIFAKAIDU)) {
			
					data_JK_1_reShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_XINFENGWENDU)) {
			
					data_JK_1_xinFengWenDU = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_JIASHIQIKAIDU)) {
			
					data_JK_1_jiaShiQIKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_1_BEIYONG)) {
			
					data_JK_1_beiYong = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_TEMPREAL)) {
			
					data_JK_2_tempReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_HUMIREAL)) {
			
					data_JK_2_humiReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_TEMPSET)) {
			
					data_JK_2_tempSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_HUMISET)) {
			
					data_JK_2_humiSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_LENGSHUIFAKAIDU)) {
			
					data_JK_2_lengShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_RESHUIFAKAIDU)) {
			
					data_JK_2_reShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_XINFENGWENDU)) {
			
					data_JK_2_xinFengWenDU = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_JIASHIQIKAIDU)) {
			
					data_JK_2_jiaShiQIKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_2_BEIYONG)) {
			
					data_JK_2_beiYong = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_TEMPREAL)) {
			
					data_JK_3_tempReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_HUMIREAL)) {
			
					data_JK_3_humiReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_TEMPSET)) {
			
					data_JK_3_tempSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_HUMISET)) {
			
					data_JK_3_humiSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_LENGSHUIFAKAIDU)) {
			
					data_JK_3_lengShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_RESHUIFAKAIDU)) {
			
					data_JK_3_reShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_XINFENGWENDU)) {
			
					data_JK_3_xinFengWenDU = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_JIASHIQIKAIDU)) {
			
					data_JK_3_jiaShiQIKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_3_BEIYONG)) {
			
					data_JK_3_beiYong = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_TEMPREAL)) {
			
					data_JK_XF_tempReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_HUMIREAL)) {
			
					data_JK_XF_humiReal = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_TEMPSET)) {
			
					data_JK_XF_tempSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_HUMISET)) {
			
					data_JK_XF_humiSet = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_LENGSHUIFAKAIDU)) {
			
					data_JK_XF_lengShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_RESHUIFAKAIDU)) {
			
					data_JK_XF_reShuiFaKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_XINFENGWENDU)) {
			
					data_JK_XF_xinFengWenDU = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_JIASHIQIKAIDU)) {
			
					data_JK_XF_jiaShiQIKaiDu = (Integer) map.get(dataKey);
				}
				if (dataKey.equals(KEY_JK_XF_BEIYONG)) {
			
					data_JK_XF_beiYong = (Integer) map.get(dataKey);
				}
			}
		}

		StringBuilder sBuilder = new StringBuilder();

		// 已定义的设备报警数据点，设备发生报警后该字段有内容，没有发生报警则没内容
		if (dataMap.get("alerts") != null) {
			ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) dataMap.get("alerts");
			for (String alertsKey : map.keySet()) {
				if ((Boolean) map.get(alertsKey)) {
					sBuilder.append("报警:" + alertsKey + "=true" + "\n");
				}
			}
		}

		// 已定义的设备故障数据点，设备发生故障后该字段有内容，没有发生故障则没内容
		if (dataMap.get("faults") != null) {
			ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) dataMap.get("faults");
			for (String faultsKey : map.keySet()) {
				if ((Boolean) map.get(faultsKey)) {
					sBuilder.append("故障:" + faultsKey + "=true" + "\n");
				}
			}
		}

		if (sBuilder.length() > 0) {
			sBuilder.insert(0, "[设备故障或报警]\n");
			myToast(sBuilder.toString().trim());
		}

		// 透传数据，无数据点定义，适合开发者自行定义协议自行解析
		if (dataMap.get("binary") != null) {
			byte[] binary = (byte[]) dataMap.get("binary");
			Log.i("", "Binary data:" + HexStrUtils.bytesToHexString(binary));
		}
	}

	GizWifiDeviceListener gizWifiDeviceListener = new GizWifiDeviceListener() {

		/** 用于设备订阅 */
		public void didSetSubscribe(GizWifiErrorCode result, GizWifiDevice device, boolean isSubscribed) {
			GosControlModuleBaseActivity.this.didSetSubscribe(result, device, isSubscribed);
		};

		/** 用于获取设备状态 */
		public void didReceiveData(GizWifiErrorCode result, GizWifiDevice device,
				java.util.concurrent.ConcurrentHashMap<String, Object> dataMap, int sn) {
			GosControlModuleBaseActivity.this.didReceiveData(result, device, dataMap, sn);
		};

		/** 用于设备硬件信息 */
		public void didGetHardwareInfo(GizWifiErrorCode result, GizWifiDevice device,
				java.util.concurrent.ConcurrentHashMap<String, String> hardwareInfo) {
			GosControlModuleBaseActivity.this.didGetHardwareInfo(result, device, hardwareInfo);
		};

		/** 用于修改设备信息 */
		public void didSetCustomInfo(GizWifiErrorCode result, GizWifiDevice device) {
			GosControlModuleBaseActivity.this.didSetCustomInfo(result, device);
		};

		/** 用于设备状态变化 */
		public void didUpdateNetStatus(GizWifiDevice device, GizWifiDeviceNetStatus netStatus) {
			GosControlModuleBaseActivity.this.didUpdateNetStatus(device, netStatus);
		};

	};

	/**
	 * 设备订阅回调
	 * 
	 * @param result
	 *            错误码
	 * @param device
	 *            被订阅设备
	 * @param isSubscribed
	 *            订阅状态
	 */
	protected void didSetSubscribe(GizWifiErrorCode result, GizWifiDevice device, boolean isSubscribed) {
	}

	/**
	 * 设备状态回调
	 * 
	 * @param result
	 *            错误码
	 * @param device
	 *            当前设备
	 * @param dataMap
	 *            当前设备状态
	 * @param sn
	 *            命令序号
	 */
	protected void didReceiveData(GizWifiErrorCode result, GizWifiDevice device,
			java.util.concurrent.ConcurrentHashMap<String, Object> dataMap, int sn) {
	}

	/**
	 * 设备硬件信息回调
	 * 
	 * @param result
	 *            错误码
	 * @param device
	 *            当前设备
	 * @param hardwareInfo
	 *            当前设备硬件信息
	 */
	protected void didGetHardwareInfo(GizWifiErrorCode result, GizWifiDevice device,
			java.util.concurrent.ConcurrentHashMap<String, String> hardwareInfo) {
	}

	/**
	 * 修改设备信息回调
	 * 
	 * @param result
	 *            错误码
	 * @param device
	 *            当前设备
	 */
	protected void didSetCustomInfo(GizWifiErrorCode result, GizWifiDevice device) {
	}

	/**
	 * 设备状态变化回调
	 */
	protected void didUpdateNetStatus(GizWifiDevice device, GizWifiDeviceNetStatus netStatus) {
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void myToast(String string) {
		if (mToast != null) {
			mToast.setText(string);
		} else {
			mToast = Toast.makeText(getApplicationContext(), string, Toast.LENGTH_LONG);
		}
		mToast.show();
	}

	protected void hideKeyBoard() {
		// 隐藏键盘
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null) {
			imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
		}
	}
	
	
	/**
	 *Description:显示格式化数值，保留对应分辨率的小数个数，比如传入参数（20.3656，0.01），将返回20.37
	 *@param date 传入的数值
	 *@param radio 保留多少位小数
	 *@return
	 */
	protected String formatValue(double date, Object scale) {
		if (scale instanceof Double) {
			DecimalFormat df = new DecimalFormat(scale.toString());
			return df.format(date);
		}
		return Math.round(date) + "";
	}

}