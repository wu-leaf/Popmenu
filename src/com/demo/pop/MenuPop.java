package com.demo.pop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.demo.R;

/**
 * 
 * @author yaguang.wang
 *
 */
public class MenuPop extends PopupWindow {

	private int resId;
	private Context mContext;
	private View popView;
	private LayoutInflater inflater;
	public MenuPop(int resId,Context context) {
		super(context);
		this.resId = resId;
		mContext = context;
		inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		init();
	}
	
	@SuppressWarnings("deprecation")
	public void init(){
		
		popView = inflater.inflate(this.resId, null);
		popView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setContentView(popView);
		setWidth(LayoutParams.FILL_PARENT);
		setHeight(LayoutParams.WRAP_CONTENT);
		setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		setFocusable(true);
		
		Button btn1 = (Button) popView.findViewById(R.id.menu_btn1);
		Button btn2 = (Button) popView.findViewById(R.id.menu_btn2);
		Button btn3 = (Button) popView.findViewById(R.id.menu_btn3);
		Button btn4 = (Button) popView.findViewById(R.id.menu_btn4);
		
		btn1.setOnClickListener(new ButtonListener());
		btn2.setOnClickListener(new ButtonListener());
		btn3.setOnClickListener(new ButtonListener());
		btn4.setOnClickListener(new ButtonListener());
		
		popView.setFocusableInTouchMode(true);
		
		popView.setOnKeyListener(new View.OnKeyListener() {
				
				@Override
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					
					if(keyCode == KeyEvent.KEYCODE_MENU && isShowing()){
						dismiss();
						return true;
					}
					return false;
				}
			});
	}
	private class ButtonListener implements View.OnClickListener{
		
		@Override
		public void onClick(View v) {
			Toast.makeText(mContext, "view id is"+v.getId(), Toast.LENGTH_SHORT).show();
			if (isShowing()) {
				dismiss();
			}
		}
	}
}
