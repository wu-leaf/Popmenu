package com.demo.pop;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.demo.R;

/**
 * 
 * @author yaguang.wang
 * 
 */
public class DefaultPop extends PopupWindow {
	private int resId;
	private Context context;
	private LayoutInflater inflater;
	public View defaultView;
	
	
	public DefaultPop(Context context,int resId) {
		super(context);
		this.context=context;
		this.resId=resId;
		initPopupWindow();
	}
	public void initPopupWindow() {
		inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		defaultView=inflater.inflate(this.resId, null);
		defaultView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setContentView(defaultView);
		Button btn1=(Button) defaultView.findViewById(R.id.btn1);
		Button btn2=(Button) defaultView.findViewById(R.id.btn2);
		Button btn3=(Button) defaultView.findViewById(R.id.btn3);
		Button btn4=(Button) defaultView.findViewById(R.id.btn4);
		btn1.setOnClickListener(new btnClickListener());
		btn2.setOnClickListener(new btnClickListener());
		btn3.setOnClickListener(new btnClickListener());
		btn4.setOnClickListener(new btnClickListener());
		setWidth(LayoutParams.MATCH_PARENT);
		setHeight(LayoutParams.WRAP_CONTENT);
		setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
		setFocusable(true);
		setOutsideTouchable(true);
		
	}
	/**
	 * 
	 * @return pop的View
	 */
	public View getDefaultView() {
		return defaultView;
	}
	
	private class btnClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn1:
				//TODO 做其他有意义的事情
				Toast.makeText(context, "clicked btn1", Toast.LENGTH_SHORT).show();
				break;
			case R.id.btn2:
				Toast.makeText(context, "clicked btn2", Toast.LENGTH_SHORT).show();
				break;
			case R.id.btn3:
				Toast.makeText(context, "clicked btn3", Toast.LENGTH_SHORT).show();
				break;
			case R.id.btn4:
				Toast.makeText(context, "clicked btn4", Toast.LENGTH_SHORT).show();
				break;

			}
				
			if (isShowing()) {
				dismiss();
			}
		}
		
	}
}
