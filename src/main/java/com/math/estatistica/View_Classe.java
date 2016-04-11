package com.math.estatistica;
import android.view.*;
import android.app.*;
import android.widget.*;

public class View_Classe extends View
{
	LinearLayout llRoot; 
	public TextView textViewLI;
	public TextView textViewLs;
	public EditText editTextLi;
	public EditText editTextLs;
	
	public View_Classe(Activity context,LinearLayout ll){
		super(context);
		LayoutInflater inflater = context.getLayoutInflater();
		View view = inflater.inflate(R.layout.cell_classe,null);
		llRoot = ll;
		ll.addView(view);
		
		editTextLi = (EditText)(((LinearLayout)llRoot.getChildAt(ll.getChildCount()-1))).findViewById(R.id.editTextClasseLi);
		editTextLs = (EditText)(((LinearLayout)llRoot.getChildAt(ll.getChildCount()-1))).findViewById(R.id.editTextClasseLs);
		textViewLI = (TextView) (((LinearLayout)llRoot.getChildAt(ll.getChildCount()-1))).findViewById(R.id.textViewClasseLi);
	    textViewLs = (TextView) (((LinearLayout)llRoot.getChildAt(ll.getChildCount()-1))).findViewById(R.id.textViewClasseLs);
		
		textViewLI.setOnClickListener(new OnClickListener(){
					public void onClick(View p1)
						{
							textViewLI.setVisibility(View.GONE);
							editTextLi.setVisibility(View.VISIBLE);
							editTextLi.setText(textViewLI.getText());
							editTextLi.requestFocus();
							editTextLi.setSelection(editTextLi.length());
							} });
	
		editTextLi.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					textViewLI.setText(editTextLi.getText());
					textViewLI.setVisibility(View.VISIBLE);
					editTextLi.setVisibility(View.GONE);
					editTextLi.setSelection(editTextLi.length());
					}});
		editTextLi.setOnFocusChangeListener(new OnFocusChangeListener(){

				@Override
				public void onFocusChange(View p1, boolean p2)
				{
					if(p2){
						editTextLi.setSelection(editTextLi.length());
					}
					if(!p2){
						textViewLI.setText(editTextLi.getText());
						textViewLI.setVisibility(View.VISIBLE);
						editTextLi.setVisibility(View.GONE);
					}}});

		textViewLs.setOnClickListener(new OnClickListener(){
				public void onClick(View p1)
				{
					textViewLs.setVisibility(View.GONE);
					editTextLs.setVisibility(View.VISIBLE);
					editTextLs.setText(textViewLs.getText());
					editTextLs.requestFocus();
					editTextLs.setSelection(editTextLs.length());
				} });

		editTextLs.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					textViewLs.setText(editTextLs.getText());
					textViewLs.setVisibility(View.VISIBLE);
					editTextLs.setVisibility(View.GONE);
				    editTextLs.setSelection(editTextLs.length());
					}});
		editTextLs.setOnFocusChangeListener(new OnFocusChangeListener(){

				@Override
				public void onFocusChange(View p1, boolean p2)
				{
					if(p2){
						editTextLs.setSelection(editTextLs.length());
					}
					if(!p2){
						textViewLs.setText(editTextLs.getText());
						textViewLs.setVisibility(View.VISIBLE);
						editTextLs.setVisibility(View.GONE);
					}}});
					
					}
  
	public void remover(int position){
		llRoot.removeViewAt(position+1);
	}
}