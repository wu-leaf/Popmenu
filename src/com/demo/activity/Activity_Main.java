package com.demo.activity;

import java.util.ArrayList;

import com.demo.R;
import com.demo.adapter.GridViewAdapter;
import com.demo.pop.DefaultPop;
import com.demo.pop.GridPop;
import com.demo.pop.MenuPop;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

/**
 * 
 * @author yaguang.wang
 *
 */
public class Activity_Main extends Activity {
	private Button btn1,btn2;
	private MenuPop popMenu;
	private DefaultPop defaultPop;
	private GridPop gridpop;
	private ArrayList<String> stringArray;
	private GridView gv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main);
		initView();
		super.onCreate(savedInstanceState);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("xx");//触发onMenuOpened
		return super.onCreateOptionsMenu(menu);
	}
	
	/**
	 * popMenu
	 */
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		if (popMenu!=null) {
			if (popMenu.isShowing()) {
				popMenu.dismiss();
			}
			else {
				View v=this.getLayoutInflater().inflate(R.layout.pop_menu, null);
				popMenu.showAtLocation(v, Gravity.BOTTOM, 0, 0);
			}
		}
		//为false时，才能屏蔽menu add的xx
		return false;
	}
	
	private void initView(){
		//弹出pop1 比较丑见谅
		btn1 = (Button) this.findViewById(R.id.main_btn1);
		//弹出pop2 比较丑见谅
		btn2 = (Button) this.findViewById(R.id.main_btn2);
		btn1.setOnClickListener(new ClickListener());
		btn2.setOnClickListener(new ClickListener());
		
		popMenu = new MenuPop(R.layout.pop_menu, Activity_Main.this);
		
		//list传值 
		stringArray = new ArrayList<String>();
		for (int i = 1; i <= 20; i++) {
			stringArray.add("item"+i);
		}
		
		defaultPop = new DefaultPop(Activity_Main.this, R.layout.default_popwin);
		
		gridpop = new GridPop(Activity_Main.this, R.layout.pop_list);
		
		gv = gridpop.getAllItemGrid();
		gv.setAdapter(new GridViewAdapter(Activity_Main.this, stringArray));
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					//TODO DO SOMETHING
					Toast.makeText(getApplicationContext(), "item on clicked"+position, Toast.LENGTH_SHORT).show();
					if (gridpop.isShowing()) {
						gridpop.dismiss();
					}
			}
		});
	}
	
	private class ClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			/**
			 * pop1 简单控件
			 */
			case R.id.main_btn1:
				if (defaultPop!=null) {
					if (defaultPop.isShowing()) {
						defaultPop.dismiss();
					} else {
						defaultPop.showAsDropDown(v);
					}
				}
				break;
			
			/**
			 * pop2 复杂控件
			 */
			case R.id.main_btn2:
				if (gridpop!=null) {
					if (gridpop.isShowing()) {
						gridpop.dismiss();
					} else {
						gridpop.showAsDropDown(v);
					}
				}
				break;

			}
		}
		
	}
}
