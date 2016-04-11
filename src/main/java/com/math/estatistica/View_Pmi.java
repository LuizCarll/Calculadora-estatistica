package com.math.estatistica;
import android.view.*;
import android.app.*;
import android.widget.*;

public class View_Pmi extends View
{
	LinearLayout llRoot;
	public TextView textViewCell;
	public View_Pmi(Activity context,LinearLayout ll){
		super(context);
		
		LayoutInflater inflater = context.getLayoutInflater();
		llRoot = ll;
		View view = inflater.inflate(R.layout.cell,null);
	    llRoot.addView(view);
		
		textViewCell = (TextView) (((LinearLayout)llRoot.getChildAt(ll.getChildCount()-1))).findViewById(R.id.textViewCell);
		}
		public void Writer_Cell(int number){
			textViewCell.setText(number+"");
		}
}