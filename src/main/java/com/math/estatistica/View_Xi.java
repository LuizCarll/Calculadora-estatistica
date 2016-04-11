
package com.math.estatistica;

import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.view.*;
import android.content.Context;
import android.widget.*;
import android.app.Activity;
import android.text.*;
import java.util.*;

public class View_Xi extends View
{

	

	private EditText editXi;
    public LinearLayout llRoot;
	public TextView tvXI;
	private TextView somatorio;
	public static int Somatorio = 0;
	private List<View_Xi> lista;

	public View_Xi(Activity context, LinearLayout ll,List list){
		super(context);
		lista = list;
		LayoutInflater inflater = context.getLayoutInflater();
		llRoot = ll;
		View view = inflater.inflate(R.layout.view_xi,null);
if(llRoot.getId() != R.id.linearLayoutXi){
	
llRoot.addView(view,llRoot.getChildCount()-1);
    somatorio = (TextView) llRoot.findViewById(R.id.textviewSomatorioFi);
	editXi = (EditText)(((LinearLayout)llRoot.getChildAt(ll.getChildCount()-2))).findViewById(R.id.etXi);
	tvXI = (TextView) (((LinearLayout)llRoot.getChildAt(ll.getChildCount()-2))).findViewById(R.id.tvXI);
}
	else{
		llRoot.addView(view);
		editXi = (EditText)(((LinearLayout)llRoot.getChildAt(ll.getChildCount()-1))).findViewById(R.id.etXi);
		tvXI = (TextView) (((LinearLayout)llRoot.getChildAt(ll.getChildCount()-1))).findViewById(R.id.tvXI);
		}
		tvXI.setOnClickListener(new OnClickListener(){
        
				
				public void onClick(View p1)
				{
					tvXI.setVisibility(View.GONE);
						editXi.setVisibility(View.VISIBLE);
					editXi.setText(tvXI.getText());
					
					
					editXi.requestFocus();
					editXi.setSelection(editXi.length());
					
				}


			});
		editXi.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					tvXI.setText(editXi.getText());
					tvXI.setVisibility(View.VISIBLE);
					editXi.setVisibility(View.GONE);
					editXi.setSelection(editXi.length());
					
				}
			});
		editXi.setOnFocusChangeListener(new OnFocusChangeListener(){

				@Override
				public void onFocusChange(View p1, boolean p2)
				{
					if(p2){
						
						editXi.setSelection(editXi.length());
					}
					if(!p2){
						tvXI.setText(editXi.getText());
						tvXI.setVisibility(View.VISIBLE);
						editXi.setVisibility(View.GONE);
					    if(llRoot.getId() != R.id.tvXI) Somatorio();
					}
				}


			});
			
		}
	public void Somatorio(){
		try{
		Somatorio = 0;
		for(int x = 0; x < lista.size();x++)
		Somatorio += Integer.parseInt(lista.get(x).tvXI.getText().toString());
		somatorio.setText(Somatorio+"");
		}catch(Exception e){
			
		}
	}
	public void remover(int position){
		llRoot.removeViewAt(position+1);
	}
		
}