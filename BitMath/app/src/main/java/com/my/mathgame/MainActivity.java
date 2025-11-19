package com.my.mathgame;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private String backgroundColor = "";
	private String htmltext = "";
	private String htmltext2 = "";
	
	private LinearLayout linear1;
	private LinearLayout linear10;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear12;
	private LinearLayout linear11;
	private ImageView settings;
	private LinearLayout linear8;
	private ImageView scoreboard;
	private ImageView imageview2;
	private Button button1;
	private LinearLayout linear9;
	private AdView adview1;
	private TextView textview2;
	private ImageView imageview1;
	
	private SharedPreferences score;
	private Intent intent = new Intent();
	private SharedPreferences modusart;
	private SharedPreferences languages;
	private SharedPreferences mode;
	private SharedPreferences coins;
	private Intent selectorIntent = new Intent();
	private Intent emailIntent = new Intent();
	private SharedPreferences mainads;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear10 = findViewById(R.id.linear10);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear12 = findViewById(R.id.linear12);
		linear11 = findViewById(R.id.linear11);
		settings = findViewById(R.id.settings);
		linear8 = findViewById(R.id.linear8);
		scoreboard = findViewById(R.id.scoreboard);
		imageview2 = findViewById(R.id.imageview2);
		button1 = findViewById(R.id.button1);
		linear9 = findViewById(R.id.linear9);
		adview1 = findViewById(R.id.adview1);
		textview2 = findViewById(R.id.textview2);
		imageview1 = findViewById(R.id.imageview1);
		score = getSharedPreferences("best", Activity.MODE_PRIVATE);
		modusart = getSharedPreferences("modusart", Activity.MODE_PRIVATE);
		languages = getSharedPreferences("languages", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		coins = getSharedPreferences("coins", Activity.MODE_PRIVATE);
		mainads = getSharedPreferences("mainads", Activity.MODE_PRIVATE);
		
		settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog db3 = new AlertDialog.Builder(MainActivity.this).create();
								LayoutInflater inflater = getLayoutInflater();
				View convertView = (View) inflater.inflate(R.layout.settings, null);
				db3.setView(convertView);
				db3.requestWindowFeature(Window.FEATURE_NO_TITLE);  
				db3.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				LinearLayout linear1 = (LinearLayout) convertView.findViewById(R.id.linear1);
				
				LinearLayout linear2 = (LinearLayout) convertView.findViewById(R.id.linear2);
				
				LinearLayout linear3 = (LinearLayout) convertView.findViewById(R.id.linear3);
				
				LinearLayout linear4 = (LinearLayout) convertView.findViewById(R.id.linear4);
				
				LinearLayout linear5 = (LinearLayout) convertView.findViewById(R.id.linear5);
				
				LinearLayout linear6 = (LinearLayout) convertView.findViewById(R.id.linear6);
				
				LinearLayout linear7 = (LinearLayout) convertView.findViewById(R.id.linear7);
				
				TextView textview1 = (TextView) convertView.findViewById(R.id.textview1);
				
				TextView textview2 = (TextView) convertView.findViewById(R.id.textview2);
				
				TextView textview3 = (TextView) convertView.findViewById(R.id.textview3);
				
				TextView textview4 = (TextView) convertView.findViewById(R.id.textview4);
				
				TextView textview5 = (TextView) convertView.findViewById(R.id.textview5);
				
				TextView textview6 = (TextView) convertView.findViewById(R.id.textview6);
				
				TextView textview7 = (TextView) convertView.findViewById(R.id.textview7);
				
				TextView textview8 = (TextView) convertView.findViewById(R.id.textview8);
				
				TextView textview9 = (TextView) convertView.findViewById(R.id.textview9);
				
				ImageView imageview1 = (ImageView) convertView.findViewById(R.id.imageview1);
				
				ImageView imageview3 = (ImageView) convertView.findViewById(R.id.imageview3);
				
				ImageView imageview4 = (ImageView) convertView.findViewById(R.id.imageview4);
				
				ImageView imageview5 = (ImageView) convertView.findViewById(R.id.imageview5);
				
				textview7.setTextSize(TypedValue.COMPLEX_UNIT_SP,6);
				
				textview8.setTextSize(TypedValue.COMPLEX_UNIT_SP,6);
				
				textview9.setTextSize(TypedValue.COMPLEX_UNIT_SP,6);
				
				if (mode.getString("mode", "").equals("dark")) {
						textview1.setTextColor(0xFFFFFFFF);
						textview2.setTextColor(0xFFFFFFFF);
					
					textview3.setTextColor(0xFFFFFFFF);
					
					textview4.setTextColor(0xFFFFFFFF);
					
					textview5.setTextColor(0xFFFFFFFF);
					
					textview6.setTextColor(0xFFFFFFFF);
					
					textview7.setTextColor(0xFFFFFFFF);
					
					textview8.setTextColor(0xFFFFFFFF);
					
					textview9.setTextColor(0xFFFFFFFF);
					
					_Shape(60, 60, 60, 60, "#424242", 0, "#fbc02d", 0, linear1);
					
					_roundedAndRipple(linear4, "#212121", "#FFFFFF", 00);
					
					_roundedAndRipple(linear5, "#F5F5F5", "#000000", 00);
					
					imageview1.setImageResource(R.drawable.ic_clear_white);
					
				}
				if (mode.getString("mode", "").equals("light")) {
						textview1.setTextColor(0xFF000000);
						textview2.setTextColor(0xFF000000);
					
					textview3.setTextColor(0xFF000000);
					
					textview4.setTextColor(0xFF000000);
					
					textview5.setTextColor(0xFF000000);
					
					textview6.setTextColor(0xFF000000);
					
					textview7.setTextColor(0xFF000000);
					
					textview8.setTextColor(0xFF000000);
					
					textview9.setTextColor(0xFF000000);
					
					_Shape(60, 60, 60, 60, "#ffffff", 0, "#fbc02d", 0, linear1);
					
					_roundedAndRipple(linear4, "#212121", "#FFFFFF", 00);
					
					_roundedAndRipple(linear5, "#F5F5F5", "#000000", 00);
						
					imageview1.setImageResource(R.drawable.ic_close_black);
					
				}
				
				if (modusart.getString("Modus", "").equals("Normal")) {
						textview3.setBackgroundColor(0xFF212121); textview3.setTextColor(0xFFFFFFFF);
				}
				else {
						textview3.setBackgroundColor(Color.TRANSPARENT); if (mode.getString("mode", "").equals("dark")) {textview3.setTextColor(0xFFFFFFFF);}{textview3.setTextColor(0xFF000000);}
				}
				if (modusart.getString("Modus", "").equals("Hart")) {
						textview4.setBackgroundColor(0xFF212121); textview4.setTextColor(0xFFFFFFFF);
				}
				else {
						textview4.setBackgroundColor(Color.TRANSPARENT); if (mode.getString("mode", "").equals("dark")) {textview4.setTextColor(0xFFFFFFFF);}{textview4.setTextColor(0xFF000000);}
				}
				if (modusart.getString("Modus", "").equals("Extrem")) {
						textview5.setBackgroundColor(0xFF212121); textview6.setTextColor(0xFFFFFFFF);
				}
				else {
						textview5.setBackgroundColor(Color.TRANSPARENT); if (mode.getString("mode", "").equals("dark")) {textview5.setTextColor(0xFFFFFFFF);}{textview5.setTextColor(0xFF000000);}
				}
				
				db3.setCancelable(true);
				imageview1.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
												db3.dismiss();
									}
						});
				
				if (languages.getString("language", "").equals("english")) {
						textview1.setText("Language:"); textview2.setText("Theme:"); textview3.setText("Normal"); textview4.setText("Hard"); textview5.setText("Extreme"); textview6.setText("Difficulty:"); textview7.setText("Contact"); textview9.setText("Conditions");
				}
				if (languages.getString("language", "").equals("deutsch")) {
						textview1.setText("Sprache:"); textview2.setText("Thema:"); textview3.setText("Normal"); textview4.setText("Hart"); textview5.setText("Extrem"); textview6.setText("Schwierigkeit:"); textview7.setText("Kontakt"); textview9.setText("AGB");
				}
				if (languages.getString("language", "").equals("türkçe")) {
						textview1.setText("Dil:"); textview2.setText("Tema:"); textview3.setText("Normal"); textview4.setText("Zor"); textview5.setText("Aşırı zor"); textview6.setText("Zorluk:"); textview7.setText("İletişime geçin"); textview9.setText("Koşullar");
				}
				
				textview7.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						Intent selectorIntent = new Intent(Intent.ACTION_SENDTO); selectorIntent.setData(Uri.parse("mailto:infoerdikara@gmail.com")); final Intent emailIntent = new Intent(Intent.ACTION_SEND); emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"infoerdikara@gmail.com"}); emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bitmath"); emailIntent.setSelector( selectorIntent ); startActivity(emailIntent);
									}
						});
				
				textview8.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						_impressum();
									}
						});
				
				textview9.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						_agb();
									}
						});
				
				linear4.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						mode.edit().putString("mode", "dark").commit();
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent); finish();
									}
						});
				
				linear5.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						mode.edit().putString("mode", "light").commit();
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent); finish();
									}
						});
				
				imageview3.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						languages.edit().putString("language", "english").commit();
						_language(); db3.dismiss();
									}
						});
				
				imageview4.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						languages.edit().putString("language", "deutsch").commit();
						_language(); db3.dismiss();
									}
						});
				
				imageview5.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						languages.edit().putString("language", "türkçe").commit();
						_language(); db3.dismiss();
									}
						});
				
				textview3.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						modusart.edit().putString("Modus", "Normal").commit();db3.dismiss();
									}
						});
				
				textview4.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						modusart.edit().putString("Modus", "Hart").commit();db3.dismiss();
									}
						});
				
				textview5.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						modusart.edit().putString("Modus", "Extrem").commit();db3.dismiss();
									}
						});
				
				db3.show();
			}
		});
		
		scoreboard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog db = new AlertDialog.Builder(MainActivity.this).create();
								LayoutInflater inflater = getLayoutInflater();
				View convertView = (View) inflater.inflate(R.layout.customdialog, null);
				db.setView(convertView);
				db.requestWindowFeature(Window.FEATURE_NO_TITLE);  
				db.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				LinearLayout linear1 = (LinearLayout) convertView.findViewById(R.id.linear1);
				
				LinearLayout linear2 = (LinearLayout) convertView.findViewById(R.id.linear2);
				
				LinearLayout linear3 = (LinearLayout) convertView.findViewById(R.id.linear3);
				
				LinearLayout linear4 = (LinearLayout) convertView.findViewById(R.id.linear4);
				
				LinearLayout linear5 = (LinearLayout) convertView.findViewById(R.id.linear5);
				
				TextView textview1 = (TextView) convertView.findViewById(R.id.textview1);
				
				TextView textview2 = (TextView) convertView.findViewById(R.id.textview2);
				
				TextView textview3 = (TextView) convertView.findViewById(R.id.textview3);
				
				TextView textview4 = (TextView) convertView.findViewById(R.id.textview4);
				
				TextView textview5 = (TextView) convertView.findViewById(R.id.textview5);
				
				TextView textview6 = (TextView) convertView.findViewById(R.id.textview6);
				
				ImageView imageview1 = (ImageView) convertView.findViewById(R.id.imageview1);
				
				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_bold.ttf"), 1);
				
				textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_bold.ttf"), 1);
				
				if (languages.getString("language", "").equals("english")) {
						textview1.setText("Game"); textview2.setText("Highscore"); textview3.setText("Human calculator"); textview5.setText("Plates");
				}
				if (languages.getString("language", "").equals("deutsch")) {
						textview1.setText("Spiel"); textview2.setText("Rekort"); textview3.setText("Menschlicher Rechner"); textview5.setText("Platten");
				}
				if (languages.getString("language", "").equals("türkçe")) {
						textview1.setText("Oyun"); textview2.setText("Rekor"); textview3.setText("Hesap Makinesi"); textview5.setText("Tabaklar");
				}
				
				if (mode.getString("mode", "").equals("dark")) {
						textview1.setTextColor(0xFFFFFFFF);
						textview2.setTextColor(0xFFFFFFFF);
						textview3.setTextColor(0xFFFFFFFF);
						textview4.setTextColor(0xFFFFFFFF);
					
					textview5.setTextColor(0xFFFFFFFF);
					
					textview6.setTextColor(0xFFFFFFFF);
					
					_Shape(30, 30, 30, 30, "#424242", 0, "#fbc02d", 0, linear1);
						imageview1.setImageResource(R.drawable.ic_clear_white);
				}
				if (mode.getString("mode", "").equals("light")) {
						textview1.setTextColor(0xFF000000);
						textview2.setTextColor(0xFF000000);
						textview3.setTextColor(0xFF000000);
						textview4.setTextColor(0xFF000000);
					
					textview5.setTextColor(0xFF000000);
					
					textview6.setTextColor(0xFF000000);
					
					_Shape(30, 30, 30, 30, "#ffffff", 0, "#fbc02d", 0, linear1);
						imageview1.setImageResource(R.drawable.ic_close_black);
				}
				
				textview4.setText(score.getString("best", ""));
				
				textview6.setText(score.getString("best2", ""));
				
				db.setCancelable(true);
				imageview1.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
												db.dismiss();
									}
						});
				
				db.show();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog db2 = new AlertDialog.Builder(MainActivity.this).create();
								LayoutInflater inflater = getLayoutInflater();
				View convertView = (View) inflater.inflate(R.layout.newgame_screen, null);
				db2.setView(convertView);
				db2.requestWindowFeature(Window.FEATURE_NO_TITLE);  
				db2.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				LinearLayout linear1 = (LinearLayout) convertView.findViewById(R.id.linear1);
				
				LinearLayout linear2 = (LinearLayout) convertView.findViewById(R.id.linear2);
				
				LinearLayout linear3 = (LinearLayout) convertView.findViewById(R.id.linear3);
				
				LinearLayout linear4 = (LinearLayout) convertView.findViewById(R.id.linear4);
				
				LinearLayout linear5 = (LinearLayout) convertView.findViewById(R.id.linear5);
				
				LinearLayout linear6 = (LinearLayout) convertView.findViewById(R.id.linear6);
				
				LinearLayout linear7 = (LinearLayout) convertView.findViewById(R.id.linear7);
				
				LinearLayout linear8 = (LinearLayout) convertView.findViewById(R.id.linear8);
				
				TextView textview1 = (TextView) convertView.findViewById(R.id.textview1);
				
				TextView textview2 = (TextView) convertView.findViewById(R.id.textview2);
				
				TextView textview3 = (TextView) convertView.findViewById(R.id.textview3);
				
				TextView textview4 = (TextView) convertView.findViewById(R.id.textview4);
				
				TextView textview5 = (TextView) convertView.findViewById(R.id.textview5);
				
				TextView textview6 = (TextView) convertView.findViewById(R.id.textview6);
				
				TextView textview7 = (TextView) convertView.findViewById(R.id.textview7);
				
				TextView textview8 = (TextView) convertView.findViewById(R.id.textview8);
				
				ImageView imageview1 = (ImageView) convertView.findViewById(R.id.imageview1);
				
				if (languages.getString("language", "").equals("english")) {
					textview7.setText("Human calculator"); textview8.setText("Plates");
				}
				if (languages.getString("language", "").equals("deutsch")) {
					textview7.setText("Menschl. Rechner"); textview8.setText("Platten");
				}
				if (languages.getString("language", "").equals("türkçe")) {
					 textview7.setText("Hesap Makinesi"); textview8.setText("Tabaklar");
				}
				
				if (mode.getString("mode", "").equals("dark")) {
						textview1.setTextColor(0xFFFFFFFF);
						textview2.setTextColor(0xFFFFFFFF);
						textview3.setTextColor(0xFF000000);
						textview4.setTextColor(0xFF000000);
					
					textview5.setTextColor(0xFF000000);
					
					textview6.setTextColor(0xFF000000);
					
					textview7.setTextColor(0xFFFFFFFF);
					
					textview8.setTextColor(0xFFFFFFFF);
					
					textview3.setBackgroundColor(0xFFFFFFFF);
					
					textview4.setBackgroundColor(0xFFFFFFFF);
					
					textview5.setBackgroundColor(0xFFFFFFFF);
					
					textview6.setBackgroundColor(0xFFFFFFFF);
					
					_Shape(60, 60, 60, 60, "#424242", 0, "#fbc02d", 0, linear1);
					
					_roundedAndRipple(linear3, "#2E2E2E", "#FFFFFF", 60);
					
					_roundedAndRipple(linear4, "#2E2E2E", "#FFFFFF", 60);
					
					_roundedAndRipple(linear7, "#616161", "#616161", 60);
					
					_roundedAndRipple(linear8, "#616161", "#616161", 60);
						imageview1.setImageResource(R.drawable.ic_clear_white);
				}
				if (mode.getString("mode", "").equals("light")) {
						textview1.setTextColor(0xFF000000);
						textview2.setTextColor(0xFF000000);
						textview3.setTextColor(0xFFFFFFFF);
						textview4.setTextColor(0xFFFFFFFF);
					
					textview5.setTextColor(0xFFFFFFFF);
					
					textview6.setTextColor(0xFFFFFFFF);
					
					textview7.setTextColor(0xFF000000);
					
					textview8.setTextColor(0xFF000000);
					
					textview3.setBackgroundColor(0xFF000000);
					
					textview4.setBackgroundColor(0xFF000000);
					
					textview5.setBackgroundColor(0xFF000000);
					
					textview6.setBackgroundColor(0xFF000000);
					
					_Shape(60, 60, 60, 60, "#ffffff", 0, "#fbc02d", 0, linear1);
					
					_roundedAndRipple(linear3, "#F5F5F5", "#000000", 60);
					
					_roundedAndRipple(linear4, "#F5F5F5", "#000000", 60);
					
					_roundedAndRipple(linear7, "#FAFAFA", "#FAFAFA", 60);
					
					_roundedAndRipple(linear8, "#FAFAFA", "#FAFAFA", 60);
						imageview1.setImageResource(R.drawable.ic_close_black);
				}
				
				db2.setCancelable(true);
				imageview1.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
												db2.dismiss();
									}
						});
				
				linear3.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), SpielActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent); db2.dismiss();
									}
						});
				
				linear7.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), SpielActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent); db2.dismiss();
									}
						});
				
				linear4.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), Spiel2Activity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent); db2.dismiss();
									}
						});
				
				linear8.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
						intent.setAction(Intent.ACTION_VIEW);
						intent.setClass(getApplicationContext(), Spiel2Activity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent); db2.dismiss();
									}
						});
				
				db2.show();
			}
		});
	}
	
	private void initializeLogic() {
		_ads();
		_language();
		_theme();
		_score0();
		_coin();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_ads();
		_coin();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (adview1 != null) {
			adview1.destroy();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if (adview1 != null) {
			adview1.pause();
		}
	}
	public void _ads() {
		adview1.loadAd(new AdRequest.Builder().build());
		if (mainads.getString("mainads", "").equals("")) {
			mainads.edit().putString("mainads", "0").commit();
		}
		if (mainads.getString("mainads", "").equals("1")) {
			final AlertDialog db5 = new AlertDialog.Builder(MainActivity.this).create();
							LayoutInflater inflater = getLayoutInflater();
			View convertView = (View) inflater.inflate(R.layout.adsdialog, null);
			db5.setView(convertView);
			db5.requestWindowFeature(Window.FEATURE_NO_TITLE);  
			db5.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
			ImageView imageview1 = (ImageView) convertView.findViewById(R.id.imageview1);
			
			LinearLayout linear1 = (LinearLayout) convertView.findViewById(R.id.linear1);
			
			AdView adview1 = (AdView) convertView.findViewById(R.id.adview1);
			
			adview1.loadAd(new AdRequest.Builder().build());
			
			if (mode.getString("mode", "").equals("dark")) {
					imageview1.setImageResource(R.drawable.ic_clear_white);
				
				_Shape(30, 30, 30, 30, "#424242", 0, "#fbc02d", 0, linear1);
			}
			if (mode.getString("mode", "").equals("light")) {
					imageview1.setImageResource(R.drawable.ic_close_black);
				
				_Shape(30, 30, 30, 30, "#ffffff", 0, "#fbc02d", 0, linear1);
			}
			
			db5.setCancelable(true);
			imageview1.setOnClickListener(new View.OnClickListener() {
								@Override
								public void onClick(View _view) {
											db5.dismiss();
								}
					});
			
			db5.show();
			mainads.edit().putString("mainads", "0").commit();
		}
	}
	
	
	public void _language() {
		if (languages.getString("language", "").equals("")) {
			languages.edit().putString("language", "english").commit();
		}
		if (languages.getString("language", "").equals("english")) {
			button1.setText("New game");
			
		}
		if (languages.getString("language", "").equals("deutsch")) {
			button1.setText("Neues Spiel");
			
		}
		if (languages.getString("language", "").equals("türkçe")) {
			button1.setText("Yeni oyun");
			
		}
	}
	
	
	public void _Shape(final double _t1, final double _t2, final double _b1, final double _b2, final String _Background, final double _Stroke, final String _stroke, final double _Elevation, final View _view) {
		android.graphics.drawable.GradientDrawable gs = new android.graphics.drawable.GradientDrawable();
		
		gs.setColor(Color.parseColor(_Background));
		
		gs.setStroke((int)_Stroke, Color.parseColor(_stroke));
		
		gs.setCornerRadii(new float[]{(int)_t1,(int)_t1,(int)_t2,(int)_t2,(int)_b1,(int)_b1,(int)_b2,(int)_b2});
		
		_view.setBackground(gs);
		_view.setElevation((int)_Elevation);
	}
	
	
	public void _theme() {
		if (mode.getString("mode", "").equals("")) {
			mode.edit().putString("mode", "dark").commit();
		}
		if (mode.getString("mode", "").equals("dark")) {
			linear1.setBackgroundColor(0xFF212121);
			_roundedAndRipple(button1, "#424242", "#9E9E9E", 45);
			settings.setImageResource(R.drawable.ic_settings_white);
			imageview2.setImageResource(R.drawable.logo_png_white);
		}
		if (mode.getString("mode", "").equals("light")) {
			linear1.setBackgroundColor(0xFFFFFFFF);
			_roundedAndRipple(button1, "#000000", "#FFFFFF", 45);
			settings.setImageResource(R.drawable.ic_settings_black);
			imageview2.setImageResource(R.drawable.logo_png);
		}
	}
	
	
	public void _roundedAndRipple(final View _view, final String _backgroundColor, final String _rippleColor, final double _radius) {
		//Code from StackOverflow and adapted for Sketchware by @BOFA 
		//Please do not reupload. If you want to improve, feel free just give credit.
		
		//For colors include #
		
		if (_backgroundColor.equals("")) {
			//If you leave the background color empty, it will be set to this default color.
			backgroundColor = "#FFFFFF";
		}
		else {
			backgroundColor = _backgroundColor;
		}
		android.content.res.ColorStateList pressedStates = android.content.res.ColorStateList.valueOf(Color.parseColor(_rippleColor)); 
		//adapted for Sketchware by BOFA
		android.graphics.drawable.GradientDrawable contentDrawable = new android.graphics.drawable.GradientDrawable();
		contentDrawable.setColor(Color.parseColor(backgroundColor));
		if (!(_radius == 0)) {
			//If you leave radius empty, no radius will be added.
			contentDrawable.setCornerRadius((int)_radius);
		}
		android.graphics.drawable.RippleDrawable rippleDrawable = new android.graphics.drawable.RippleDrawable(pressedStates, contentDrawable, null);
		//
		_view.setBackground(rippleDrawable);
	}
	
	
	public void _score0() {
		if (score.getString("best", "").equals("")) {
			score.edit().putString("best", "0").commit();
		}
		if (score.getString("best2", "").equals("")) {
			score.edit().putString("best2", "0").commit();
		}
		if (modusart.getString("Modus", "").equals("")) {
			modusart.edit().putString("Modus", "Normal").commit();
		}
	}
	
	
	public void _coin() {
		if (coins.getString("coins", "").equals("")) {
			coins.edit().putString("coins", "0").commit();
		}
		textview2.setText(coins.getString("coins", ""));
	}
	
	
	public void _impressum() {
		if (languages.getString("language", "").equals("")) {
			languages.edit().putString("language", "english").commit();
		}
		if (languages.getString("language", "").equals("english")) {
			htmltext = "<h2>\n<br>\nImpressum – Legal Disclosure\n</br>\n</h2>\n<br>\nE. K.\n<br>\nGermany\n</br>\n\n<h2>\n<br>\nContact\n</br>\n</h2>";
		}
		if (languages.getString("language", "").equals("deutsch")) {
			htmltext = "<h2>\n<br>\nAngaben gem&auml;&szlig; &sect; 5 TMG\n</br>\n</h2>\n<br>\nE. K.\n<br>\nGermany\n</br>\n\n<h2>\n<br>\nKontakt\n</br>\n</h2>";
		}
		if (languages.getString("language", "").equals("türkçe")) {
			htmltext = "<h2>\n<br>\nKünye\n</br>\n</h2>\n<br>\nE. K.\n<br>\nGermany\n</br>\n\n<h2>\n<br>\nİletişime geçin\n</br>\n</h2>";
		}
		htmltext2 = "<a href=\"mailto:bitmath@gmail.com\">\nbitmath@gmail.com\n</a>";
		final AlertDialog db4 = new AlertDialog.Builder(MainActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
		View convertView = (View) inflater.inflate(R.layout.impressum, null);
		db4.setView(convertView);
		db4.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		db4.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		LinearLayout linear1 = (LinearLayout) convertView.findViewById(R.id.linear1);
		
		TextView textview2 = (TextView) convertView.findViewById(R.id.textview2);
		
		TextView textview3 = (TextView) convertView.findViewById(R.id.textview3);
		
		ImageView imageview1 = (ImageView) convertView.findViewById(R.id.imageview1);
		
		textview2.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
		
		textview3.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
		
		if (mode.getString("mode", "").equals("dark")) {
				textview2.setTextColor(0xFFFFFFFF);
			
			textview3.setTextColor(0xFFFFFFFF);
			
			_Shape(30, 30, 30, 30, "#424242", 0, "#fbc02d", 0, linear1);
				imageview1.setImageResource(R.drawable.ic_clear_white);
		}
		if (mode.getString("mode", "").equals("light")) {
				textview2.setTextColor(0xFF000000);
			
			textview3.setTextColor(0xFF000000);
			
			_Shape(30, 30, 30, 30, "#ffffff", 0, "#fbc02d", 0, linear1);
				imageview1.setImageResource(R.drawable.ic_close_black);
		}
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { textview2.setText(Html.fromHtml(htmltext, Html.FROM_HTML_MODE_COMPACT)); } else { textview2.setText(Html.fromHtml(htmltext)); }
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { textview3.setText(Html.fromHtml(htmltext2, Html.FROM_HTML_MODE_COMPACT)); } else { textview3.setText(Html.fromHtml(htmltext2)); }
		
		db4.setCancelable(true);
		imageview1.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
										db4.dismiss();
							}
				});
		
		textview3.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
				Intent selectorIntent = new Intent(Intent.ACTION_SENDTO); selectorIntent.setData(Uri.parse("mailto:bitmath@gmail.com")); final Intent emailIntent = new Intent(Intent.ACTION_SEND); emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bitmath@gmail.com"}); emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bitmath"); emailIntent.setSelector( selectorIntent ); startActivity(emailIntent);
							}
				});
		
		db4.show();
	}
	
	
	public void _agb() {
		if (languages.getString("language", "").equals("english")) {
			htmltext2 = "<h1>Terms of Service</h1>\n<p>&nbsp;</p>\n<p>Last updated: November 10, 2021</p>\n<p>&nbsp;</p>\n<p><strong>We know terms and conditions are boring and the majority try to avoid them</strong>, however, we ask you to read these general terms and conditions carefully before using our services.</p>\n<p>&nbsp;</p>\n<h2>Interpretation &amp; Definitions</h2>\n<p><strong>&nbsp;</strong></p>\n<p>The words whose first letter is capitalized have defined meanings under the following conditions. The following definitions have the same meaning regardless of whether they appear in the singular or plural.</p>\n<p>&nbsp;</p>\n<p>For the purposes of these terms and conditions:</p>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Terms and Conditions</strong> refer to these general terms and conditions</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Coin / Coins </strong>refer to the points earned in the application, which can then be redeemed.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Services</strong> refers to the BitMath application</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>country</strong> refers to Germany</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>You / you </strong>refers to the person accessing or using the Service, or a company or other legal entity on whose behalf that person is accessing or using the Services, if applicable</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Companies </strong>refers to BitMath, also \"The Company\", \"We\" or \"Our\"</li>\n</ul>\n<p>&nbsp;</p>\n<h2>Privacy policy</h2>\n<p><strong>&nbsp;</strong></p>\n<p>The protection of your data is very important to us. We do not save any of your data except for the e-mail address given during a \"payout\" and the amount of coins at the relevant moment. This data will be permanently deleted within one week (6 working days) after the withdrawal has been made and cannot be restored by anyone.</p>\n<p>&nbsp;</p>\n<h2>Payouts</h2>\n<p><strong>&nbsp;</strong></p>\n<p>Withdrawals of coins are only possible from an amount of 1,000 (one thousand). Withdrawals are made in random cryptocurrencies. The &ldquo;Coinbase&rdquo; platform (owner: Coinbase, Inc.) is used for withdrawals. For a smooth payout, you also need a deposit on the platform mentioned. Payouts are made within one week (6 working days) if possible. Losses caused by incorrectly entering the email address or by not owning a Coinbase depot cannot be technically canceled and thus cannot be reversed. If manipulation of the amount of coins is suspected, all payouts are stopped and checked for correctness. In the event of manipulation, legal channels are initiated. We strive to make withdrawals however, are not obliged to offer and / or pay out withdrawals. We reserve the right not to make withdrawals and not to transfer the respective number of cryptocurrencies to the email address mentioned.</p>\n<p><strong>&nbsp;</strong></p>\n<h2>copyright</h2>\n<p><strong>&nbsp;</strong></p>\n<p>&copy; Copyright 2021 - Copyright Notice</p>\n<p>&nbsp;</p>\n<p>All contents of the BitMath application, in particular the logo, texts and graphics, are protected by copyright. Unless expressly stated otherwise, the copyright lies with Erdi Karasungur. Please ask us if you would like to use the content of this website.</p>\n<p>&nbsp;</p>\n<p>Anyone who violates copyright law (e.g. unauthorized copying of graphics or texts) is liable to prosecution according to &sect;&sect; 106 ff UrhG, is also warned against costs and has to pay compensation (&sect; 97 UrhG).</p>\n<p><strong>&nbsp;</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p>Errors and omissions excepted.</p>";
		}
		if (languages.getString("language", "").equals("deutsch")) {
			htmltext2 = "<p><h1>Allgemeine Gesch&auml;ftsbedingungen</h1></p>\n<p>&nbsp;</p>\n<p>Zuletzt aktualisiert: November 10, 2021</p>\n<p>&nbsp;</p>\n<p><strong>Wir wissen das Allgemeine Gesch&auml;ftsbedingungen langweilig sind und der Gro&szlig;teil versucht diese zu meiden</strong>, jedoch bitten wir Sie diese Allgemeinen Gesch&auml;ftsbedingungen bevor Sie unsere Dienstleistungen nutzen sorgf&auml;ltig zu lesen.</p>\n<p>&nbsp;</p>\n<p><h2>Interpretation &amp; Definitionen</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>Die W&ouml;rter, deren Anfangsbuchstabe gro&szlig;geschrieben wird, haben unter den folgenden Bedingungen definierte Bedeutungen. Die folgenden Definitionen haben die gleiche Bedeutung, unabh&auml;ngig davon, ob sie im Singular oder Plural vorkommen.</p>\n<p>&nbsp;</p>\n<p>F&uuml;r die Zwecke dieser Allgemeinen Gesch&auml;ftsbedingungen:</p>\n<p>&nbsp;</p>\n<ul>\n<li><strong>AGB/AGB&rsquo;s</strong> beziehen sich auf diese Allgemeinen Gesch&auml;ftsbedingungen</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Coin/Coins </strong>beziehen sich auf die in der Applikation verdienten Punkte, welche im Anschluss eingel&ouml;st werden k&ouml;nnen.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Dienstleistungen</strong> bezieht sich auf die Applikation BitMath</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Land</strong> bezieht sich auf Deutschland</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Sie/Ihnen </strong>bezieht sich auf die Person, welche auf die Dienstleistung zugreift oder diese nutzt, oder ein Unternehmen oder eine andere juristische Person, in deren Namen diese Person auf die Dienstleistungen zugreift oder diese nutzt, falls zutreffend</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Unternehmen </strong>bezieht sich auf BitMath, auch ,,Das Unternehmen&ldquo;, ,,Wir&ldquo; oder ,,Unser&ldquo;</li>\n</ul>\n<p>&nbsp;</p>\n<p><h2>Datenschutz</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>Der Schutz Ihrer Daten stellt f&uuml;r uns eine sehr hohe Wichtigkeit dar. Wir speichern keine Daten von Ihnen au&szlig;er die bei einer ,,Auszahlung&ldquo; genannten E-Mail Adresse sowie die Menge der Coins in dem entsprechenden Moment. Diese Daten werden innerhalb von einer Woche (6 Werktagen), nachdem die Auszahlung durchgef&uuml;hrt wurde, endg&uuml;ltig gel&ouml;scht und k&ouml;nnen von keinem wiederhergestellt werden.</p>\n<p>&nbsp;</p>\n<p><h2>Auszahlungen</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>Auszahlungen von Coins sind erst ab einer Menge von 1.000 (eintausend) m&ouml;glich. Die Auszahlungen werden in zuf&auml;lligen Kryptow&auml;hrungen durchgef&uuml;hrt. F&uuml;r die Auszahlungen wird die Plattform ,,Coinbase&ldquo; (Eigent&uuml;mer: Coinbase, Inc.) verwendet. F&uuml;r eine reibungslose Auszahlung ben&ouml;tigen Sie ebenfalls ein Depot auf der genannten Plattform. Auszahlungen werden, wenn m&ouml;glich, innerhalb einer Woche (6 Werktagen) ausgezahlt. Verluste welche durch falsche Eingabe der Email-Adresse oder durch nicht besitzen eines Coinbase Depots entstanden sind, k&ouml;nnen technisch <strong>nicht</strong> Storniert und somit <strong>nicht</strong> r&uuml;ckg&auml;ngig gemacht werden. Beim verdacht von Manipulation der Coin-Menge werden alle Auszahlungen gestoppt und auf Richtigkeit kontrolliert. Bei Manipulationen werden Rechtliche Wege eingeleitet. Wir bem&uuml;hen uns Auszahlungen durchzuf&uuml;hren, sind jedoch <strong>nicht verpflichtet</strong> Auszahlungen anzubieten und/oder diese Auszuzahlen. <strong>Wir behalten uns das Recht vor, Auszahlungen nicht durchzuf&uuml;hren und die jeweilige Anzahl an Kryptow&auml;hrungen nicht an die genannte Email-Adresse zu transferieren.</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p><h2>Copyright</h2></p>\n<p><strong>&nbsp;</strong></p>\n<p>&copy; Copyright 2021 &ndash; Urheberrechtshinweis</p>\n<p>&nbsp;</p>\n<p>Alle Inhalte der BitMath Applikation, insbesondere das Logo, Texte und Grafiken, sind urheberrechtlich gesch&uuml;tzt. Das Urheberrecht liegt, soweit nicht ausdr&uuml;cklich anders gekennzeichnet, bei Erdi Karasungur. Bitte fragen Sie uns, falls Sie die Inhalte dieses Internetangebotes verwenden m&ouml;chten.</p>\n<p>&nbsp;</p>\n<p>Wer gegen das Urheberrecht verst&ouml;&szlig;t (z.B. Grafiken oder Texte unerlaubt kopiert), macht sich gem. &sect;&sect; 106 ff UrhG strafbar, wird zudem kostenpflichtig abgemahnt und muss Schadensersatz leisten (&sect; 97 UrhG).</p>\n<p><strong>&nbsp;</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p>Fehler und Irrt&uuml;mer vorbehalten.</p>";
		}
		if (languages.getString("language", "").equals("türkçe")) {
			htmltext2 = "<h1>Kullanım Şartları</h1>\n<p>&nbsp;</p>\n<p>Son g&uuml;ncelleme: 10 Kasım 2021</p>\n<p>&nbsp;</p>\n<p><strong>Şartlar ve koşulların sıkıcı olduğunu biliyoruz ve &ccedil;oğunluk bunlardan ka&ccedil;ınmaya &ccedil;alışıyor</strong>Ancak, hizmetlerimizi kullanmadan &ouml;nce bu genel h&uuml;k&uuml;m ve koşulları dikkatlice okumanızı rica ediyoruz.</p>\n<p>&nbsp;</p>\n<h2>Yorum ve Tanımlar</h2>\n<p><strong>&nbsp;</strong></p>\n<p>İlk harfi b&uuml;y&uuml;k olan kelimeler aşağıdaki koşullar altında tanımlanmış anlamlara sahiptir. Aşağıdaki tanımlar, tekil veya &ccedil;oğul olarak g&ouml;r&uuml;n&uuml;p g&ouml;r&uuml;nmediklerine bakılmaksızın aynı anlama sahiptir.</p>\n<p>&nbsp;</p>\n<p>Bu h&uuml;k&uuml;m ve koşulların ama&ccedil;ları doğrultusunda:</p>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Şartlar ve koşullar</strong> bu genel h&uuml;k&uuml;m ve koşullara bakın</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Madeni Para / Madeni Para </strong>Uygulamada kazanılan ve daha sonra kullanılabilecek puanlara bakın.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Hizmetler</strong> BitMath uygulamasını ifade eder</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>&uuml;lke</strong> Almanya'yı ifade eder</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>sen / sen </strong>Hizmete erişen veya onu kullanan kişiyi veya varsa, bu kişinin adına Hizmetlere eriştiği veya onu kullandığı bir şirket veya başka bir t&uuml;zel kişilik anlamına gelir.</li>\n</ul>\n<p>&nbsp;</p>\n<ul>\n<li><strong>Şirketler </strong>BitMath, ayrıca \"Şirket\", \"Biz\" veya \"Bizim\" anlamına gelir.</li>\n</ul>\n<p>&nbsp;</p>\n<h2>Veri koruması</h2>\n<p><strong>&nbsp;</strong></p>\n<p>Verilerinizin korunması bizim i&ccedil;in &ccedil;ok &ouml;nemlidir.Bir \"&ouml;deme\" sırasında verilen e-posta adresi ve ilgili andaki jeton miktarı dışında hi&ccedil;bir verinizi kaydetmiyoruz. Bu veriler, para &ccedil;ekme işlemi yapıldıktan sonra bir hafta (6 iş g&uuml;n&uuml;) i&ccedil;inde kalıcı olarak silinecek ve kimse tarafından geri alınamayacak.</p>\n<p>&nbsp;</p>\n<h2>&Ouml;demeler</h2>\n<p><strong>&nbsp;</strong></p>\n<p>Madeni paraların &ccedil;ekilmesi yalnızca 1.000 (bin) miktarından m&uuml;mk&uuml;nd&uuml;r. Para &ccedil;ekme işlemleri rastgele kripto para birimlerinde yapılır. Para &ccedil;ekme işlemleri i&ccedil;in &ldquo;Coinbase&rdquo; platformu (sahibi: Coinbase, Inc.) kullanılır. Sorunsuz bir &ouml;deme i&ccedil;in, belirtilen platformda depozitoya ihtiyacınız var. Para &ccedil;ekme işlemi m&uuml;mk&uuml;nse bir hafta (6 iş g&uuml;n&uuml;) i&ccedil;inde yapılacaktır. E-posta adresinin yanlış girilmesinden veya bir Coinbase deposuna sahip olunmamasından kaynaklanan kayıplar teknik olarak iptal edilemez ve bu nedenle geri alınamaz. Madeni para miktarının manip&uuml;lasyonundan ş&uuml;pheleniliyorsa, t&uuml;m &ouml;demeler durdurulur ve doğruluğu kontrol edilir. Manip&uuml;lasyon durumunda yasal işlem yapılır. Para &ccedil;ekme i&ccedil;in &ccedil;alışıyoruz ancak, &ouml;deme teklif etmek ve/veya &ouml;demek zorunda değildir. Belirtilen e-posta adresine ilgili sayıda kripto para &ccedil;ekmeme ve transfer etmeme hakkımız saklıdır.</p>\n<p><strong>&nbsp;</strong></p>\n<h2>Telif hakkı</h2>\n<p><strong>&nbsp;</strong></p>\n<p>&copy; Copyright 2021 - Telif Hakkı Bildirimi</p>\n<p>&nbsp;</p>\n<p>BitMath uygulamasının t&uuml;m i&ccedil;eriği, &ouml;zellikle logo, metinler ve grafikler telif hakkı ile korunmaktadır. Aksi a&ccedil;ık&ccedil;a belirtilmedik&ccedil;e telif hakkı Erdi Karasungur'a aittir. Bu web sitesinin i&ccedil;eriğini kullanmak isteyip istemediğinizi l&uuml;tfen bize sorun.</p>\n<p>&nbsp;</p>\n<p>Telif hakkı yasasını ihlal eden (&ouml;rneğin grafiklerin veya metinlerin izinsiz kopyalanması) herhangi bir kişi &sect;&sect; 106 ff UrhG uyarınca kovuşturmaya tabidir, ayrıca masraflara karşı uyarılır ve tazminat &ouml;demek zorundadır (&sect; 97 UrhG).</p>\n<p><strong>&nbsp;</strong></p>\n<p><strong>&nbsp;</strong></p>\n<p>Hatalar ve eksiklikler hari&ccedil;tir.</p>";
		}
		final AlertDialog db4 = new AlertDialog.Builder(MainActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
		View convertView = (View) inflater.inflate(R.layout.impressum, null);
		db4.setView(convertView);
		db4.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		db4.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		LinearLayout linear1 = (LinearLayout) convertView.findViewById(R.id.linear1);
		
		TextView textview2 = (TextView) convertView.findViewById(R.id.textview2);
		
		TextView textview3 = (TextView) convertView.findViewById(R.id.textview3);
		
		ImageView imageview1 = (ImageView) convertView.findViewById(R.id.imageview1);
		
		ScrollView vscroll1 = (ScrollView) convertView.findViewById(R.id.vscroll1);
		
		vscroll1.setSmoothScrollingEnabled(true);
		
		textview2.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
		
		textview3.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
		
		if (mode.getString("mode", "").equals("dark")) {
				textview2.setTextColor(0xFFFFFFFF);
			
			textview3.setTextColor(0xFFFFFFFF);
			
			_Shape(30, 30, 30, 30, "#424242", 0, "#fbc02d", 0, linear1);
				imageview1.setImageResource(R.drawable.ic_clear_white);
		}
		if (mode.getString("mode", "").equals("light")) {
				textview2.setTextColor(0xFF000000);
			
			textview3.setTextColor(0xFF000000);
			
			_Shape(30, 30, 30, 30, "#ffffff", 0, "#fbc02d", 0, linear1);
				imageview1.setImageResource(R.drawable.ic_close_black);
		}
		
		textview2.setVisibility(View.GONE);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { textview2.setText(Html.fromHtml(htmltext, Html.FROM_HTML_MODE_COMPACT)); } else { textview2.setText(Html.fromHtml(htmltext)); }
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { textview3.setText(Html.fromHtml(htmltext2, Html.FROM_HTML_MODE_COMPACT)); } else { textview3.setText(Html.fromHtml(htmltext2)); }
		
		db4.setCancelable(true);
		imageview1.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
										db4.dismiss();
							}
				});
		
		db4.show();
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}