package com.math.estatistica;

import android.view.*;
import android.app.*;
import android.widget.*;

public class view_checkbox_select extends View
{
	public TextView numeracao;
	public CheckBox checkbox_selected;
	private static int count = 0;
	public LinearLayout llRoot;
	public view_checkbox_select(Activity context,LinearLayout ll){
		super(context);
		LayoutInflater inflater = context.getLayoutInflater();
		View view = inflater.inflate(R.layout.view_checkbox_select,null);
		llRoot = ll;
		ll.addView(view,ll.getChildCount()-1);
		
		numeracao = (TextView) (((LinearLayout)ll.getChildAt(ll.getChildCount()-2))).findViewById(R.id.textViewtSelect);
		checkbox_selected = (CheckBox) (((LinearLayout)ll.getChildAt(ll.getChildCount()-2))).findViewById(R.id.CheckBoxSelect);
	    count++;
		numeracao.setText(count+"");
		}
		
	public void remover(int position){
		llRoot.removeViewAt(position+1);
	}
}