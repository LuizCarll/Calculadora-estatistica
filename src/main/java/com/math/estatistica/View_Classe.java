package com.math.estatistica;
import android.view.*;
import android.app.*;
import android.widget.*;
import java.util.*;

public class View_Classe extends View
{
	LinearLayout llRoot;
	LinearLayout llPmi;
	public Activity activity;
	public TextView textViewLI;
	public TextView textViewLs;
	public EditText editTextLi;
	public EditText editTextLs;
	View_Pmi viem_pmi;
	public View_Classe(Activity context,LinearLayout ll){
		super(context);
		activity = context;
		LayoutInflater inflater = context.getLayoutInflater();
		View view = inflater.inflate(R.layout.cell_classe,null);
		llRoot = ll;
		ll.addView(view);
		llPmi = (LinearLayout) context.findViewById(R.id.linearLayoutPmi);
		viem_pmi  = new View_Pmi(context,llPmi);
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
						calc_pmi();
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
						calc_pmi();
					}}});
					
					}
  
	public void remover(int position){
		llRoot.removeViewAt(position+1);
		llPmi.removeViewAt(position+1);
	}
	
	private void calc_pmi(){
		try{
			int  li =Integer.parseInt(textViewLI.getText().toString());
		    int  ls =Integer.parseInt(textViewLs.getText().toString());
			int res = (li+ls)/2;
			viem_pmi.Writer_Cell(res);
			}catch(Exception e){
			
		}
	}
}