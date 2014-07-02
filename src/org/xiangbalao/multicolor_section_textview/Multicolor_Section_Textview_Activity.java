package org.xiangbalao.multicolor_section_textview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.security.auth.PrivateCredentialPermission;

import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

/**
 * 同一TextView分段显示不同颜色
 * 
 * @author longtaoge
 * 
 */
public class Multicolor_Section_Textview_Activity extends Activity {
	// Textview分段显示不同颜色的文符串
	private TextView multiColorTextView1;
	private TextView multiColorTextView2;
	private TextView multiColorTextView3;
	private String temphtml;
	public String m﻿Enchant;
	private String tag = "Multicolor_Section_Textview_Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	private void initView() {
		// 方式1
		multiColorTextView1 = (TextView) findViewById(R.id.org_xiangbalao_multicolor_section_textview_textview1);

		multiColorTextView1
				.setText(Html
						.fromHtml("<font color='#e03939'>Text Content1第一段内容</font><br/>Text Content2第二段内容<br/><font color='#e0eeee'>Text Content3第三段内容\n</font>"));

		// 方法式2
		multiColorTextView2 = (TextView) findViewById(R.id.org_xiangbalao_multicolor_section_textview_textview2);
		fill_Textview2();

		// 采用方式1处理特珠要求的 字符串
		multiColorTextView3 = (TextView) findViewById(R.id.org_xiangbalao_multicolor_section_textview_textview3);
		fill_Textview3();

	}

	private void fill_Textview2() {
		// 要分段显示的文字
		String str = "同一TextView中显示不同颜色的文字\n";
		// 分段设置字体的颜色
		SpannableStringBuilder style = new SpannableStringBuilder(str);
		style.setSpan(new ForegroundColorSpan(Color.RED), 0, 20,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		// 这里可以追加文字
		style.append("追加的绿色文字\n");
		style.setSpan(new ForegroundColorSpan(Color.GREEN), 20, 28,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		// 再次追加
		style.append("再次追加的草蓝色文字");
		style.setSpan(new ForegroundColorSpan(Color.BLUE), 29, 39,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		multiColorTextView2.setText(style);
	}

	private void fill_Textview3() {

		temphtml = "";

		String leftHtml = "<font color='#ffffff'>&&&&</font>";
		String rightHtml = "<font color='#e03939'>(&&&&</font><br/>";
		String[] mList;

		m﻿Enchant = "力量+10(+25)、敏捷+10(+25)、智力+10(+25)";
		mList = m﻿Enchant.split("、");

		for (int i = 0; i < mList.length; i++) {
			String tempall = mList[i].trim();

			String[] tempArray = tempall.split("\\(");

			String templef = tempArray[0];

			String tempRight = tempArray[1];
			temphtml = temphtml + leftHtml.replace("&&&&", templef);
			temphtml = temphtml + rightHtml.replace("&&&&", tempRight);

		}

		multiColorTextView3.setText(Html.fromHtml(temphtml.trim()));
	}

}
