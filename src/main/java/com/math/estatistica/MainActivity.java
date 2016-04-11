package com.math.estatistica;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View;
import android.view.*;
import android.view.View.*;
import java.util.*;
import android.widget.CompoundButton.*;
import android.opengl.*;
import android.transition.*;
public class MainActivity extends Activity 
{
	private final String[] tipoConjuntosdeDados = {"Amostra","Populacao"};
	LinearLayout ll;
	LinearLayout ll2;
	LinearLayout ll3;
    LinearLayout llClasse;
	EditText editXi;
	TextView tvXI;
	EditText editQtdXi;
	RadioButton rdoXi;
	RadioButton rdoClasse;
	List<View_Xi> xi = new ArrayList<View_Xi>();
	List<View_Classe> classe = new ArrayList<View_Classe>();
	List<View_Xi> fi = new ArrayList<View_Xi>();
	List<view_checkbox_select> selectXi = new ArrayList<view_checkbox_select>();
    
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		initSpinner();
		
		ll  = (LinearLayout) findViewById(R.id.linearLayoutXi);
		ll2 = (LinearLayout) findViewById(R.id.linearLayoutFi);
		ll3 = (LinearLayout) findViewById(R.id.linearLayoutSelect);
		llClasse = (LinearLayout) findViewById(R.id.linearLayoutClasse);
		
		rdoXi = (RadioButton) findViewById(R.id.radioButtonXi);
		rdoClasse = (RadioButton) findViewById(R.id.radioButtonClasse);
		rdoXi.setOnCheckedChangeListener(new OnCheckedChangeListener(){

				@Override
				public void onCheckedChanged(CompoundButton p1, boolean p2)
				{
					if(p2){
					ll.setVisibility(View.VISIBLE);
					llClasse.setVisibility(View.GONE);
					}
				}
			});
		rdoClasse.setOnCheckedChangeListener(new OnCheckedChangeListener(){

				@Override
				public void onCheckedChanged(CompoundButton p1, boolean p2)
				{
					// TODO: Implement this method
					if(p2){ll.setVisibility(View.GONE);
					llClasse.setVisibility(View.VISIBLE);
					}
				}
			});
		xi.add(new View_Xi(this,ll,xi));
		fi.add(new View_Xi(this,ll2,fi));
		classe.add(new View_Classe(this,llClasse));
		selectXi.add(new view_checkbox_select(this,ll3));
		}
		private void initSpinner(){
			
			Spinner s = (Spinner) findViewById(R.id.SpinnerConjuntosDados);
		    ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoConjuntosdeDados);
			s.setAdapter(adapter);
			}
	public void ADD_Dado(View v){
		xi.add(new View_Xi(this,ll,xi));
		fi.add(new View_Xi(this,ll2,fi));
	    selectXi.add(new view_checkbox_select(this,ll3));
		classe.add(new View_Classe(this,llClasse));
		}
		
		 public void Remover_Dado(View v){
			 int x = 0;
			 while( x < selectXi.size())
			 {
				 if(selectXi.get(x).checkbox_selected.isChecked()){
					 selectXi.get(x).remover(x);
					 selectXi.remove(x);
					 xi.get(x).remover(x);
					 xi.remove(x);
					 fi.get(x).remover(x);
					 fi.remove(x);
					 classe.get(x).remover(x);
					 classe.remove(x);
				 }else 
				      x++;
			 }
		}
}